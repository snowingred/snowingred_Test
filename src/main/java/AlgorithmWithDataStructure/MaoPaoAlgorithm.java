package AlgorithmWithDataStructure;


import com.sun.corba.se.spi.presentation.rmi.IDLNameTranslator;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//冒泡排序
public class MaoPaoAlgorithm<T>{

    //比较c1,c2的大小，c1大返回true 。反之返回 c2
    public static boolean compare(Comparable c1,Comparable c2){
       if (c1.compareTo(c2)>0){
           return true;
       }
       return false;
    }

    public static void exchange(Comparable[] maoPaoArr,int i,int j){
        Comparable exchange;
        exchange=maoPaoArr[i];
        maoPaoArr[i]=maoPaoArr[j];
        maoPaoArr[j]=exchange;
    }

    /*
    * Comparable的实现类数组,进行冒泡排序
    * reture void
    * */
    public static void  sort(Comparable[] maoPaoArr){
        //核心代码时间复杂度 n^2
        for (int i = maoPaoArr.length-1; i >0; i--) {
            for (int j = 0; j <i; j++) {
                if (compare(maoPaoArr[j],maoPaoArr[j+1]) ) {
                   exchange(maoPaoArr,j,j+1);
                }
            }
        }
    }
    static class Info{
        int msgId;
        int score; //质量分
        int type; //0为系统消息，1为推荐消息


        public Info(int msgId, int score, int type) {
            this.msgId = msgId;
            this.score = score;
            this.type = type;
        }

        public int getMsgId() {
            return msgId;
        }

        public void setMsgId(int msgId) {
            this.msgId = msgId;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        @Override
        public String toString() {
            return "Info{" +
                    "score=" + score +
                    ", type=" + type +
                    '}';
        }
    }


    /*public static void main(String[] args) {
        List arryList = new ArrayList();
        Info info = new Info(1, 10, 0);
        Info info2 = new Info(1, 7, 0);
        Info info3 = new Info(1, 11, 0);
        Info info4 = new Info(1, 8, 0);
        Info info5 = new Info(1, 11, 1);
        Info info6= new Info(1, 8, 1);
        Info info7 = new Info(1, 15, 0);
        Info info8 = new Info(1, 47, 0);
        Info info9 = new Info(1, 88, 0);
        Info info10 = new Info(1, 67, 0);
        List<Info> infos = new ArrayList<>();
        infos.add(info);
        infos.add(info2);
        infos.add(info3);
        infos.add(info4);
        infos.add(info5);
        infos.add(info6);
        infos.add(info7);
        infos.add(info8);
        infos.add(info9);
        infos.add(info10);


        List<Info> collect = infos.stream().sorted(Comparator.comparing(Info::getScore).reversed()).collect(Collectors.toList());
        System.out.println(collect);
        int size = infos.size();
        Queue<Info> queue = new LinkedList<>();
 //LinkedList<Integer> infos1 = new LinkedList<>();
        for (int i = 0; i < size-3; i++) {
            Info info1 = collect.get(i);
            int type = info1.type;
//          如果当前是系统消息,则遍历后续三个节点,都是系统消息则删除最后一个
            if (type==0){
              int b=i+1;
                int c=i+2;
                    int d=i+3;
                int type1 = collect.get(b).getType();
                int type2 = collect.get(c).getType();
                int type3 = collect.get(d).getType();
                if (type1==0&type2==0&&type3==0){
                    Info remove = collect.remove(d);
                    queue.add(remove);
                }
                }else {
                if (!queue.isEmpty()){
                    Info poll = queue.poll();
                    collect.add(i+1,poll);
                }

            }

        }
        System.out.println(collect);

  *//*  if (collect.size()>10){
    List<Info> infos1 = collect.subList(0,10 );
    return infos1;
    }else {
    return collect;
    }*//*

    }
*/


    public static void main(String[] args) {

        Info info = new Info(1, 10, 0);
        Info info2 = new Info(1, 7, 0);
        Info info3 = new Info(1, 11, 0);
        Info info4 = new Info(1, 8, 0);
        Info info5 = new Info(1, 11, 0);
        Info info6= new Info(1, 8, 0);
        Info info7 = new Info(1, 15, 0);
        Info info8 = new Info(1, 47, 0);
        Info info9 = new Info(1, 88, 0);
        Info info10 = new Info(1, 67, 0);
        List<Info> infos1 = new ArrayList<>();
        infos1.add(info);
        infos1.add(info2);
        infos1.add(info3);
        infos1.add(info4);
        infos1.add(info5);
        infos1.add(info6);
        infos1.add(info7);
        infos1.add(info8);
        infos1.add(info9);
        infos1.add(info10);
        infos1 = infos1.stream().sorted(Comparator.comparing(Info::getScore).reversed()).collect(Collectors.toList());


        Info inf11 = new Info(1, 10, 1);
        Info info12 = new Info(1, 7, 1);
        Info info13 = new Info(1, 11, 1);
        Info info14 = new Info(1, 8, 1);
        Info info15 = new Info(1, 11, 1);
        Info info16= new Info(1, 8, 1);
        Info info17 = new Info(1, 15, 1);
        Info info18 = new Info(1, 7, 1);
        Info info19 = new Info(1, 8, 1);
        Info info20 = new Info(1, 7, 1);
        List<Info> infos2 = new ArrayList<>();
        infos2.add(inf11);
        infos2.add(info12);
        infos2.add(info13);
        infos2.add(info14);
        infos2.add(info15);
        infos2.add(info16);
        infos2.add(info18);
        infos2.add(info19);
        infos2.add(info20);
        infos2.add(info17);
        infos2 = infos2.stream().sorted(Comparator.comparing(Info::getScore).reversed()).collect(Collectors.toList());

 //        是的。你下去后想想有没有更简单的方法，比如两个队列两个指针，从大到小取，另外一个计数器考虑一下连续3个系统消息的情况就好了。

      List<Info> InfoList = new ArrayList<>();
      int x=0;
      int y=0;
      int z=0;
      while (true){
          if (infos1.get(x).getScore()>=infos2.get(y).getScore()){
              if (z<3){
                  InfoList.add(infos1.get(x));
                  x++;
                  z++;
              }else {
                  InfoList.add(infos2.get(y));
                  y++;
                  z=0;
              }
          }else {
              InfoList.add(infos2.get(y));
              y++;
              z=0;
          }
      }

    }
}