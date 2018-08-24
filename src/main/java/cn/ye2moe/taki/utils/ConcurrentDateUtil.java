package cn.ye2moe.taki.utils;

import com.sun.jmx.snmp.Timestamp;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConcurrentDateUtil {

    private static ThreadLocal<DateFormat> threadLocal = new ThreadLocal<DateFormat>() {
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };

    public static Date parse(String dateStr) throws ParseException {
        return threadLocal.get().parse(dateStr);
    }

    public static Integer timestamp(Date time) {
        Timestamp ts = new Timestamp(time.getTime());

        return (int) ((ts.getDateTime())/1000);
    }


    public static String format(Date date) {
        return threadLocal.get().format(date);
    }

    public static String now() {
        return format(new Date());
    }
}