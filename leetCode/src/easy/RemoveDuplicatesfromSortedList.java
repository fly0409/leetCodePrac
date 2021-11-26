package easy;

public class RemoveDuplicatesfromSortedList {
    public static void main(String[] args) {
        ListNodeTemp n1 = new ListNodeTemp(1);
        ListNodeTemp n2 =new ListNodeTemp(1);
        ListNodeTemp n3 =new ListNodeTemp(2);
        ListNodeTemp n4 =new ListNodeTemp(2);
        ListNodeTemp n5 =new ListNodeTemp(3);
        ListNodeTemp n6 =new ListNodeTemp(3);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
//        n5.next=n6;

        ListNodeTemp head = deleteDuplicates(n1);
        System.out.println(head.val);
        while (head.next!=null){
            head=head.next;
            System.out.println(head.val);
        }

    }


    public static ListNodeTemp deleteDuplicates(ListNodeTemp head) {
        ListNodeTemp current;
        ListNodeTemp cursor;
        current=head;
        cursor=head;
        boolean flag;
        while(cursor.next!=null){
            cursor=cursor.next;
            if(current.val ==cursor.val){
                flag=true;
                while(cursor.next!=null && flag){
                    cursor=cursor.next;
                    if(cursor.val>current.val){
                        current.next=cursor;
                        flag=false;
                    }

                }
                if(flag){
                    current.next=null;
                }
                current=current.next;
            }else{
                current=current.next;
            }
        }

        return head;
    }
}




class ListNodeTemp {
      int val;
      ListNodeTemp next;
      ListNodeTemp() {
      }
      ListNodeTemp(int val) {
          this.val = val;
      }
      ListNodeTemp(int val, ListNodeTemp next) {
            this.val = val;
            this.next = next;
        }
}
