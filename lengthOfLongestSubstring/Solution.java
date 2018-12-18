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
	int indx = 0;
	char target = s.charAt(indx);
	if ( s.length() == 1 ) return 1;
	else if( s.indexOf(target) == s.lastIndexOf(target) ){
		// Showed only once -> move on to next target
		String nextStr = s.substring(indx+1, s.length()); // no need protection, s.length() must be gt. than 1
		return 1 + lengthOfLongestSubstring(nextStr);
	}else{
		// Indices not the same, more than one occurrence -> split String
		int l1 = lengthOfLongestSubstring(indx, s.lastIndexOf(target));
		int l2 = lengthOfLongestSubstring(s.lastIndexOf(target), s.length());
		return ( l1 > l2 ) ? l1 : l2;
	}	
	return 0;
    }
}
