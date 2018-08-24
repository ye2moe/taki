package cn.ye2moe.taki.client;

import cn.ye2moe.taki.common.ParamBuilder;
import cn.ye2moe.taki.common.Result;
import cn.ye2moe.taki.common.SimpleLog;
import cn.ye2moe.taki.http.HttpClient;
import cn.ye2moe.taki.po.HostInfo;
import cn.ye2moe.taki.utils.LocalUtil;
import com.google.gson.Gson;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author yezwei（ye2moe@gmail.com）
 * @version 2018/8/23
 * @date 2018/08/23 14:03
 */
public class Client {

    ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(1,
            new BasicThreadFactory.Builder().namingPattern("now-schedule-pool-%d").daemon(true).build());

    public Client(String name, long updateFrequency) {
        SimpleLog.info("客户端启动", name + ":" + updateFrequency);
        CountDownLatch cdl = new CountDownLatch(1);
        executorService.scheduleAtFixedRate(new UpdateScheduling(name), updateFrequency, updateFrequency, TimeUnit.SECONDS);
        try {
            cdl.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] argv) {
        String name = "test";
        long frequency = 5;
        if (argv.length >= 1) {
            name = argv[0];
        }
        if (argv.length >= 2) {
            frequency = Long.parseLong(argv[1]);
        }
        new Client(name, frequency);
    }


    class UpdateScheduling implements Runnable {
        private String lastIP = "127.0.0.1";
        private String netIP = "127.0.0.1";
        private String name;

        List<String> apis;

        private volatile boolean isAllApiKDie = false;

        public UpdateScheduling(String taskName) {
            this.name = taskName;
            String[] temp = {"http://api.k780.com/?app=ip.local&appkey=10003&sign=b59bc3ef6191eb9f747dd4e83c99f2a4&format=json",
                    "http://api.k780.com/?app=ip.local&appkey=36153&sign=96126012c587f4e8ca97b3830110330c&format=json"};
            apis = Arrays.asList(temp);
        }

        public void run() {
            String ip = LocalUtil.getLocalIp();
            if (ip == null) {
                SimpleLog.error("can't access network", "");
                return;
            }
            if (!lastIP.equals(ip)) {
                SimpleLog.warn("local IP change", lastIP + " => " + ip);
                lastIP = ip;
            }
            HostInfo hi = new HostInfo()
                    .setName(name)
                    .setInnerIP(ip);

            if (!isAllApiKDie) {
                APIKResult result = apik();
                if (result != null && result.getSuccess() == Result.SUCCESS_CODE) {
                    if (!netIP.equals(result.getResult().getIp())) {
                        SimpleLog.warn("network IP change", netIP + " => " + result.getResult().getIp());
                        netIP = result.getResult().getIp();
                        hi.setIp(netIP);
                        update(hi);
                    }
                    return;
                }
            } else {
                Result result = HttpClient.doGet("http://ye2moe.cn:8000/apik", Result.class);
                if (result.getCode() == Result.SUCCESS_CODE) {
                    apis = (List) result.getData();
                    SimpleLog.info("APIK 接口已更新", " => 等待调用");
                    isAllApiKDie = false;
                }
            }

            update(hi);
        }


        public APIKResult apik() {
            String ip = "";
            for (String api : apis) {
                String json = HttpClient.doGet(api);
                APIKResult apikResult = new Gson().fromJson(json, APIKResult.class);

                if (apikResult.getSuccess() == 1) {
                    //成功
                    return apikResult;
                }
            }
            //{"success":"1","result":{"ip":"222.76.251.162","proxy":"1","att":"中国,福建,厦门","operators":"电信"}}
            SimpleLog.warn("APIK 接口已全部失效！！！", " => 暂时调整为使用自己服务器");
            isAllApiKDie = true;
            return null;
        }

        public void update(HostInfo hi) {
            String url = new ParamBuilder("http://ye2moe.cn:8000/ip/record?")
                    .put("host", hi.getName())
                    .and().put("innerIP", hi.getInnerIP())
                    .build();

            String json = HttpClient.doGet(url);
            SimpleLog.info("push to server", "recv: " + json);
            Result<String> result = new Gson().fromJson(json, Result.class);
            if (result.getCode() == Result.SUCCESS_CODE) {
                SimpleLog.warn("network IP change", netIP + " => " + result.getData());
                netIP = result.getData();
            }

        }


    }


}
