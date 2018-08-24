package cn.ye2moe.taki.http;

import cn.ye2moe.taki.common.BASE64Encoder;
import cn.ye2moe.taki.common.HMACSHA1;
import cn.ye2moe.taki.common.ParamBuilder;
import cn.ye2moe.taki.utils.ConcurrentDateUtil;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

/**
 * @author yezwei（ye2moe@gmail.com）
 * @version 2018/8/23
 * @date 2018/08/23 10:57
 */


public class Http {
    public static void main(String[] argv) {
        /*
        String get = HttpClient.doGet("http://127.0.0.1:8000/ip/record?host=home");
        System.out.println(get);
        get = HttpClient.doGet("http://127.0.0.1:8000/ip/all");
        System.out.println(get);
        get = HttpClient.doGet("http://127.0.0.1:8000/ip/check?host=home");
        System.out.println(get);

        */

        tencentCloudAPI("cvm", "DescribeInstances");

        HashMap <String,String> params = new HashMap<>();
        //params.put("Action","RecordList");
        //params.put("offset","0");
       // params.put("length","20");
        params.put("domain","ye2moe.cn");

        tencentCloudAPI("cns", "RecordList" , params);
        //tencentAPI("cns", "DescribeInstances", params);
        //tencentAPI("cns", "DescribeInstances", params);

    }

    public static void tencentCloudAPI(String host, String action) {
        tencentCloudAPI(host, action, null);
    }

    public static void tencentCloudAPI(String host, String action, HashMap params) {

        Random random = new Random(System.currentTimeMillis());
        int nonce = (int) Math.pow((float) random.nextInt(400), 2);
        int timestamp = ConcurrentDateUtil.timestamp(new Date());

        String val = new ParamBuilder(host + ".api.qcloud.com/v2/index.php?")
                .put("Action", action)
                .and().put("Nonce", nonce)
                .and().put("Region", "ap-shanghai")
                .and().put("SecretId", "AKIDT8ctzt37TlsqdInphT6XlndNvUr2Bsa7")
                .and().put("SignatureMethod", "HmacSHA1")
                .and().put("Timestamp", timestamp)
                .build();

        String msg = "GET" + val;
        System.out.println("signature  " + msg);

        String secretKey = "c4MTREpETXO3ZuxpVzHRQDqJaeXEj4E3";
        String signature = new BASE64Encoder().encode(HMACSHA1.getHmacSHA1(msg, secretKey));
        System.out.println("BASE64Encoder：" + signature);

        String urlCode = null;
        try {
            urlCode = URLEncoder.encode(signature, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return;
        }
        System.out.println("urlCode：" + urlCode);

        String url = new ParamBuilder("https://" + host + ".api.qcloud.com/v2/index.php?")
                .put("Action", action)
                .and().put("SecretId", "AKIDT8ctzt37TlsqdInphT6XlndNvUr2Bsa7")
                .and().put("Region", "ap-shanghai")
                .and().put("Timestamp", timestamp)
                .and().put("Nonce", nonce)
                .and().put("Signature", urlCode)
                .and().put("SignatureMethod", "HmacSHA1")
                .and().putAll(params)
                //.and().put("domain" , URLEncoder.encode("111.231.133.158","UTF-8"))
                .build();

        //String json = HttpsClient.get(url);

        System.out.println(url);

    }
}
