/*
Implement wildcard pattern matching with support for '?' and '*'.
Java Solution
To understand this solution, you can use s="aab" and p="*ab".
*/


// abcaa  a?bc**
public boolean isMatch(String s, String p) {
    int i=0, j=0;
    while(true){
        char sc=s.charAt(i);
        int count_sc=1, count_pc=0;;
        while (i+1<s.length()&&sc==s.charAt(i+1)) {
            i++; 
            count_sc++;
        }
        if (p.charAt(j)==sc ||p.charAt(j)=='*' ||(j+1<p.length()&& p.charAt(j+1)=='?') ){//to check isMatch
            
        }else return false;
    }
}