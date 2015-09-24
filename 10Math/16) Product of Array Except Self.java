/*
Given an array of n integers where n > 1, nums, return an array output such that output[i] 
is equal to the product of all the elements of nums except nums[i]. Solve it without division and in O(n). 
For example, given [1,2,3,4], return [24,12,8,6].
*/
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int[] left=new int[n];
        int[] right=new int[n];
        int[] res=new int[n];
        for (int i=0; i<n; i++){
            if (i==0){
                left[i]=nums[i];
                right[n-1-i]=nums[n-1-i];
            }else{
                left[i]=left[i-1]*nums[i];
                right[n-1-i]=right[n-i]*nums[n-1-i];
            }
        }
        res[0]=right[1];
        for (int i=1; i<n-1; i++){
            res[i]=left[i-1]*right[i+1];
        }
        res[n-1]=left[n-2];
        return res;
    }
}

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int[] res=new int[n];
        res[n-1]=1;
        for (int i=n-2; i>=0; i--){
            res[i]=res[i+1]*nums[i+1];
        }
        int left=1;
        for (int i=0; i<n; i++){
            res[i]*=left;
            left*=nums[i];
        }
        return res;
    }
}
