/*
Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3 
Explanation: The answer is "abc", with the length of 3. 

Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3. 
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.


*/
class Solution {
    public static void main(String args[]){
	String s = "pwwkew";
	lengthOfLongestSubstring(s);
    }
    public static int lengthOfLongestSubstring(String s) {
	char start = s.charAt(0);
	String sub1, sub2;  
	if( s.indexOf( start ) == -1 ) {
		// Not found any duplicated occurrence
		return s.length();
	}else if( s.indexOf(start) == s.lastIndexOf(start) ){
		// Showed only once
		int index = s.indexOf(start);
		String sub1 = s.substring(0, index);
		String sub2 = s.substring(index, s.length() );
		int l1 = lengthOfLongestSubstring(sub1);
		int l2 = lengthOfLongestSubstring(sub2);
		return ( l1 > l2 ) ? l1 : l2;
	}else{
	}	
	return 0;
    }
}
