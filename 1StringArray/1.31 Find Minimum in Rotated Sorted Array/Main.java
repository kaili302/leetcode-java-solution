public class Main{
    public static void main(String[] args){
    }
    public static int findMin(int[] nums) {
        int lo =0, hi=nums.length-1;
        while (hi-lo>1){
            mid=(lo+hi)/2;
            if (nums[mid]<nums[hi]) hi=mid;
            else lo=mid;
        }
        return Math.min(nums[lo], nums[hi])
    }
}
/*
Suppose a sorted array is rotated at some pivot unknown to you beforehand. 
(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
Find the minimum element.You may assume no duplicate exists in the array.
*/