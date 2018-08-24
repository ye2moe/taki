package cn.ye2moe.taki.controller;

import cn.ye2moe.moeye.core.annotation.bean.Controller;
import cn.ye2moe.moeye.web.annotation.*;
import cn.ye2moe.taki.common.Result;
import cn.ye2moe.taki.po.HostInfo;
import com.google.gson.Gson;

import java.net.InetSocketAddress;
import java.util.Collection;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author yezwei（ye2moe@gmail.com）
 * @version 2018/8/23
 * @date 2018/08/23 11:00
 */
@Controller
@RequestMapping("ip")
public class IpRecordController {
    ConcurrentHashMap<String,HostInfo> ipRecord = new ConcurrentHashMap(16);

    @RequestMapping("all")
    @ResponseBody
    public Collection<HostInfo> all() {
        return ipRecord.values();
    }

    @RequestMapping("record")
    @ResponseBody
    public Result ip(@RequestParam("host") String host ,
                     @RequestParam(value = "localIP" ,require = false ,defaultValue = "127.0.0.1") String localIP ,
                     @IP String ip ,
                     @SocketAddress InetSocketAddress socketAddress
                      ) {
        //TODO 唯一保证  ipRecord.get(host).getMac()
        HostInfo info = new HostInfo()
                .setName(host)
                .setIp(ip)
                .setPort(socketAddress.getPort())
                .setInnerIP(localIP)
                .setMac(UUID.randomUUID().toString());
        ipRecord.put(host , info);
        return Result.SUCCESS.setData(ip);
    }

    @RequestMapping("check")
    @ResponseBody
    public Result check(@RequestParam("host") String host ) {
        if(ipRecord.containsKey(host)){
            return Result.FAIL;
        }else {
            return Result.SUCCESS;
        }
    }





}
