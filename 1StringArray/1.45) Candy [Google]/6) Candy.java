/*
There are N children standing in a line. Each child is assigned a rating value. 
You are giving candies to these children subjected to the following requirements:
1. Each child must have at least one candy.
2. Children with a higher rating get more candies than their neighbors.
What is the minimum candies you must give?
*/
public class Solution {
    public int candy(int[] A){
        int len=A.length;
        if(len==0) return 0;
        int[] c=new int[len];
        c[0]=1;
        for (int i=1; i<len; i++){
            if (A[i]>A[i-1]) c[i]=c[i-1]+1;
            else c[i]=1;
        }
        int sum=c[len-1];
        for (int i=len-2; i>=0; i--){
            int tmp;
            if (A[i]> A[i+1]) tmp=c[i+1] +1;
            else tmp=1;
            c[i]=Math.max(tmp, c[i]);
            sum+=c[i];
        }
        return sum;
    }
}