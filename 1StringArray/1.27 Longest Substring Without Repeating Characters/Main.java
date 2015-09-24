public int lengthOfLongestSubstring(String s) {
    if (s.length()<=1) return s.length();
    int max=1, start=0;
    HashMap<Character, Integer> map=new HashMap();
    for (int i=0; i<s.length(); i++){
        char c=s.charAt(i);
        if (!map.containsKey(c)||map.get(c)<start){
            map.put(c, i);
        }else{
            max=Math.max(max, i-start);
            start=map.get(c)+1;
            map.put(c, i);
        }
    }
    return Math.max(max, s.length()-start);
}

/*
Given a string, find the length of the longest substring without repeating characters. 
For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. 
For "bbbbb" the longest substring is "b", with the length of 1.
*/



public int lengthOfLongestSubstring(String s) {
    if (s.length()<=1) return s.length();
    HashMap<Character, Integer> map=new HashMap();
    int left=0, max=0;
    for(int i=0; i<s.length(); i++){
        char c=s.charAt(i);
        if(!map.containsKey(c)|| map.get(c)<left) {
            map.put(c, i);
            if(i==s.length()-1) max=Math.max(i-left+1, max);
        }else{
            max=Math.max(i-1-left+1, max);
            left=map.get(c)+1;
            map.put(c, i);
        }
    }
    return max;
}