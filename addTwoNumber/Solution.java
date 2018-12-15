/*
* You are given two non-empty linked lists representing two non-negative integers.
* The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
* 
* You may assume the two numbers do not contain any leading zero, except the number 0 itself.
* 
* Example:
* 
* Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
* Output: 7 -> 0 -> 8
* Explanation: 342 + 465 = 807.
* 
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

import java.util.Scanner;

class Solution {
    public static void main(String str[]){
	System.out.println("Add Two Numbers");
	System.out.print("Number #1: ");
	Scanner scanner = new Scanner(System.in);
	ListNode l1 = new ListNode(0);
	ListNode tmp = l1;
	ListNode l2 = new ListNode(0);
	/* NG
	*/
	tmp = tmp.next;
	if (l1.next == tmp) System.out.println("*true*");
	else System.out.println("*false*");

	tmp = new ListNode(1);
	if (l1.next == tmp) System.out.println("**true**");
	else System.out.println("**false**");

	tmp = tmp.next;
	tmp = new ListNode(2);
	/* OK
	tmp.next = new ListNode(1);
	tmp = tmp.next;
	tmp.next = new ListNode(2);
	*/
	
	
	//while(scanner.hasNextInt()){
	//	tmp.val = scanner.nextInt();
	//	System.out.print("*");
	//	System.out.print(tmp.val);
	//	System.out.print("*");
	//	tmp.next = new ListNode(0);
	//	tmp = tmp.next;
	//}
	l1.print();
	//System.out.print("Number #2");
	
	//ListNode result = addTwoNumbersReverse(l1, l2);
	//result.print();
    }
    
    // Implementation
    public static ListNode addTwoNumbersReverse(ListNode l1, ListNode l2) {
        ListNode ptr1 = l1, ptr2 = l2;
        ListNode tmp = new ListNode(0);
	ListNode result = tmp;
        int carry = 0;
        while((ptr1 != null) || (ptr2 != null)){
                if(ptr1 == null){
                        tmp.val = ptr2.val + carry;
                        ptr2 = ptr2.next;
                }else if(ptr2 == null){
                        tmp.val = ptr1.val + carry;
                        ptr1 = ptr1.next;
                }else{
                        tmp.val = ptr1.val + ptr2.val + carry;
                        ptr1 = ptr1.next;
                        ptr2 = ptr2.next;
                }
		if (tmp.val > 9){
			carry = tmp.val / 10;
			tmp.val = tmp.val % 10;
			tmp.next = new ListNode(0);
		}else if(ptr1 != null || ptr2 != null){
			tmp.next = new ListNode(0);
		}
		tmp = tmp.next;
        }
        return result;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    public void print(){
	for (ListNode p = this; p != null ; p = p.next){
		System.out.print(p.val);
		System.out.print(" ");
	}
	System.out.println();
    }
}
