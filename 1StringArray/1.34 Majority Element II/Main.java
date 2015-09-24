/*
Given an integer array of size n, 
find all elements that appear more than ⌊ n/3 ⌋ times. 
The algorithm should run in linear time and in O(1) space.
*/

//one pass o(n) solution
public class Solution {
    public int majorityElement(int[] nums) {
        int res=0, count=0;
        for(int i=0; i<nums.length; i++){
            if (count==0)   res=nums[i];
            if (nums[i]==res) count++;
            else count--;
        }
        return res;
    }
}