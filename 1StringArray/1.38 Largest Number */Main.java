public String largestNumber(int[] nums) {
    if(nums.length==0) return "0";
    String[] strs=new String[nums.length];
    for(int i=0; i<nums.length; i++)    strs[i]=String.valueOf(nums[i]);
    Arrays.sort(strs, new Comparator<String>(){
        public int compare(String l, String r){
            return -(l+r).compareTo(r+l);
        }
    });
    StringBuilder res=new StringBuilder();
    for(String s:strs)  res.append(s);
    while(res.charAt(0)=='0'&&res.length()>1)
        res.deleteCharAt(0);
    return res.toString();
    
}
/*
Given a list of non negative integers, arrange them such that they form the largest number.
For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330. 
(Note: The result may be very large, so you need to return a string instead of an integer.)
*/