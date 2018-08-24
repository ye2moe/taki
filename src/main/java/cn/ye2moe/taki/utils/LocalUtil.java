package cn.ye2moe.taki.utils;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.Map;

/**
 * 本地资源工具类
 */
public final class LocalUtil {

    public static String LOCAL_IP = getLocalIp();

    private LocalUtil() {
    }


    public static void getComputerInfo(){
        Map<String,String> map = System.getenv();
        System.out.println(map.get("USERNAME"));//获取用户名
        System.out.println(map.get("COMPUTERNAME"));//获取计算机名
        System.out.println(map.get("USERDOMAIN"));//获取计算机域名
    }

    /**
     * 获取本机ip地址
     * 此方法为重量级的方法，不要频繁调用
     */
    public static String getLocalIp() {
        if (LOCAL_IP != null) {
            return LOCAL_IP;
        }
        try {
            //根据网卡取本机配置的IP
            Enumeration<NetworkInterface> netInterfaces = NetworkInterface.getNetworkInterfaces();
            String ip = null;
            a:
            while (netInterfaces.hasMoreElements()) {
                NetworkInterface ni = netInterfaces.nextElement();
                Enumeration<InetAddress> ips = ni.getInetAddresses();
                while (ips.hasMoreElements()) {
                    InetAddress ipObj = ips.nextElement();
                    if (ipObj.isSiteLocalAddress()) {
                        ip = ipObj.getHostAddress();
                        break a;
                    }
                }
            }
            return ip;
        } catch (Exception e) {
            return null;
        }
    }

    public static void main(String[] args) {
        getComputerInfo();
        long now = System.currentTimeMillis();
        System.out.println(getLocalIp());
        System.out.println( (System.currentTimeMillis() - now)/1000 );
    }

}
