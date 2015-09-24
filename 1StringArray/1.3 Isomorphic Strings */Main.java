public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length()) return false;
        HashMap<Character, Character> map=new HashMap();
        HashSet<Character> set=new HashSet();
        for (int i=0; i<s.length(); i++){
            char key=s.charAt(i);
            char val=t.charAt(i);
            if (map.containsKey(key)){
                if (map.get(key)!=val) return false;
            }else{
                if (set.contains(val)) return false;
                set.add(val);
                map.put(key, val);
            }
        }
        return true;
    }
}

/*
Given two strings s and t, determine if they are isomorphic. 
Two strings are isomorphic if the characters in s can be replaced to get t.

For example,"egg" and "add" are isomorphic, "foo" and "bar" are not.
*/