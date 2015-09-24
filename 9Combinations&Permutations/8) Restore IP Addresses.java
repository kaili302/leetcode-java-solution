/* Given a string containing only digits, restore it by returning all possible valid IP address combinations.
For example: given "25525511135",return ["255.255.11.135", "255.255.111.35"]. */
// 010 00都不是valider的数字

public class Solution {
    public List<String> restoreIpAddresses(String s) {
        ArrayList<String> res=new ArrayList();
        StringBuilder sBuilder=new StringBuilder();
        helper(res, sBuilder, 0, 4, s);
        return res;
    }
    
    public void helper( ArrayList<String> res, StringBuilder sBuilder, int start, int count, String s){
        if (count==1){
            String num=s.substring(start);
            if (isVal(num)){
                sBuilder.append(num);
                res.add(sBuilder.toString());
                sBuilder.delete(sBuilder.length()-num.length(),sBuilder.length());
            }
            return;
        }
        for (int i=start+1; i<=s.length(); i++){
            String num=s.substring(start, i);
            if (!isVal(num)) break;
            String tmp=num+".";
            sBuilder.append(tmp);
            helper(res, sBuilder, i, count-1, s);
            sBuilder.delete(sBuilder.length()-tmp.length(),sBuilder.length());
        }
    }
    
    public boolean isVal(String s){
        try{
            int val=Integer.parseInt(s);
            if (s.charAt(0)=='0'&&s.length()>1) return false;
            return val<=255&&val>=0;
        }catch (Exception e){
            return false;
        }
    }
}