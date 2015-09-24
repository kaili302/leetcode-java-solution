import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class Test{
    public static void main(String[] args) throws IOException{
        Solution s=new Solution();
        System.out.println(s.calculate("2-5 -1"));

    }
}
/*
Implement a basic calculator to evaluate a simple expression string. 
The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces.
You may assume that the given expression is always valid. Some examples: "1 + 1" = 2, "(1)" = 1, "(1-(4-5))" = 2
*/
class Solution {
    public int calculate(String s) {
        Stack<String> nums =new Stack();
        Stack<String> ops =new Stack();
        for (int i=0; i<s.length(); i++){
            char c=s.charAt(i);
            if (c=='('){
                nums.push("(");
            }else if (c==')'){
                String tmp=nums.pop();
                if (isNum(tmp)) {
                    nums.pop();
                    if (!nums.isEmpty() && isNum(nums.peek())){
                        int res=getResult (nums.pop(), tmp, ops.pop());
                        nums.push(String.valueOf(res));
                    }else   nums.push(tmp);
                }
            }else if (c=='+'||c=='-'){
                ops.push(s.substring(i, i+1));
            }else if(c>='0'&&c<='9'){
                StringBuilder num=new StringBuilder();
                num.append(c);
                int j=i+1;
                while (j<s.length()&&isNum(s.substring(j, j+1))){
                    char n=s.charAt(j);
                    if (n>='0'&&n<='9'){
                        num.append(n);
                    }
                    j++;
                }
                if (!nums.isEmpty() &&isNum(nums.peek())){
                    int res=getResult (nums.pop(), num.toString(), ops.pop());
                    nums.push(String.valueOf(res));
                }else   nums.push(num.toString());
                i=j-1;
            }
        }
        return Integer.parseInt(nums.pop());
    }
    
    public boolean isNum(String s){
        return !s.equals("(") &&!s.equals(")") &&!s.equals("+") &&!s.equals("-");
    }
    
    public int getResult (String x, String y, String op){
       if (op.equals("-")) return Integer.parseInt(x) - Integer.parseInt(y);
       return Integer.parseInt(x)+Integer.parseInt(y);
    }
}