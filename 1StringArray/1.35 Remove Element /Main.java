public class Main{	
	public int removeElement(int[] nums, int val) {
        if (nums.length==0 ) return 0;
        int i =0; 
        for (int j=0; j<nums.length; j++){
            if (nums[j]==val) continue; 
            nums[i++]=nums[j];
        }
        return i;
    }
}
/*
 *Given an array and a value, remove all instances of that value in place and 
 return the new length. 
 (Note: The order of elements can be changed. It doesn't matter what you leave beyond the new length.)
 */