package medium;

public class OddEvenLinkedList {
    //https://leetcode.com/problems/odd-even-linked-list/
    public static ListNode oddEvenList(ListNode head) {
        if (head==null){
            return null;
        }
        ListNode newHead = head;
        ListNode cursor = head;
        ListNode otherHead = new ListNode();
        ListNode otherCursor = otherHead;
        while (cursor.next != null){
            if(cursor.next.next!=null){
                //有下下一個
                otherCursor.next = cursor.next;//移到新的頭
                otherCursor= otherCursor.next;
                cursor.next = cursor.next.next;//指向下下一個
                otherCursor.next=null;//斷掉被抓到另一個頭的node的next
                cursor = cursor.next;
            }else{
                //沒有下下一個
                //把下一個丟到新的頭 然後跳出
                otherCursor.next  = cursor.next;
                cursor.next=null;
            }
        }
        //把頭接起來
        cursor.next = otherHead.next;

        return newHead;
    }

    public static void main(String[] args) {
        int[] n1 = {1,2,3,4};



        ListNode head1 = new ListNode().listToNode(n1);
//        while (head1.next!=null){
//            System.out.println(head1.val);
//            head1 = head1.next;
//        }
//        System.out.println(head1.val);
        System.out.println("@@@@@");

        ListNode listNode = oddEvenList(null);
//        while (listNode.next!=null){
//            System.out.println(listNode.val);
//            listNode = listNode.next;
//        }
//        System.out.println(listNode.val);
    }
}



