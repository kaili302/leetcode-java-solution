public class Solution {
    public List<String> anagrams(String[] strs) {
        ArrayList<String> res=new ArrayList();
        HashMap<String, Integer> map=new HashMap();
        HashSet<String> duplicated=new HashSet();
        for (int i=0; i<strs.length; i++){
            char[] str=strs[i].toCharArray();
            Arrays.sort(str);
            String tmp=String.valueOf(str);
            if(map.containsKey(tmp)) {
                duplicated.add(tmp);
                res.add(strs[i]);
            }else map.put(tmp, i);
        }
        for(String s: duplicated)
            res.add(strs[map.get(s)]);
        return res;
    }
}
/*
Given an array of strings, return all groups of strings that are anagrams.

An anagram is a type of word play, the result of rearranging the letters of a word or phrase to 
produce a new word or phrase, using all the original letters exactly once; 
for example Torchwood can be rearranged into Doctor Who.

If two strings are anagram to each other, their sorted sequence is the same. 
Therefore, this problem can be seen as a problem of finding duplicate elements.
*/
