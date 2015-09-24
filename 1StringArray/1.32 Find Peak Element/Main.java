public class Main{
    public static void main(String[] args){
        int[] num={1,2};
        System.out.println(findPeakElement(num));
        
    }
    //O(N) solution
    public static int findPeakElement(int[] num) {
        for(int i=0; i<num.length; i++){
            int left=(i-1<0? Integer.MIN_VALUE: num[i-1]);
            int right=(i+1==num.length?Integer.MIN_VALUE: num[i+1]);
            if (num[i]>left&&num[i]>right) return i;
        }
        return 0;
    }
    
    //O(N) solution
    public static int findPeakElement2(int[] num) {
        int l=0, r=num.length-1, mid=r/2;
        while(l<r){
            if(num[mid]<num[mid+1]) l=mid+1;
            else r=mid;
            mid=(l+r)/2;            
        }
        return l;
    }
    
}
/*
A peak element is an element that is greater than its neighbors.
Given an input array where num[i] ≠ num[i+1], find a peak element and return its index. 
The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
You may imagine that num[-1] = num[n] = -∞. 
For example, in array [1, 2, 3, 1], 3 is a peak
element and your function should return the index number 2.
*/