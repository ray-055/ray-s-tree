package com.ray.blog.util;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class AesUtil {
    private static final String KEY = "AES";
    private static final String ALGORITHM = "AES/ECB/PKCS5Padding";

    public static String encrypt(String password, String content) throws Exception{
        Cipher cipher = Cipher.getInstance(ALGORITHM);

        byte[] bytecontent = content.getBytes("utf-8");

        cipher.init(Cipher.ENCRYPT_MODE, getsecretKey(password));

        byte[] result = cipher.doFinal(bytecontent);

        return Base64.encodeBase64String(result);
    }

    public static String decrypt(String password, String encrypted) throws Exception{
        Cipher cipher = Cipher.getInstance(ALGORITHM);

        cipher.init(Cipher.DECRYPT_MODE, getsecretKey(password));

        byte[] result = cipher.doFinal(Base64.decodeBase64(encrypted));

        return new String(result, "utf-8");
    }

    private static SecretKeySpec getsecretKey(final String password) throws NoSuchAlgorithmException {
        //返回生成指定算法密钥生成器的 KeyGenerator 对象
        KeyGenerator kg = KeyGenerator.getInstance(ALGORITHM);
        // javax.crypto.BadPaddingException: Given final block not properly padded解决方案
        // https://www.cnblogs.com/zempty/p/4318902.html - 用此法解决的
        // https://www.cnblogs.com/digdeep/p/5580244.html - 留作参考吧
        SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
        random.setSeed(password.getBytes());
        //AES 要求密钥长度为 128
        kg.init(128, random);

        //生成一个密钥
        SecretKey secretKey = kg.generateKey();
        // 转换为AES专用密钥
        return new SecretKeySpec(secretKey.getEncoded(), ALGORITHM);
    }
}
