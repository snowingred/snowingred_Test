package AlgorithmWithDataStructure.DataStructure;



import java.util.Iterator;
import java.util.LinkedList;
/**
 * @param <T>
 * 双向链表
 */
public class TwoWayLinkList<T> implements Iterable<T>{
    //  记录头结点
    private  Node first;
    //  记录尾节点
    private  Node last;
    private  int N ;

    //  初始化方法吗，
    public TwoWayLinkList(){
        this.first=new Node(null,null,null);
        this.last=new Node(null,null,null);
        first.next=last;
        last.pre=first;
        this.N=0;
    }

    public int length(){
        return N;
    }
//  清除方法
    public void clear(){
        first.next=last;
        last.pre=first;
        N=0;
    }

    public boolean isempty(){
        return N==0;
    }
    //  获取指定位置的数据
    public T get(int index){
//      first 1  2  3  4  5
        Node next = first;
        for (int i = 0; i <index-1; i++) {
            next = next.next;
        }
        return (T)next.item;
    }

    //  插入指定节点,此处没有考虑index过小的问题
    public void insert(int index,T item){
        if (index==0){
//          首节点
            Node pre=this.first;
//          最后的尾节点
            Node next = pre.next;
//          新建当前节点
            Node<T> currentNode = new Node<>(item, null,next);
            pre.next=currentNode;
            next.pre=currentNode;
        }
        //获取T-1位置的节点,获取T位置的节点
        Node pre = getNodeByIndex(index);
        Node last = pre.next;
        Node<T> currentNode = new Node<>(item, last,pre);
        pre.next=currentNode;
        last.pre=currentNode;
        N++;

    }
    //  移除指定节点的信息
    public T remove(int index){
        Node preNode = getNodeByIndex(index);
//      前一个节点直接,直接指向当前节点下一个节点
        preNode.next=preNode.next.next;;
//      当前节点的下一个一个节点指向当前上一个节点
        preNode.next.next.pre=preNode;
        N--;
        return (T) preNode.next.item;
    }

    //  插入數據
    public void insert(T item){
   /*     // 获取第一个节点 index=0
        Node next = first;*/
//      获取最后一个节点
        Node last=  this.last;
        if (N==0){
            Node<T> tNode = new Node<>(item, last,first);
            first.next=tNode;
        }
        Node pre = last.pre;
        Node<T> tNode = new Node<>(item,last,pre);
        pre.next=tNode;
        last.pre=tNode;
        N++;
    }

    //  查找出数据第一次出现的位置
    public int indexOf(T item){
//      获取第一个节点 index=0
        Node next = first;
        for (int i = 0; next.next!=null; i++) {
            next= next.next;
            if(next.item.equals(item)){
                return i;
            }
        }
        return -1;
    }

    // 获取指定下标的节点信息
    private Node  getNodeByIndex(int index){
        Node next = first;
        for (int i = 0; i <index; i++) {
            next = next.next;
        }
        return next;
    }

    @Override
    public Iterator<T> iterator() {
        return new LIterator();
    }

    public  class LIterator implements Iterator{
        private Node n;

        public LIterator() {
            this.n = first;
        }

        @Override
        public boolean hasNext() {
            return n.next!=null;
        }

        @Override
        public T next() {
            n=n.next;
            return (T) n.item;
        }

    }


    private static class Node<T> {
        T item;
        Node next;
        Node pre;

        Node( T element, Node next,Node pre) {
            this.item = element;
            this.next = next;
            this.pre= pre;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "item=" + item +
                    '}';
        }
    }

    public Node getFirst() {
        return first;
    }

    public void setFirst(Node first) {
        this.first = first;
    }

    public int getN() {
        return N;
    }

    public void setN(int n) {
        N = n;
    }


    public static void main(String[] args) {
        TwoWayLinkList<String> stringLinkQueueList = new TwoWayLinkList<>();
        stringLinkQueueList.insert("1111");
        stringLinkQueueList.insert("2222");
        stringLinkQueueList.insert("3333");
        stringLinkQueueList.insert("4444");
        stringLinkQueueList.insert(3,"5555");
        stringLinkQueueList.remove(3);
        boolean isempty = stringLinkQueueList.isempty();
        System.out.println(isempty);
        int i = stringLinkQueueList.indexOf("2222");
        System.out.println(i);
        Iterator<String> iterator = stringLinkQueueList.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());;
        }
    }


}
