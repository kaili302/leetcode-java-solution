/*
Given an array of non-negative integers, you are initially positioned at the first index of the array. 
Each element in the array represents your maximum jump length at that position.
Your goal is to reach the last index in the minimum number of jumps.
For example, given array A = [2,3,1,1,4], the minimum number of jumps to reach the last index is 2.
(Jump 1 step from index 0 to 1, then 3 steps to the last index.)
*/

public class Solution {
    public int jump(int[] nums) {
        int len=nums.length;
        int count=0;
        int earlier_max_jump=0;
        int prev_max_jump=0;
        int curr_max_jump=0;
        while (curr_max_jump<len-1){
            count++;
            for (int i=prev_max_jump; i>=earlier_max_jump; i--){
                curr_max_jump=Math.max(curr_max_jump, i+nums[i]);
            }
            earlier_max_jump=prev_max_jump;
            prev_max_jump=curr_max_jump;
        }
        return count;
    }
}