/*
Given a digit string, return all possible letter combinations that the number could represent. 
(Check out your cellphone to see the mappings) Input:Digit string "23", Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
*/
public class Solution {
    HashMap<Character, String> map =new HashMap();
    public List<String> letterCombinations(String digits) {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        ArrayList<String> res=new ArrayList();
        StringBuilder sBuilder=new StringBuilder();
        helper(res, sBuilder, 0, digits);
        return res;
    }
    
    public void helper (ArrayList<String> res, StringBuilder sBuilder, int start, String digits){
        if (start==digits.length()){
            if (sBuilder.length()!=0)   res.add(sBuilder.toString());
            return;
        }
        char dig=digits.charAt(start);
        if (dig-'0'<=1) {
            helper(res, sBuilder, start+1, digits);
        }else {
            String tmp=map.get(dig);
            for (int i=0; i<tmp.length(); i++){
                sBuilder.append(tmp.charAt(i));
                helper(res, sBuilder, start+1, digits);
                sBuilder.deleteCharAt(sBuilder.length()-1);
            }
        }
    }
}