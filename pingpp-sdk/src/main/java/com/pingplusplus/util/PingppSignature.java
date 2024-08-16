package com.pingplusplus.util;

import com.pingplusplus.Pingpp;
import com.pingplusplus.exception.AuthenticationException;
import com.pingplusplus.net.HttpHeaders;
import org.apache.commons.codec.binary.Base64;

import java.io.UnsupportedEncodingException;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * Created by Afon on 2016/12/16.
 */
public class PingppSignature {
    public static String sign(String data, String PEMEncodedPrivateKey, String charset) {
        PrivateKey privateKey = getPrivateKeyFromPEM(PEMEncodedPrivateKey);
        if (privateKey == null) {
            return null;
        }

        try {
            Signature signature = Signature.getInstance("SHA256withRSA");
            signature.initSign(privateKey);
            signature.update(data.getBytes(charset));
            byte[] signBytes = signature.sign();

            return Base64.encodeBase64String(signBytes).replaceAll("[\n\r]", "");
        } catch (NoSuchAlgorithmException | InvalidKeyException | SignatureException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * webhook verify
     * @param encodedSign
     * @param data
     * @param PEMEncodedPublicKey
     * @param charset
     * @return
     * @throws AuthenticationException
     */
    public static boolean verify(String encodedSign, String data, String PEMEncodedPublicKey, String charset) throws AuthenticationException {
        if (StringUtils.isBlank(PEMEncodedPublicKey)) {
            return true;
        }
        PublicKey publicKey = getPublicKeyFromPEM(PEMEncodedPublicKey);
        if (publicKey == null) {
            return true;
        }
        if (StringUtils.isBlank(encodedSign)) {
            throw new AuthenticationException("响应签名 (X-Pingplusplus-Signature) 为空");
        }
        try {
            Signature signature = Signature.getInstance("SHA256withRSA");
            signature.initVerify(publicKey);
            signature.update(data.getBytes(charset));
            return signature.verify(Base64.decodeBase64(encodedSign));
        } catch (InvalidKeyException | UnsupportedEncodingException | SignatureException | NoSuchAlgorithmException e) {
            if (Pingpp.DEBUG) {
                e.printStackTrace();
            }
            return false;
        }
    }

    public static boolean verify(HttpHeaders headers, String data, String PEMEncodedPublicKey, String charset) throws AuthenticationException {
        if (StringUtils.isBlank(PEMEncodedPublicKey)) {
            return true;
        }
        PublicKey publicKey = getPublicKeyFromPEM(PEMEncodedPublicKey);
        if (publicKey == null) {
            return true;
        }
        if (!headers.firstValue("X-Pingplusplus-Signature").isPresent()) {
            throw new AuthenticationException("响应签名 (X-Pingplusplus-Signature) 为空");
        }
        String encodedSign = headers.firstValue("X-Pingplusplus-Signature").get();
        try {
            Signature signature = Signature.getInstance("SHA256withRSA");
            signature.initVerify(publicKey);
            signature.update(data.getBytes(charset));
            return signature.verify(Base64.decodeBase64(encodedSign));
        } catch (InvalidKeyException | UnsupportedEncodingException | SignatureException | NoSuchAlgorithmException e) {
            if (Pingpp.DEBUG) {
                e.printStackTrace();
            }
            return false;
        }
    }


    public static PrivateKey getPrivateKeyFromPEM(String PEMEncodedPrivateKey) {
        PEMEncodedPrivateKey = PEMEncodedPrivateKey
                .replaceAll("(-+BEGIN (RSA )?PRIVATE KEY-+\\r?\\n|-+END (RSA )?PRIVATE KEY-+\\r?\\n?)", "");
        byte[] privateKeyBytes = Base64.decodeBase64(PEMEncodedPrivateKey);
        
        try {
            return generatePrivateKeyWithPKCS8(privateKeyBytes);
        } catch (InvalidKeySpecException e) {
            if (Pingpp.DEBUG) {
                e.printStackTrace();
            }
            return null;
        }
    }

    public static PrivateKey generatePrivateKeyWithPKCS8(byte[] privateKeyBytes)
            throws InvalidKeySpecException {
        try {
            PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(privateKeyBytes);
            KeyFactory kf = KeyFactory.getInstance("RSA");
            return kf.generatePrivate(keySpec);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static PublicKey getPublicKeyFromPEM(String PEMEncodedPublicKey) {
        PEMEncodedPublicKey = PEMEncodedPublicKey
                .replaceAll("(-+BEGIN (RSA )?PUBLIC KEY-+\\r?\\n|-+END (RSA )?PUBLIC KEY-+\\r?\\n?)", "");
        byte[] publicKeyBytes = Base64.decodeBase64(PEMEncodedPublicKey);

        try {
            return generatePublicKey(publicKeyBytes);
        } catch (InvalidKeySpecException e) {
            if (Pingpp.DEBUG) {
                e.printStackTrace();
            }
            return null;
        }
    }

    public static PublicKey generatePublicKey(byte[] publicKeyBytes)
            throws InvalidKeySpecException {
        try {
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(publicKeyBytes);
            KeyFactory kf = KeyFactory.getInstance("RSA");
            return kf.generatePublic(keySpec);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
}
