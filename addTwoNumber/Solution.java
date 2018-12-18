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
	System.out.println("Number #1: ");
	Scanner scanner1 = new Scanner(System.in);
	Scanner scanner2 = new Scanner(System.in);
	ListNode l1 = new ListNode(0);
	ListNode l2 = new ListNode(0);
	/* Test. NG case.
	tmp = tmp.next;
	// Below indicates they are still pointing to same entity
	if (l1.next == tmp) System.out.println("*true*");
	else System.out.println("*false*");

	tmp = new ListNode(1);
	// Below indicates tmp already pointing to a new address
	if (l1.next == tmp) System.out.println("**true**");
	else System.out.println("**false**");
	tmp = tmp.next;
	tmp = new ListNode(2);
	*/

	/* Test. OK case.
	tmp.next = new ListNode(1);
	tmp = tmp.next;
	tmp.next = new ListNode(2);
	*/
	
	ListNode tmp = l1;
	if(scanner1.hasNextInt()){
		tmp.val = scanner1.nextInt();
	}
	while(scanner1.hasNextInt()){
		tmp.next = new ListNode(scanner1.nextInt());
		tmp = tmp.next;
	}
	l1.print();

	tmp = l2;
	System.out.println("Number #2");
	if (scanner2.hasNextInt()) tmp.val = scanner2.nextInt();
	while (scanner2.hasNextInt()){
		tmp.next = new ListNode(scanner2.nextInt());
		tmp = tmp.next;
	}
	l2.print();
	
	ListNode result = addTwoNumbersReverse(l1, l2);
	result.print();
    }
    
    // Implementation
    public static ListNode addTwoNumbersReverse(ListNode l1, ListNode l2) {
        ListNode ptr1 = l1, ptr2 = l2;
        ListNode tmp = new ListNode(0);
	ListNode result = tmp;
        int carry = 0;
        while((ptr1 != null) || (ptr2 != null)){
		//System.out.println("@carry: " + carry);
                if(ptr1 == null){
                        tmp.val = ptr2.val + tmp.val;
                        ptr2 = ptr2.next;
                }else if(ptr2 == null){
                        tmp.val = ptr1.val + tmp.val;
                        ptr1 = ptr1.next;
                }else{
                        tmp.val = ptr1.val + ptr2.val + tmp.val;
                        ptr1 = ptr1.next;
                        ptr2 = ptr2.next;
                }
		if (tmp.val > 9){
			carry = tmp.val / 10;
			//System.out.println("@@carry: " + carry);
			tmp.val = tmp.val % 10;
			tmp.next = new ListNode(carry);
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
	System.out.println("Result:");
	for (ListNode p = this; p != null ; p = p.next){
		System.out.print(p.val);
		System.out.print(" ");
	}
	System.out.println();
    }
}
