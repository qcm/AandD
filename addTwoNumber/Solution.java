/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ptr1 = l1, ptr2 = l2;
        ListNode results = new ListNode(0);
        int carry = 0;
        while((ptr1 != null) || (ptr2 != null)){
                if(ptr1 == null){
                        results.val = ptr2.val + carry;
                        ptr2 = ptr2.next;
                }else if(ptr2 == null){
                        results.val = ptr1.val + carry;
                        ptr1 = ptr1.next;
                }else{
                        results.val = ptr1.val + ptr2.val + carry;
                        if (results.val > 9){
                            carry = results.val / 10;
                            results.val = results.val % 10;
                        }
                        ptr1 = ptr1.next;
                        ptr2 = ptr2.next;
                }
                results.next = new ListNode(0);
        }
        return results;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
