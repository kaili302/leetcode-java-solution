/*
Given a string s, partition s such that every substring of the partition is a palindrome.
Return all possible palindrome partitioning of s.
For example, given s = "aab",
Return
    ["aa","b"],
    ["a","a","b"]
*/
public class Solution{
    public List<List<String>> partition(String s) {
        ArrayList<List<String>> res=new ArrayList();
        ArrayList<String> prev=new ArrayList();
        if (s==null) return res;
        if (s.length()<=1) {
            prev.add(s);
            res.add(prev);
            return res;
        }
        helper(s, res, prev);
        return res;
    }
    public void helper (String s, ArrayList<List<String>> res, ArrayList<String> prev){
        if (s.equals("")) {
            res.add(new ArrayList<String>(prev));
        }
        for (int i=1; i<=s.length(); i++){
            String subS=s.substring(0, i);
            if (isPal(subS)){
                prev.add(subS);
                helper(s.substring(i), res, prev);
                prev.remove(prev.size()-1);
            }        
        }
    }
    public boolean isPal(String s){
        int size=s.length();
        for (int i=0; i<size/2; i++){
            if (s.charAt(i)!=s.charAt(size-1-i)) return false;
        }
        return true;
    }
}
