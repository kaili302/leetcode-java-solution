/*
Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
For example, given
s = "leetcode",
dict = ["leet", "code"].
Return true because "leetcode" can be segmented as "leet code".
*/

//not so good time o(n^2) && too many space
static HashMap<String, Boolean> map=new HashMap<String, Boolean>();
public static boolean wordBreak(String s, Set<String> dict) {
    if (s==null||s.length()==0) return true;
    StringBuilder wordBuilder=new StringBuilder();
    String word;
    for (int i=0; i<s.length(); i++){
        wordBuilder.append(s.charAt(i));
        word=wordBuilder.toString();
        if (map.containsKey(word) && map.get(word) && wordBreak(s.substring(i+1),dict) )  return true;
        else{
            if (dict.contains(word)){
                map.put(word,true);
                if (wordBreak(s.substring(i+1),dict)) return true;
            }else   map.put(word,false);
        }
    } 
    return false;
}




// good DP
public static boolean wordBreak(String s, Set<String> dict) {
    int max=0;
    for(String w: dict)
        max=Math.max(max, w.length());
    if(s.length()==0) return true;
    boolean [] helper=new boolean[s.length()];
    helper[0]=(dict.contains(s.substring(0,1)))? true: false;
    for (int i=1; i<s.length(); i++){
        helper[i]=false;
        for (int j=i; j>=0&&j>=i-max+1; j--){
            if ((j<1||helper[j-1])&&dict.contains(s.substring(j, i+1))) {
                helper[i]=true;
                break;
            }       
        }
    }
    return helper[s.length()-1];
}