/*Given a sorted integer array without duplicates, return the summary of its ranges 
for consecutive numbers. given [0,1,2,4,5,7], return ["0->2","4->5","7"].
*/
public class Solution {
    public List<String> summaryRanges(int[] nums) {
        ArrayList<String> res=new ArrayList();
        if (nums.length==0) return res;
        int start=0;
        for (int i=0; i<nums.length-1; i++){
            if (nums[i+1]-nums[i]!=1) {
                String s=((start==i)?String.valueOf(nums[i]): (nums[start]+"->"+nums[i]));
                res.add(s);
                start=i+1;
            }
        }
        if (start==nums.length-1) res.add(String.valueOf(nums[start]));
        else res.add((nums[start]+"->"+nums[nums.length-1]));
        return res;
    }
}