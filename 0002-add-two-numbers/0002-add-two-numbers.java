class Solution{
	public ListNode addTwoNumbers(ListNode l1, ListNode l2){
		ListNode answer = new ListNode();
		ListNode dummy = answer;
		int sum = 0;

		while(l1 != null || l2 != null){
			if(l1 != null){
				sum += l1.val;
				l1 = l1.next;
			}
			if(l2 != null){
				sum += l2.val;
				l2 = l2.next;
			}
			dummy.next = new ListNode(sum % 10);
			dummy = dummy.next;

			sum = sum > 9 ? 1 : 0;
		}

		if(sum > 0){
			dummy.next = new ListNode(sum);
		}
		
		return answer.next;
	}
}
