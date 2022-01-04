/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteNodes(ListNode head, int m, int n) {
        ListNode slow = new ListNode();
        ListNode fast = new ListNode();
        slow.next = head;
        fast.next = head;
        
        while(fast.next != null){
            for(int i = 0; i < m; i++){
                if(slow.next != null){
                    slow = slow.next;
                }
            }
            fast = slow;
            for(int j = 0; j < n; j++){
                if(fast.next != null){
                    fast = fast.next;
                }
            }
            slow.next = fast.next;
        }
        return head;
    }
}