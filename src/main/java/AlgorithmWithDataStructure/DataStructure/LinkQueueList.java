package AlgorithmWithDataStructure.DataStructure;



import java.util.Iterator;
import java.util.LinkedList;


/**
 * @param <T>
 * 单向链表
 */
public class LinkQueueList<T> implements Iterable<T>{
    //  记录头结点
    private  Node first;
    private  int N ;

    //  初始化方法吗，
    public LinkQueueList(){
        this.first=new Node(null,null);
        this.N=0;
    }

    public int length(){
        return N;
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
            Node pre=this.first;
            Node<T> currentNode = new Node<>(item, null);
            pre.next=currentNode;
        }
        //获取T-1位置的节点,获取T位置的节点
        Node pre = getNodeByIndex(index);
        Node last = pre.next;
        Node<T> currentNode = new Node<>(item, last);
        pre.next=currentNode;
        N++;

    }
    //  移除指定节点的信息
    public T remove(int index){
        Node preNode = getNodeByIndex(index);
//      前一个节点直接,直接指向当前节点下一个节点
        preNode.next=preNode.next.next;;
        N--;
        return (T) preNode.next.item;
    }

    //  插入數據
    public void insert(T item){
        // 获取第一个节点 index=0
        Node next = first;
        if (N==0){
            Node<T> tNode = new Node<>(item, null);
            first.next=tNode;

        }
        for (int i = 0;i<N ; i++) {
            next= next.next;
            if (next.next==null){
                Node<T> tNode = new Node<>(item, null);
                next.next=tNode;;
            }
        }
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

//  反转链表
    public void reverse(){
        Node reverse = reverse(first.next);
    }


    public Node reverse(Node node){
        if (node.next!=null){
            Node reverse = reverse(node.next);
            reverse.next=node;
            node.next=null;
        }else {
            first.next=node;
        }
            return node;
    }

//  快慢指针取中间值
    public Node fastSlowPointGetMid(){
//      定义快慢指针
        Node slow = first.next;
        Node fast = first.next.next;
        while (fast!=null&&fast.next!=null) {
             slow = slow.next;
             fast = fast.next.next;
        }
        return slow;
    }
//  快慢指针解决有环问题
    public Node fastSlowPoint(){
//      定义快慢指针
        Node slow = first.next;
        Node fast = first.next.next;
        while (fast!=null&&fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast==slow){
                return slow;
            }
        }
        return slow;
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

        Node( T element, Node next) {
            this.item = element;
            this.next = next;
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
        LinkQueueList<String> stringLinkQueueList = new LinkQueueList<>();
        stringLinkQueueList.insert("1111");
        stringLinkQueueList.insert("2222");
        stringLinkQueueList.insert("3333");
        stringLinkQueueList.insert("4444");
        stringLinkQueueList.insert("5555");
        Node node = stringLinkQueueList.fastSlowPointGetMid();
        System.out.println(node.item);
/*        stringLinkQueueList.insert(3,"5555");
        stringLinkQueueList.remove(3);
*//*        boolean isempty = stringLinkQueueList.isempty();
        System.out.println(isempty);*//*
        int i = stringLinkQueueList.indexOf("2222");
        System.out.println(i);

        while (iterator.hasNext()){
            System.out.println(iterator.next());;
//            System.out.println(next.toString());
        }*/

  /*      Node nodeByIndex = stringLinkQueueList.getNodeByIndex(3);
        System.out.println("nodeByIndex"+nodeByIndex);*/
        stringLinkQueueList.reverse();
//        stringLinkQueueList.reverse(nodeByIndex);
        Iterator<String> iterator = stringLinkQueueList.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());;
//            System.out.println(next.toString());
        }

    }


}
