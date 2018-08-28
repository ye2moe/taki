package cn.ye2moe.taki.utils;

import cn.ye2moe.taki.common.*;
import com.google.gson.Gson;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.URL;
import java.net.URLEncoder;
import java.security.cert.CertificateException;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

/**
 * 腾讯云API
 *
 * @author yezwei（ye2moe@gmail.com）
 * @version 2018/8/23
 * @date 2018/08/23 10:57
 */


public class TenCloudAPI {

    public static final String GET = "GET";
    public static final String POST = "POST";

    public static final String CNS = "cns";

    private static final String SECRET_KEY = "c4MTREpETXO3ZuxpVzHRQDqJaeXEj4E3";
    private static final String SECRET_ID = "AKIDT8ctzt37TlsqdInphT6XlndNvUr2Bsa7";

    private String url;

    public Result getResult() {
        if (url == null || "".equals(url)) return Result.FAIL;
        String json = Https.get(url);
        return new Gson().fromJson(json, Result.class);
    }

    public TenCloudAPI(String host, String action) {
        makeUrl(GET, host, action, null);
    }

    public TenCloudAPI(String host, String action, HashMap params) {
        makeUrl(GET, host, action, params);
    }

    public TenCloudAPI(String method, String host, String action, HashMap params) {
        makeUrl(method, host, action, params);
    }

    public String getUrl(){
        return url;
    }
    private void makeUrl(String method, String host, String action, HashMap params) {
        Random random = new Random(System.currentTimeMillis());
        int nonce = (int) Math.pow((float) random.nextInt(400), 2);
        int timestamp = ConcurrentDateUtil.timestamp(new Date());

        String val = new ParamBuilder(host + ".api.qcloud.com/v2/index.php?")
                .put("Action", action)
                .and().put("Nonce", nonce)
                .and().put("Region", "ap-shanghai")
                .and().put("SecretId", SECRET_ID)
                .and().put("SignatureMethod", "HmacSHA1")
                .and().put("Timestamp", timestamp)
                .putAll(params)
                .build();

        String msg = method + val;
        SimpleLog.debug("signature", msg);


        String signature = new BASE64Encoder().encode(HMACSHA1.getHmacSHA1(msg, SECRET_KEY));
        SimpleLog.debug("BASE64Encoder", signature);

        String urlCode = null;
        try {
            urlCode = URLEncoder.encode(signature, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        SimpleLog.debug("urlCode", urlCode);

        String url = new ParamBuilder("https://" + host + ".api.qcloud.com/v2/index.php?")
                .put("Action", action)
                .and().put("SecretId", SECRET_ID)
                .and().put("Region", "ap-shanghai")
                .and().put("Timestamp", timestamp)
                .and().put("Nonce", nonce)
                .and().put("Signature", urlCode)
                .and().put("SignatureMethod", "HmacSHA1")
                .putAll(params)
                .build();

        SimpleLog.debug("url", url);
        this.url = url;
    }

}
