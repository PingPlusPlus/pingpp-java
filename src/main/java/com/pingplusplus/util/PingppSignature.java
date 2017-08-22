package com.pingplusplus.util;

import com.pingplusplus.Pingpp;
import org.apache.commons.codec.binary.Base64;

import sun.security.util.DerInputStream;
import sun.security.util.DerValue;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.RSAPrivateCrtKeySpec;

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

            return Base64.encodeBase64String(signBytes).replaceAll("\n|\r", "");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (SignatureException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
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
            return generatePrivateKeyWithPKCS1(privateKeyBytes);
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

    public static PrivateKey generatePrivateKeyWithPKCS1(byte[] privateKeyBytes) {
        try {
            DerInputStream derReader = new DerInputStream(privateKeyBytes);
            DerValue[] seq = derReader.getSequence(0);
            if (seq.length < 9) {
                System.out.println("Could not parse a PKCS1 private key.");
                return null;
            }
            // skip version seq[0];
            BigInteger modulus = seq[1].getBigInteger();
            BigInteger publicExp = seq[2].getBigInteger();
            BigInteger privateExp = seq[3].getBigInteger();
            BigInteger prime1 = seq[4].getBigInteger();
            BigInteger prime2 = seq[5].getBigInteger();
            BigInteger exp1 = seq[6].getBigInteger();
            BigInteger exp2 = seq[7].getBigInteger();
            BigInteger crtCoef = seq[8].getBigInteger();
            RSAPrivateCrtKeySpec spec = new RSAPrivateCrtKeySpec(
                    modulus, publicExp, privateExp, prime1, prime2, exp1, exp2, crtCoef);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");

            return keyFactory.generatePrivate(spec);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }

        return null;
    }
}
