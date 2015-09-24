/*
Given a string S, find the longest palindromic substring in S. 
You may assume that the maximum length of S is 1000, 
and there exists one unique longest palindromic substring.
*/
public class Solution {
    public static String longestPalindrome(String s) {
        char[] strs=s.toCharArray();
        int max=1, max_mid=0;
        for (int i=1; i<=s.length()-1; i++){
            int len=helper(strs, i);
            if (len>max) {
                max=len;
                max_mid=i;
            }
        }
        return max%2==0?s.substring(max_mid-max/2, max_mid+max/2):s.substring(max_mid-max/2, max_mid+max/2+1);
    }
    public static int helper(char[] strs, int mid){
        int max=1, lo, hi, count=1;
        lo=hi=mid;
        while (--lo>=0&&++hi<strs.length && strs[lo]==strs[hi]) count+=2;
        max=Math.max(max, count);
        lo=mid-1; hi=mid; count=0;
        while (lo>=0&&hi<strs.length && strs[lo--]==strs[hi++]) count+=2;
        max=Math.max(max, count);
        return max;
    }
}

