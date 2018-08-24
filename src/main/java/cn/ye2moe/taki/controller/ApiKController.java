package cn.ye2moe.taki.controller;

import cn.ye2moe.moeye.core.annotation.bean.Controller;
import cn.ye2moe.moeye.web.annotation.RequestMapping;
import cn.ye2moe.moeye.web.annotation.RequestParam;
import cn.ye2moe.moeye.web.annotation.ResponseBody;
import cn.ye2moe.taki.common.Result;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.PatternSyntaxException;

/**
 * 获得apik 的 ip 查询 接口
 *
 * @author yezwei（ye2moe@gmail.com）
 * @version 2018/8/23
 * @date 2018/08/23 16:10
 */
@Controller
public class ApiKController {

    List<String> APIS = Arrays.asList(
            "http://api.k780.com/?app=ip.local&appkey=36153&sign=96126012c587f4e8ca97b3830110330c&format=json");

    @RequestMapping("apik")
    @ResponseBody
    public Result apik() {
        return Result.SUCCESS.setData(APIS);
    }

    @RequestMapping("apik/update")
    @ResponseBody
    public Result apikUpdate(@RequestParam("apis") String apis, @RequestParam(value = "flush", require = false, defaultValue = "1") String flush) {
        List<String> pList = null;
        try {
            pList = Arrays.asList(apis.split(";"));
        } catch (PatternSyntaxException e) {
            return Result.FAIL.setData(e.getMessage());
        }
        synchronized (APIS) {
            if ("1".equals(flush)) {
                APIS = pList;
            } else {
                APIS.addAll(pList);
            }
        }
        return Result.SUCCESS.setData(APIS.size());
    }
}
