package ir.daak.base.util;

import javax.xml.bind.DatatypeConverter;
import java.security.*;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.Random;

public class Security {
    public static String SHA256(String str) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] byteArr = Convert.str2ByteArr(str);
            byte[] res = md.digest(byteArr);
            return Convert.byteArr2Str(res);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getAlgorithmFromOid(String signAlgorithm, String hashAlgorithm) throws Exception {
        switch (signAlgorithm) {
            case "1.2.840.113549.1.1.11":
                signAlgorithm = "RSA";
                break;
            default:
                signAlgorithm = null;
                break;
        }
        switch (hashAlgorithm) {
            case "2.16.840.1.101.3.4.2.1":
                hashAlgorithm = "SHA256";
                break;
            default:
                hashAlgorithm = null;
                break;
        }
        if (signAlgorithm == null || hashAlgorithm == null) {
            throw new Exception();
        }
        return hashAlgorithm + "WITH" + signAlgorithm;
    }

    public static String sign(KeyStore keyStore, String password, String alias, String toBeSignedData, String signatureAlgorithm, String hashAlgorithm) {
        try {
            PrivateKey privateKey;
            Key key = keyStore.getKey(alias, password.toCharArray());
            if (key instanceof PrivateKey) {
                privateKey = (PrivateKey) key;
                String algorithm = getAlgorithmFromOid(signatureAlgorithm, hashAlgorithm);
                Signature signer = Signature.getInstance(algorithm);
                signer.initSign(privateKey);
                signer.update(toBeSignedData.getBytes());
                byte[] signature = signer.sign();
                String sign = Convert.byteArrayToBase64(signature);
                return sign;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String readCertificateFromKeyStore(KeyStore keyStore, String password, String alias) {
        try {
            X509Certificate cert = (X509Certificate) keyStore.getCertificate(alias);
            return DatatypeConverter.printHexBinary(cert.getEncoded());
        } catch (KeyStoreException e) {
            e.printStackTrace();
        } catch (CertificateEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Long createNonce() {
        String nonceStr = "0";
        for (int i = 1; i < 16; i++)
            nonceStr += Integer.toString(new Random().nextInt(15), 16);
        return Long.parseUnsignedLong(nonceStr, 16);
    }
}
