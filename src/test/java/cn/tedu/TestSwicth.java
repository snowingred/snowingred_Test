package cn.tedu;

import java.util.ArrayList;

public class TestSwicth {
    public static void main(String[] args) {
        int type = 0;
        switch (type){
            case 0:
                System.out.println("0");
                break;
            case 1:
                System.out.println("1");
                break;
            case 2:
                System.out.println("2");
                break;
            default:
                System.out.println();
        }
        ArrayList<Long> longs = new ArrayList<>();
        System.out.println(longs.size());
    }
}
