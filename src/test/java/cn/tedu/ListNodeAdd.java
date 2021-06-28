package cn.tedu;

import java.util.LinkedList;
import java.util.List;

public class ListNodeAdd {
    public List addTwoNumbers(LinkedList<Integer> l1, LinkedList<Integer> l2) {

        Integer l1Size= l1.size();
        Integer l2Size= l2.size();
        int size;
        if (l1Size.compareTo(l2Size)>0){
            size=l2.size();
        }else {
            size=l1.size();
        }
        for (int i = 0; i < size-1 ; i++) {
            int a = l1.get(i);
            l2.get(i);

    
        }

        return l1;
    }





}
