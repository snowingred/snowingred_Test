package cn.tedu;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestTimeString {
    public static void main(String[] args) {
        String s="20210805112030";
        String s1="20210805123030";
        Date date1=parseDateByPattern(s, "yyyyMMddHHmmss");
        Date date2=parseDateByPattern(s1, "yyyyMMddHHmmss");
        long timeDelta=(date1.getTime()-date2.getTime())/1000;//单位是秒
        int secondsDelta=timeDelta>0?(int)timeDelta:(int)Math.abs(timeDelta);
        System.out.println(secondsDelta);
    }

    public static Date parseDateByPattern(String dateStr,String dateFormat){
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        try {
            return sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
