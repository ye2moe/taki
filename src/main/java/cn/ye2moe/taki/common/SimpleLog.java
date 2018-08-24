package cn.ye2moe.taki.common;

import cn.ye2moe.taki.utils.ConcurrentDateUtil;

/**
 * @author yezwei（ye2moe@gmail.com）
 * @version 2018/8/23
 * @date 2018/08/23 16:14
 */
public class SimpleLog {
    private static boolean IS_DEBUG = false;

    public static void enableDebug() {
        SimpleLog.IS_DEBUG = true;
    }

    public static void info(String title, String message) {
        commonOut("info", title, message);
    }

    public static void debug(String title, String message) {
        if (!IS_DEBUG) return;
        commonOut("debug", title, message);
    }

    public static void warn(String title, String message) {
        commonOut("warn", title, message);
    }

    public static void error(String title, String message) {
        commonOut("error", title, message);
    }

    private static void commonOut(String level, String title, String message) {
        System.out.println(String.format("%s\t%s\t【%s】\t%s", ConcurrentDateUtil.now(), level, title, message));
    }

}
