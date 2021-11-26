package medium;

public class AddTwoNumbers {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        ListNode head = arrToList(arr);
        do{
            System.out.println(head.val);
            head=head.next;
        }while (head.next!=null);

    }
    //把陣列變成linked list
    public static ListNode arrToList(int[] arr){
        ListNode head = new ListNode();
        ListNode cursour = head;
        ListNode next;
        for (int i = 0; i <arr.length ; i++) {
            cursour.val=arr[i];
            next=new ListNode();
            cursour.next = next;
            cursour=next;
//            ListNode temp = new ListNode(arr[i]);
        }

        return head;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode cursour = head;
        ListNode next;

        int carry=0;
        int num = 0;

        while (l1.next!=null){
            num = (l1.val+ l2.val+carry)%10;
            carry = (l1.val+ l2.val+carry)%10;
            cursour.val=num;

            next = new ListNode();
            cursour.next=next;
            cursour=next;

            if(l1.next!=null){
                l1=l1.next;
            }else{
                break;
            }

            if(l2.next!=null){
                l2=l2.next;
            }else{
                break;
            }
        }



        return head;
    }
}



// Definition for singly-linked list.
 class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
