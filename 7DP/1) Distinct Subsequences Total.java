/*
Given a string S and a string T, count the number of distinct subsequences of T in S.
A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing 
the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
Here is an example:
S = "rabbbit", T = "rabbit"
Return 3. 
*/
//方法好屌
public class Solution {
    public int numDistinct(String s, String t) {
        int slen=s.length();
        int tlen=t.length();
        if (slen*tlen==0) return 0;
        int[][] w=new int[slen][tlen];
        if (s.charAt(0)==t.charAt(0)) w[0][0]=1;
        System.out.print(w[0][0]+" ");
        for (int i=1; i<slen; i++)  w[i][0] =w[i-1][0]+  ((s.charAt(i)==t.charAt(0))?1:0);
        for (int j=1; j<tlen; j++){
            System.out.println();
            for(int i=1; i<slen; i++){
                char sc=s.charAt(i);
                char tc=t.charAt(j);
                if (sc==tc){
                    w[i][j]=w[i-1][j-1]+w[i-1][j];
                }else w[i][j]=w[i-1][j];
            }
        }    
        return w[slen-1][tlen-1];
    }
}