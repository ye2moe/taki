package cn.ye2moe.taki;

import cn.ye2moe.moeye.core.MoeyeApplication;
import cn.ye2moe.moeye.core.annotation.AutoConfig;
import cn.ye2moe.moeye.core.annotation.server.WebServer;

@WebServer("8000")
@AutoConfig
public class Application {

    public static void main(String[] args) {
        MoeyeApplication.run(Application.class, args);
    }

}