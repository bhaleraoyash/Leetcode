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
    public ListNode middleNode(ListNode head) {
        ListNode dummy = head;
        int n = 0;
        
        while(dummy != null){
            dummy = dummy.next;
            n++;
        }
        
        int mid = -1;
        if(n % 2 == 0){
            mid = n / 2;
        }
        else{
            mid = n / 2;
        }
        
        int temp = 1;
        while(temp <= mid){
            head = head.next;
            temp++;
        }
        
        return head;
    }
}