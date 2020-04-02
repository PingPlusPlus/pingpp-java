package com.pingplusplus.util;

import com.pingplusplus.Pingpp;
import org.apache.commons.codec.binary.Base64;

import java.io.UnsupportedEncodingException;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;

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
}
