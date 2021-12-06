package medium;

public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public ListNode listToNode(int[] nums){
        ListNode head = new ListNode(nums[0]);
        ListNode cursor = head;
        for (int i = 1; i < nums.length; i++) {
            ListNode newNode = new ListNode(nums[i]);
            cursor.next = newNode;
            cursor = cursor.next;
        }

        return head;
    }
}
