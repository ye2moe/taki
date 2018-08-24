package cn.ye2moe.taki.common;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class HMACSHA256 {
    //   SECRET KEY
    private final static String secret_key = "ndE2jdZNFixH9G6Aidsfyf7lYT3PxW";

    /**
     * 将加密后的字节数组转换成字符串
     *
     * @param b 字节数组
     * @return 字符串
     */
    private static String byteArrayToHexString(byte[] b) {
        StringBuilder hs = new StringBuilder();
        String stmp;
        for (int n = 0; b != null && n < b.length; n++) {
            stmp = Integer.toHexString(b[n] & 0XFF);
            if (stmp.length() == 1)
                hs.append('0');
            hs.append(stmp);
        }
        return hs.toString().toLowerCase();
    }

    private static final String HMAC_SHA1 = "HmacSHA1";
    /**
     * sha256_HMAC加密
     *
     * @return 加密后字符串
     */
    public static String hmacSHA1(String signatureReqStr, String secretKey)   {
        SecretKeySpec signingKey = new SecretKeySpec(secretKey.getBytes(), HMAC_SHA1);
        Mac mac = null;
        try {
            mac = Mac.getInstance(HMAC_SHA1);
            mac.init(signingKey);
            byte[] rawHmac = mac.doFinal(signatureReqStr.getBytes());
            return MD5.encode(rawHmac);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }
        return "";
    }

}