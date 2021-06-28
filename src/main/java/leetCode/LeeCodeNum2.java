package leetCode;

import java.util.LinkedList;

public class LeeCodeNum2 {

    public static class ListNode {
        int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

    static class Solution {
        public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode listNode1 = new ListNode(1, null);
            ListNode listNode2 = new ListNode(5, null);
            ListNode listNode3 = new ListNode(6, null);
            ListNode listNode4 = new ListNode(8, null);
            ListNode listNode5 = new ListNode(9, null);
            ListNode listNode6 = new ListNode(9, null);
            l1.next=listNode1;
            l2.next=listNode2;
            listNode1.next=listNode3;
            listNode2.next=listNode4;
            listNode4.next=listNode5;
            listNode5.next=listNode6;

            int size1=1;
            int size2=1;
            int T =0;
            ListNode lpre=l1;
            ListNode llast=l2;
            while(lpre.next!=null){
                size1++;
                lpre=lpre.next;
            }
            while(llast.next!=null){
                size2++;
                llast=llast.next;
            }
            ListNode last = new ListNode();
            int min = Math.min(size1, size2);
            int max = Math.max(size1, size2);
            int Dvalue=max-min;
            if (size1>size2){
                for (int i = 0; i < Dvalue; i++) {
                    ListNode listNode = new ListNode(0, null);
                    llast.next=listNode;
                    llast=listNode;
                    min=max;
                }
            }else {
                for (int i = 0; i < Dvalue; i++) {
                    ListNode listNode = new ListNode(0, null);
                    lpre.next=listNode;
                    lpre=listNode;
                    min=max;
                }
            }
            lpre= last;
            for (int i = 0; i < min; i++) {
                Integer int1 = l1.val;
                Integer int2 = l2.val;
                Integer sum=(int1+int2+T)%10;
                T=(int1+int2)/10;
                l1=l1.next;
                l2=l2.next;
                ListNode listNode = new ListNode(sum, null);
                last.next= listNode;
                last=listNode;
            }
            if (T>0){
                ListNode listNode = new ListNode(T, null);
                last.next=listNode;
            }

            return lpre.next;
        }


     

}
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(3, null);
        ListNode listNode2 = new ListNode(7, null);

        Solution solution = new Solution();
        ListNode listNode = solution.addTwoNumbers(listNode1,listNode2);

    }
}