/*
A message containing letters from A-Z is being encoded to numbers using the following mapping:
'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number of ways to decode it.
*/
//too slow.
public class Solution {
    int count=0;
    public int numDecodings(String s) {
        helper(s);
        return count;
    }
    public void helper(String s) {
        if (s.equals("")) count++;
        for (int i=1; i<=s.length()&&i<=2; i++){
            int val=Integer.parseInt(s.substring(0, i));
            //System.out.println("hhhhhlol"+val);
            if (val<=26 && val>=1) {
                //System.out.println("hhhhh"+i);
                helper(s.substring(i));
            }
        }
    }
}


public class Solution {
    public int numDecodings(String s) {
        int len=s.length();
        if (len==0) return 0;
        int[] num=new int[len]; // num[i]-> num of decodings for 0 to i
        if (isVal(s.substring(0, 1))) num[0]=1;
        for (int i=1; i<len; i++){
            if (isVal(s.substring(i, i+1))) {
                num[i]+=num[i-1];
            }
            if (isVal(s.substring(i-1, i+1))) {
                num[i]+= (i<2?1:num[i-2]);
            }
        }
        return num[len-1];
    }
    
    public boolean isVal(String s){
        if (s.charAt(0)=='0') return false;
        int val=Integer.parseInt(s);
        return val<=26&&val>=1;
    }
}

