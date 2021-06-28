package GetticketDomo;

public class Consumer {
    public static void main(String[] args) {
        ThreadDome threadDome1 = new ThreadDome();
        ThreadDome threadDome2 = new ThreadDome();
        ThreadDome threadDome3 = new ThreadDome();
        threadDome1.start();
        threadDome2.start();
        threadDome3.start();
//        在以上这种情况中 会存在一种情况
//        跳号和重号，
    }
}
