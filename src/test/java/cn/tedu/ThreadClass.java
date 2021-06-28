package cn.tedu;

import org.apache.flink.streaming.api.transformations.SideOutputTransformation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadClass {
    private static volatile int num = 1;
    private static final int maxNum = 100;


    public static void main(String[] args) {

        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    if (num > maxNum) {
                        break;
                    }
                    if (num % 10 != 0) {
                        if (num % 2 == 1) {
                            System.out.println(Thread.currentThread().getName() + "---------" + num);
                            num++;
                        } else {
                            try {
                                Thread.currentThread().sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    } else {
                        try {
                            Thread.currentThread().sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }


            }}
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {

                    if (num > maxNum) {
                        break;
                    }
                    if (num % 10 != 0) {
                        if (num % 2 == 0) {
                            System.out.println(Thread.currentThread().getName() + "---------" + num);
                            num++;
                        } else {
                            try {
                                Thread.currentThread().sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    } else {
                        try {
                            Thread.currentThread().sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
            }  }
        });

        Thread threadC = new Thread(new Runnable() {

            @Override
            public void run() {
                while (true) {

                    if (num > maxNum) {
                        break;
                    }
                    if (num % 10 == 0) {
                        System.out.println(Thread.currentThread().getName() + "---------" + num);
                        num++;
                    } else {
                        try {
                            Thread.currentThread().sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } }
            }
        });
        threadA.start();
        threadB.start();
        threadC.start();

    }


    /*public static void main(String[] args) {
            String str ="1221";
            int symLen=1;  //总长度
            char[] letter=str.toCharArray();
            int strLen=str.length();
            int curIndex=1;  //索引位置
            while(curIndex>0&&curIndex<strLen-1){
                int i=curIndex-1;
                int j=curIndex+1;
                while(i>=0&&j<=(strLen-1)&&letter[i]==letter[j]){
                    i--;
                    j++;
                }
                int newLen=j-i-1;
                if(newLen>symLen){
                    symLen=newLen;
                }
                //即使是对称的长度，letter[curIndex] 和letter[curIndex+1]
                //如果相等就再判断它的前后两项是否相等
                i=curIndex;
                j=curIndex+1;
                while(i>=0&&j<=(strLen-1)&&letter[i]==letter[j]){
                    i--;
                    j++;
                }
                newLen=j-i-1;
                if(newLen>symLen){
                    symLen=newLen;
                }
                curIndex++;
            }
        System.out.println(symLen);
        }*/


}

