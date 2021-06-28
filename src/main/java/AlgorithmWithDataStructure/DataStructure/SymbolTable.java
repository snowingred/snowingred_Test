package AlgorithmWithDataStructure.DataStructure;

import java.util.Iterator;

/**
 * 符号表,符号表的特性是 K值唯一不会重复
 */
public class SymbolTable<Key,Value> implements Iterable<Value>{
    private Node head;
    private int N;

    public SymbolTable() {
        this.head = new Node(null,null,null);
        N = 0;
    }

    public Value get(Key key){
        if (N==0){
            return null;
        }
        Node node = head.next;
        while (node.next!=null){
            node=node.next;
           if (node.key.equals(key)){
               return (Value) node.value;
           }
        }
        return null;
    }


    public void  put(Key key,Value value){
        Node node=head;
        if (N==0){
            Node<Key, Value> next = new Node<>(key, value, null);
            head.next=next;
            N++;
            return;
        }
    //已经存在K值,只进行Value的替换
        while (node.next!=null){
            node=node.next;
            if (node.key.equals(key)){
                node.value=value;
                return;
            }
        }

    //如果符号表不存在Key值,则进行插入
        Node<Key, Value> next = new Node<>(key, value, null);
        node.next=next;
        N++;
    }


    public  void  delete(Key key){
    }

    public  int size(){
        return N;
    }

    @Override
    public Iterator<Value> iterator() {
        return new SIterator();
    }

    public class Node<Key,Value>{
        private Key key;
        private Value value;
        private Node next;

        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    private class SIterator implements Iterator<Value> {
        private Node node;

        public SIterator() {
            this.node=head;
        }

        @Override
        public boolean hasNext() {
            return node.next!=null;
        }

        @Override
        public Value next() {
            node=node.next;
            return (Value) node.value;
        }
    }

    public static void main(String[] args) {
        SymbolTable<String, String> Str = new SymbolTable<>();
        Str.put("1111","1111");
        Str.put("2222","2222");
        Str.put("3333","3333");
        Str.put("4444","4444");
        Str.put("1111","5555");
        String s = Str.get("2222");
        System.out.println(s);
        Iterator<String> iterator = Str.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
}
