package GetticketDomo;
//取号demo
public class ThreadDome extends Thread{
//    记录取号数量
    private  static int x=0;
//    每天最大的号数
    private final static int MAX=500;
    @Override
    public void run() {
//        循环取号 小于MAX=50就可以继续取号
       while(x<MAX){
           x++;
           System.out.println(Thread.currentThread().getName()+"-----"+x);
       }
    }
}
