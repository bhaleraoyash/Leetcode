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
class Solution{
	public ListNode removeNthFromEnd(ListNode head, int n){
		ListNode dummy = head;
		int counter = 0;

		while(dummy != null){
			counter++;
			dummy = dummy.next;
		}
        
        if(counter == n){
            return head.next;
        }

		int nodeBeforeRemove = counter - n - 1;
		dummy = head;

		for(int i = 0; i < nodeBeforeRemove; i++){
			dummy = dummy.next;
		}

		dummy.next = dummy.next.next;

		return head;
	}
}
