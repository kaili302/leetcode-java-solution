import java.util.*;
public class Main{
    public static void main(String[] args){
        System.out.println("Hello World");
    }
    
    /*
    Given a triangle, find the minimum path sum from top to bottom. 
    Each step you may move to adjacent numbers on the row below.
    For example, given the following triangle
    [
         [2],
        [3,4],
       [6,5,7],
      [4,1,8,3]
    ]
    The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
    Note: Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
    */
    public static int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        if (n==0) return 0;
        int[] total=new int[n];
        for (int i=0; i<n; i++)
            total[i]=triangle.get(n-1).get(i);
        for (int i=n-2; i>=0; i--){
            for (int l=0; l<=i; l++){
                total[l]=triangle.get(i).get(l)+ Math.min(total[l], total[l+1]);
            }
        }
        return total[0];        
    }
}