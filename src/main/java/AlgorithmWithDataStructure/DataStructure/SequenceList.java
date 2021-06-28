package AlgorithmWithDataStructure.DataStructure;

import java.util.Arrays;
import java.util.Iterator;

//顺序表
public class SequenceList<T> implements Iterable<T> {
//  数组
    private T[] eles;
//  数组长度N
    private int N;

    public SequenceList() {
    }

    //  创造容量为N的SequenceList对象
    public SequenceList(int N){
        this.eles= (T[]) new Object[N];
        this.N=0;
    }
//  清空线性表
    public void clear(){
     this.N=0;
    }
//  判断线性表是否为空
    public boolean isEmpty(){
        return this.N==0;
    }
    //  获取线性表长度
    public int length(){
        return this.N;
    }
//  获取线性表 index位置处的数据
    public T get(int index){

        return eles[index];
    }
//  往index位置处插入数据
    public void insert(int index,T t){
        if (eles.length==N){
            resize(eles.length*2);
        }
        for (int i = N-1; i > index; i--) {
            eles[i]=eles[i-1];
        }
        N++;
        eles[index]=t;
    }
//  往最后的位置处插入数据
    public void insert(T t){
        if (eles.length==N){
            resize(eles.length*2);
        }
      eles[N++]=t;
    }
//    删除index位置处的数据    方法写错了
    public T remove(int index){
//       记录索引i处的值
        T t = this.eles[index];
//        让index索引后面的值,依次前移动一位
        for (int i = index; i < N-1; i++) {
         eles[i]=eles[i+1];
        }
        eles[N]=null;
        N--;
//        System.out.println(Arrays.toString(eles));
        if (N<eles.length/4){
            resize(eles.length>>1);
        }
        return t;
    }
//    返回首次出现t数据,位置的下标,没有返回-1
    public int indexOf(T t){
        for (int i = 0; i < N-1; i++) {
            if (t.equals(eles[i]))
                return i;
        }
        return -1;
    }

    public void resize(int newSize){
//      获取当前数组
        T[] tempArr = this.eles.clone();
//      新建数组
        this.eles = (T[]) new Object[newSize];
//      数据复制
        for (int i = 0; i < tempArr.length; i++) {
            eles[i]=tempArr[i];
        }
//        this.N=newSize;

    }

    @Override
    public String toString() {
        return "SequenceList{" +
                "eles=" + Arrays.toString(eles);
    }
    @Override
    public Iterator<T> iterator() {
        return new SIterator();
    }

    private class SIterator implements Iterator{

        private int cusor;

        public SIterator() {
            this.cusor = 0;
        }

        @Override
        public boolean hasNext() {
            return cusor<N;
        }

        @Override
        public T next() {
            return eles[cusor++];
        }
    }
    public static void main(String[] args) {
        SequenceList<String> SequenceList = new SequenceList<>(5);
        SequenceList.insert("111");
        SequenceList.insert("444");
        SequenceList.insert("222");
        SequenceList.insert("333");
        SequenceList.insert("555");
        SequenceList.insert("555");
        System.out.println(SequenceList.toString());
        String remove = SequenceList.remove(0);
        String remove1 = SequenceList.remove(2);
        String remove2 = SequenceList.remove(1);
        String remove3 = SequenceList.remove(3);
        System.out.println(SequenceList.toString()+remove+remove1+remove2+remove3);

   /*     for (String s:SequenceList){
            System.out.println(s);
        }*/
       /* String integer = SequenceList.get(2);
        System.out.println("标志为的值是"+integer);
        int i = SequenceList.indexOf("222");
        System.out.println("第一次出现3的下标是"+i);
        boolean empty = SequenceList.isEmpty();
        System.out.println("是否为空？"+empty);
        System.out.println(SequenceList.toString());
//      是这么写的吗？？
        SequenceList.clear();
        int length = SequenceList.length();
        System.out.println("长度是"+length);

        String remove = SequenceList.remove(1);
        System.out.println("移除的元素是"+remove);*/

    }


}
