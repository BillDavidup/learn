package com.bill.learn.base.common.tool;



import org.springframework.security.crypto.codec.Utf8;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {

    private MD5Util() {

    }

    private static char[] md5String = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};

    public static String md5(String data) {

        byte[] pwd = Utf8.encode(data);

        try {
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            mdInst.update(pwd);

            byte[] md = mdInst.digest();
            int j = md.length;
            char[] str = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = md5String[byte0 >>> 4 & 0xf];
                str[k++] = md5String[byte0 & 0xf];
            }

            return new String(str);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static String md5UpperCase(String data) {

        byte[] pwd = Utf8.encode(data.trim().toUpperCase());

        try {
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            mdInst.update(pwd);

            byte[] md = mdInst.digest();
            int j = md.length;
            char[] str = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = md5String[byte0 >>> 4 & 0xf];
                str[k++] = md5String[byte0 & 0xf];
            }

            return new String(str);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}