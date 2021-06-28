package NewObjectProcess;

import org.openjdk.jol.info.ClassLayout;

public class HelloJOL {
    public static void main(String[] args) {
        Object o = new Object();
        String s = ClassLayout.parseInstance(o).toPrintable();
        System.out.println(s);
    }
}
