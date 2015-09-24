public class Main{
    public static void main(String[] args){
    }
    public static int findMin(int[] nums) {
        int lo =0, hi=nums.length-1;
        while (hi-lo>1){
            int mid=(lo+hi)/2;
            if (nums[mid]<nums[hi]) hi=mid;
            else if (nums[mid]>nums[hi]) lo=mid;
            else 
                hi--;
        }
        return Math.min(nums[lo], nums[hi]);
    }
}
/*
Follow up for "Find Minimum in Rotated Sorted Array": 
What if duplicates are allowed?
Would this affect the run-time complexity? How and why?
*/