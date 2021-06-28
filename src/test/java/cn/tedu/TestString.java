package cn.tedu;


import sun.misc.Unsafe;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class TestString {
//  intern
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(5);
//      Unsafe U = Unsafe.getUnsafe();
        atomicInteger.compareAndSet(5,2019);
        atomicInteger.compareAndSet(5,2020);
        System.out.println(atomicInteger);

//        U.c(5,2020);

        String a="1";
        String b="1";
        System.out.println(a.equals(b));
        System.out.println(a==b);
        String c=new String("1");
        System.out.println(a.equals(c));
        System.out.println(a==c);
        String intern = c.intern();
        System.out.println(a.equals(intern));
        System.out.println(a==intern);



        long a1=-152584000;
        long b2 =360000;
        System.out.println(a1*1.0/b2);

    }
}
