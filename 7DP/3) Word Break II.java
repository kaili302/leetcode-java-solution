/*
Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences. 
For example, given s = "catsanddog", dict = ["cat", "cats", "and", "sand", "dog"], 
the solution is ["cats and dog", "cat sand dog"].
*/
public class Solution {
        public static List<String> wordBreak(String s, Set<String> dict) {
        int maxLen=0; 
        for(String word: dict)  maxLen=Math.max(maxLen, word.length());
        List<String> dp[] = new ArrayList[s.length()];
        boolean [] ok=new boolean[s.length()];
        ok[0]=true;
        for (int i=0; i<s.length(); i++){
            ArrayList<String> tmpList=new ArrayList();
            for (int j=0; i-j>=0&&j<maxLen; j++){
                String str= s.substring(i-j, i+1);
                if (dict.contains(str)) tmpList.add(str);
            }        
            dp[i]=tmpList;
        }
        List<String> res = new LinkedList<String>();
        if(dp[s.length()-1].size() *s.length() == 0) 
            return res; 
        ArrayList<String> l = new ArrayList<String>();
        dfs(dp, s.length()-1, res, l);
        return res;
    }
    public static void dfs(List<String>[] dp, int end, List<String> res, ArrayList<String> l){
        if(end <= -1){
            String path = l.get(l.size()-1);
            for(int i=l.size()-2; i>=0; i--){
                path += " " + l.get(i) ;
            }
            res.add(path);
            return;
        }
        for(String str : dp[end]){
            l.add(str);
            dfs(dp, end-str.length(), res, l);
            l.remove(l.size()-1);
        }
    }
}
}