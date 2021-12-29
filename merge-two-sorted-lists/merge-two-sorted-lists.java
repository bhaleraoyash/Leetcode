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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode answer = new ListNode();
        
        ListNode ln = answer;
        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
                ln.next = list1;
                list1 = list1.next;
            }
            else if(list2.val <= list1.val){
                ln.next = list2;
                list2 = list2.next;
            }
            ln = ln.next;
        }
        ln.next = list1 == null? list2 : list1;
        return answer.next;
    }
}