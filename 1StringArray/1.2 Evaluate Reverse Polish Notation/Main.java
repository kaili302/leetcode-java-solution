public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack=new Stack();
        for (int i=0; i<tokens.length; i++){
            if (isOp(tokens[i]))
                stack.push(cal(stack.pop(),stack.pop(), tokens[i]));
            else
                stack.push(Integer.parseInt(tokens[i]));
        }
        return stack.pop();
    }
    public boolean isOp(String s){
        return s.equals("-")||s.equals("+")||s.equals("*")||s.equals("/");
    }
    public int cal(int y, int x, String op){
        if(op.equals("*")) return x*y;
        else if(op.equals("/")) return x/y;
        else if(op.equals("+")) return x+y;
        else return x-y;
    }
}
    /*
    Evaluate the value of an arithmetic expression in Reverse Polish Notation. Valid operators are +, -, *, /. Each operand may be an integer or another expression. For example:
    ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
    ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
    */
    
    