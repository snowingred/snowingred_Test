package cn.tedu;

import java.util.Calendar;
import java.util.Date;

public class TestTime {
    public static void main(String[] args) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(new Date());
        instance.add(13,50);
        System.out.println(instance.getTime());;

    }
}
