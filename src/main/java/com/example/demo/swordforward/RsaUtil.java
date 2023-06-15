package com.znlh.kgl.bussiness.gpsUtil;

import lombok.extern.slf4j.Slf4j;

import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * 功能描述：
 *
 * @author zhaojun
 * @Date 2023/1/6
 */

@Slf4j
public class RsaUtil {

    private static final char[] bcdLookup = {'0', '1', '2', '3', '4', '5',
            '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    private static String pri = null;
    private static String pub = null;

    /**
     * 产生私钥公钥对
     */
    public static void createKeyPair() {

        KeyPairGenerator rsaKeyGen;
        KeyPair rsaKeyPair;
        try {
            rsaKeyGen = KeyPairGenerator.getInstance("RSA");
            SecureRandom random = new SecureRandom();
            random.setSeed(System.currentTimeMillis());

            rsaKeyGen.initialize(2048, random);

            rsaKeyPair = rsaKeyGen.genKeyPair();
            PublicKey rsaPublic = rsaKeyPair.getPublic();
            PrivateKey rsaPrivate = rsaKeyPair.getPrivate();

            pub = bytesToHexStr(rsaPublic.getEncoded());
            pri = bytesToHexStr(rsaPrivate.getEncoded());
            log.info("pub: {}", pub);
            log.info("pri: {}", pri);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    private static String bytesToHexStr(byte[] bcd) {

        StringBuffer s = new StringBuffer(bcd.length * 2);
        for (int i = 0; i < bcd.length; i++) {
            s.append(bcdLookup[(bcd[i] >>> 4) & 0x0f]);
            s.append(bcdLookup[bcd[i] & 0x0f]);
        }
        return s.toString();
    }

    private static byte[] hexStrToBytes(String s) {

        byte[] bytes;
        bytes = new byte[s.length() / 2];
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) Integer.parseInt(s.substring(2 * i, 2 * i + 2),
                    16);
        }
        return bytes;
    }

    /**
     * 私钥加密
     *
     * @param privateKey 用户的私钥
     * @param content    要进行签名的字符串
     * @return 签名
     */
    public static String generateSignature(String privateKey, String content) {

        try {
            Signature signature = Signature.getInstance("SHA256withRSA");
            byte[] privateKeyByte = hexStrToBytes(privateKey.trim());
            PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(privateKeyByte);
            KeyFactory fac = KeyFactory.getInstance("RSA");
            RSAPrivateKey priKey = (RSAPrivateKey) fac
                    .generatePrivate(keySpec);
            signature.initSign(priKey);
            signature.update(content.getBytes(StandardCharsets.UTF_8));
            byte[] signatureBytes = signature.sign();
            return bytesToHexStr(signatureBytes);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    public static void main(String[] args) {
        createKeyPair();
    }

    /**
     * 公钥验签
     *
     * @param publicKey
     * @param content
     * @param sign
     * @return
     */
    public static boolean verifySign(String publicKey, String content, String sign) {

        try {
            Signature signature = Signature.getInstance("SHA256withRSA");
            byte[] publicKeyByte = hexStrToBytes(publicKey.trim());
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(publicKeyByte);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PublicKey pubKey = keyFactory.generatePublic(keySpec);
            signature.initVerify(pubKey);
            signature.update(content.getBytes(StandardCharsets.UTF_8));
            boolean verify = signature.verify(hexStrToBytes(sign));
            return verify;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return false;
    }

}
