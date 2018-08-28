package cn.ye2moe.taki.utils;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.URL;
import java.security.cert.CertificateException;

/**
 * @author yezwei
 * @version 2018/8/28
 * @date 2018/08/28 14:18
 */
public class Https {

    public static String get(String url) {
        String ret = "";
        HttpsURLConnection connection = null;
        OutputStream os = null;
        OutputStreamWriter osw = null;
        InputStream is = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        try {
            URL su = new URL(url);
            connection = (HttpsURLConnection) su.openConnection();
            javax.net.ssl.SSLContext ctx =
                    javax.net.ssl.SSLContext.getInstance("TLS");
            ctx.init(null, new javax.net.ssl.TrustManager[]{new
                    javax.net.ssl.X509TrustManager() {
                        public void checkClientTrusted(
                                java.security.cert.X509Certificate[] arg0, String arg1)
                                throws CertificateException {
                        }

                        public void checkServerTrusted(
                                java.security.cert.X509Certificate[] arg0, String arg1)
                                throws CertificateException {
                        }

                        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                            return null;
                        }
                    }}, null);
            connection.setSSLSocketFactory(ctx.getSocketFactory());
            connection.setHostnameVerifier(new HostnameVerifier() {
                public boolean verify(String hostname, javax.net.ssl.SSLSession
                        session) {
                    return true;
                }
            });
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            connection.setRequestMethod("GET");
            connection.setDoOutput(true);
            connection.setDoInput(true);
            is = connection.getInputStream();
            isr = new InputStreamReader(is, "UTF-8");
            br = new BufferedReader(isr);
            for (String line = br.readLine(); line != null; line = br
                    .readLine())
                ret += line + "\r\n";
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if (osw != null)
                osw.close();
        } catch (Exception e) {
        }
        try {
            if (os != null)
                os.close();
        } catch (Exception e) {
        }
        try {
            if (br != null)
                br.close();
        } catch (Exception e) {
        }
        try {
            if (isr != null)
                isr.close();
        } catch (Exception e) {
        }
        try {
            if (is != null)
                is.close();
        } catch (Exception e) {
        }
        try {
            if (connection != null)
                connection.disconnect();
        } catch (Exception e) {
        }
        return ret;
    }

}
