package UtilPackage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 计算俩个日期时间的差值工具类
 */
public class TimeMathUtil {

    private String dateformat;
    private String mathResultType;

    public TimeMathUtil() {
    }

    /**
     * 返回时间差(正值)
     * 计算时,如果返回为分钟,小时,天数由于使用的为int类型,不足一天,一小时,或者一分钟会返回0值。
     * @param dateStr1 时间戳1
     * @param dateStr2 时间戳2
     * @param dateformat 传入时间戳的时间格式 如yyyyMMddHHmmss 或者 yyyyMMdd HH:mm:ss
     * @param mathResultType 默认返回秒值之差,1为分钟,2为小时,3为天数
     * @return
     */
    public String getTimeDelta(String dateStr1, String dateStr2,String dateformat,String mathResultType){
        Date date1=parseDateByPattern(dateStr1, dateformat);
        Date date2=parseDateByPattern(dateStr2, dateformat);
        long num =1000;
        switch (mathResultType){
            case "1": num=num*60;
            break;
            case "2":num=num*60*60;
            break;
            case "3":num=num*60*60*24;
                break;
            default:
                break;
        }
        long timeDelta=(date1.getTime()-date2.getTime())/num;//单位是秒
        int secondsDelta=timeDelta>0?(int)timeDelta:(int)Math.abs(timeDelta);
        return String.valueOf(secondsDelta);
    }


    /**
     * 传入时间戳,根据时间格式转化为Date时间
     * @param dateStr
     * @param dateFormat
     * @return
     */
    public  Date parseDateByPattern(String dateStr,String dateFormat){
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        try {
            return sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        TimeMathUtil timeMathUtil = new TimeMathUtil();
        String  s="20210805132030";
        String s1="20210805123030";
        String timeDelta = timeMathUtil.getTimeDelta(s, s1,"yyyyMMddHHmmss","1");
        System.out.println(timeDelta);
    }

}
