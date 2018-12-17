package cn.edu.nju.jlxy.accounting.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

/**
 * @author WuRJ
 * @Description
 * @time 2018-12-17 20:25
 */
public class DateUtil {
    //unix time->标准时间

    public static String getFormattedTime(long timestamp){
        SimpleDateFormat format=new SimpleDateFormat("HH:mm");
        return format.format(new Date(timestamp));
    }

    //标准日期

    public static String getFormattedDate(){
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        return format.format(new Date());
    }
}
