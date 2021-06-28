package AlgorithmWithDataStructure.DataStructure;

//二叉查找树
public class BinaryQueryTree<Key extends Comparable<Key>,Value> {
    private Node root;
    private int N;

    public BinaryQueryTree() {
        root = null;
        N=0;
    }

    public void put(Key key,Value value){
         root = put(root, key, value);
         N++;

    }

    private Node put(Node node,Key key,Value value){
//       如果节点为空。
        if (node==null){
            Node<Key, Value> keyValueNode = new Node<>(null, null, key, value);
            return keyValueNode;
        }
//       如果节点不为空
//       比较key与当前节点的kye大小,
        if (compare(key, (Comparable) node.key)){
//            大于  传入当前节点右节点继续
            node.right= put(node.right, key, value);
        }else if (compare((Comparable) node.key,key)){
//            小于  传入当前节点右节点继续
            node.left =put(node.left,key,value);
        }else {
            node.value=value;
        }
        return node;
    }

    public Value get(Key key){
       Value value= get(root,key);
        return value;
    }


    private Value get(Node node,Key key){
//      当前传入节点为null值
        if (node==null){
            return null;
        }
//      比较当前节点的key值与key的比较
        if (compare((Comparable) node.key,key)){
            Value valueByKey = (Value) get(node.left, key);
            return valueByKey;
        }else if (compare(key,(Comparable) node.key)){
            Value valueByKey = (Value) get(node.right, key);
            return valueByKey;
        }else {
            return (Value) node.value;
        }
    }

    public void delete(Key key){
        //需要被刪除的节点
        delete(root, key);
    }


//
    private  Node delete(Node node,Key key){
        if (node==null){
            return null;
        }
        //      比较当前节点的key值与key的比较
        if (compare((Comparable) node.key,key)){
            node.left = delete(node.left, key);
        }else if (compare(key,(Comparable) node.key)){
            node.right = delete(node.right, key);
        }else {
            N--;
            if (node.right == null){
                return node.left;
            }
            if (node.left == null){
                return node.right;
            }
            Node rightNode=node.right;
//          循环查询到右子树的最小节点
            while(rightNode.left!=null){
                rightNode=rightNode.left;
            }
//            删除右子树的最左节点
            Node deleterightNode=node.right;
            while(deleterightNode.left!=null){
                if (deleterightNode.left.left==null){
                    deleterightNode.left=null;
                }else {
                    deleterightNode=deleterightNode.left;
                }
            }
//
            rightNode.left=node.left;
            rightNode.right=node.right;
            if (rightNode.right==deleterightNode){
                rightNode.right=null;
            }
            node=rightNode;
            return node;
        }
        return node;
    }


    public int size(){
        return N;
    }

    public Boolean compare(Comparable key1,Comparable key2){
        if (key1.compareTo(key2)>0){
            return true;
        }
        return false;
    }

    public class Node<Key,Value>{

        public Node(Node left, Node right, Key key, Value value) {
            this.left = left;
            this.right = right;
            this.key = key;
            this.value = value;
        }

        private Node left;
        private Node right;
        private Key key;
        private Value value;
    }


    public static void main(String[] args) {
        BinaryQueryTree<String,String> binaryQueryTree = new BinaryQueryTree();
        binaryQueryTree.put("1","1111");
        binaryQueryTree.put("5","5555");
        binaryQueryTree.put("7","7777");
        binaryQueryTree.put("12","1212");
        binaryQueryTree.put("3","3333");
        System.out.println(binaryQueryTree);
        String o = binaryQueryTree.get("3");
        binaryQueryTree.delete("5");
        System.out.println(o);

    }
}
