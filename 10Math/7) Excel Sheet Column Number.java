/*
Given a column title as appear in an Excel sheet, return its corresponding column number. For example:
    A -> 1
    B -> 2
    C -> 3
    Z -> 26
    AA -> 27
    AB -> 28 
    AAA -> 703 
*/
public class Solution {
    public int titleToNumber(String s) {
        int res=0, base=1;
        for (int i=s.length()-1; i>=0; i--){
            int dig=s.charAt(i)-'A'+1;
            res += dig*base;
            base*=26;
        }    
        return res;
    }
}