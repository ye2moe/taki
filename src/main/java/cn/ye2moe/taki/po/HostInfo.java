package cn.ye2moe.taki.po;

import java.io.Serializable;

/**
 * @author yezwei（ye2moe@gmail.com）
 * @version 2018/8/23
 * @date 2018/08/23 12:27
 */
public class HostInfo implements Serializable {
    private String name;
    private String ip;
    private String hostName;
    private String innerIP;
    private String mac;
    private Integer port;


    public String getIp() {
        return ip;
    }

    public HostInfo setIp(String ip) {
        this.ip = ip;
        return this;
    }

    public String getName() {
        return name;
    }

    public HostInfo setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getPort() {
        return port;
    }

    public HostInfo setPort(Integer port) {
        this.port = port;
        return this;
    }

    public String getHostName() {
        return hostName;
    }

    public HostInfo setHostName(String hostName) {
        this.hostName = hostName;
        return this;
    }

    public String getInnerIP() {
        return innerIP;
    }

    public HostInfo setInnerIP(String innerIP) {
        this.innerIP = innerIP;
        return this;
    }

    public String getMac() {
        return mac;
    }

    public HostInfo setMac(String mac) {
        this.mac = mac;
        return this;
    }
}
