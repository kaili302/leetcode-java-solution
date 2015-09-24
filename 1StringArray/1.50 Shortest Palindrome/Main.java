/*
Given a string S, you are allowed to convert it to a palindrome by 
adding characters in front of it. Find and return the shortest palindrome you can find by performing this transformation.
For example, given "aacecaaa", return "aaacecaaa"; given "abcd", return "dcbabcd".
*/
public String shortestPalindrome(String s) {
    if(s.length()<=1) return s;
    char[] cs=s.toCharArray();
    int toAdd=cs.length-1;
    for (int i=(cs.length-1)/2; i>=0; i--){
        int j=0;
        while (i-j>=0 && i+1+j<cs.length &&cs[i-j]==cs[i+1+j]) j++;
        if (i-j<0) {
            toAdd=cs.length-(i+1)*2;
            break;
        }
        j=0;
        while (i-1-j>=0 &&cs[i-1-j]==cs[i+1+j]) j++; 
        if (i-1-j<0) {
            toAdd=cs.length-2*i-1;
            break;
        }
    }
    StringBuilder res=new StringBuilder(s.substring(s.length()-toAdd));
    res.reverse();
    res.append(s);
    return res.toString();
}