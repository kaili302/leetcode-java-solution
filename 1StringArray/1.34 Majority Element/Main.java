import java.util.*;
public class Main{
    public static void main(String[] args){
    }
    //HashMap solution o(n)
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map=new HashMap();
        for(int i: nums){
            if(map.containsKey(nums[i])) map.put(nums[i], map.get(nums[i])+1);
            else map.put(nums[i],1);
            if(map.get(nums[i])>nums.length/2) return nums[i];
        }
        return -1;
    }
    //sort solution o(nlogN)
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2]
    }
}

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






/*
Problem:
Given an array of size n, find the majority element. 
The majority element is the element that appears more than ⌊ n/2 ⌋ times.
You may assume that the array is non-empty and the majority element always exist in the array.
*/