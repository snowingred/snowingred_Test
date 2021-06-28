package AlgorithmWithDataStructure.DataStructure;


import java.util.Iterator;

/**
 * @param <T>
 * 栈
 * FILO
 */
public class Stack<T> implements Iterable<T>{
    private Node head;
    private int N;

    public Stack() {
         this.head = new Node<>(null, null);
         this.N=0;
    }
    public boolean isempty(){
        return N==0;
    }
    public int size(){
        return N;
    }
    
    public void push(T item){
        if (N==0){
            Node<T> currentNode = new Node<>(null,item);
            head.next=currentNode;
        }else {
            Node node = head.next;
            Node<T> currentNode = new Node<>(node,item);
            head.next=currentNode;
        }
        N++;
    }

    public T pop(){
        Node node = head.next;
        if (node==null){
            throw new NullPointerException("莫得了");
        }
        Node next = node.next;
        head.next=next;
        T item = (T) node.item;
        N--;
        return item;
    }
    


    @Override
    public Iterator<T> iterator() {
        return  new Siterator();
        }

    private class Siterator implements Iterator<T> {

        private Node node;

        public Siterator() {
            this.node = head;
        }

        @Override
        public boolean hasNext() {

            return node.next!=null;
        }

        @Override
        public T next() {
            node=node.next;
            return (T) node.item;
        }
    }

    public class Node<T>{
        Node next;
        T item;

        public Node(Node next, T item) {
            this.next = next;
            this.item = item;
        }
    }

    public static void main(String[] args) {
   /*     Stack<String> objectStack = new Stack<>();
        objectStack.push("1111");
        objectStack.push("2222");
        objectStack.push("3333");
        objectStack.push("4444");
        String pop = objectStack.pop();
        System.out.println(pop);
        String pop1 = objectStack.pop();
        System.out.println(pop1);
        String pop2 = objectStack.pop();
        System.out.println(pop2);
        String pop3 = objectStack.pop();
        System.out.println(pop3);
        String pop4 = objectStack.pop();
        System.out.println(pop4);*/

   /*     Iterator<String> iterator = objectStack.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }*/
        Stack<String> objects = new Stack<>();
//      字符串中括号匹配问题处理
        String str="()()()";
//      遍历获取字符串中的( 括号放入栈中
        for (int i = 0; i < str.length(); i++) {
            String s = str.charAt(i) + "";
            if (s.equals("(")){
                objects.push(s);
            }
            if (s.equals(")")){
                try {
                    objects.pop();
                }catch (NullPointerException e){
                    System.out.println("不满足号匹配问题处理");
                }
            }
        }
        if (!objects.isempty()){
            System.out.println("不满足号匹配问题处理");
        }else {
            System.out.println("满足号匹配!");
        }



    }



}


