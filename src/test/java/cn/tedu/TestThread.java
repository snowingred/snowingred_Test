package cn.tedu;

import java.util.ArrayList;

public class TestThread {
    public static void main(String[] args) {
        ArrayList<TestMap> objects = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            TestMap testMap = new TestMap();
            objects.add(testMap);
            System.out.println(testMap);
        }
        for (int i = 0; i < 10; i++) {
            TestMap testMap = objects.get(i);
            System.out.println(testMap);
        }

    }
}
