/*
Given n pairs of parentheses, 
write a function to generate all combinations of well-formed parentheses.
For example, given n = 3, a solution set is:
"((()))", "(()())", "(())()", "()(())", "()()()"
*/
public static List<String> generateParenthesis(int n) {
    ArrayList<String> res=new ArrayList();
    if (n==0) return res;
    helper(res, new StringBuilder("("), n-1, n);
    for (String s: res)
        System.out.println(s);
    return res;
}

public static void helper( ArrayList<String> res, StringBuilder str, int left, int right ){
    if (left>right) return;
    else if (left==0&&right==0) {
        res.add(str.toString());
        return;
    }
    else {
        if (left>0) {
            helper(res, str.append("("), left-1, right);
            str.deleteCharAt(str.length()-1);
        }
        helper(res, str.append(")"), left, right-1);
        str.deleteCharAt(str.length()-1);
    }
}