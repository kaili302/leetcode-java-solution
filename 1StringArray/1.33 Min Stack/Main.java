import java.util.*;
public class Main{
    public static void main(String[] args){
        MinStack m=new MinStack();
        m.push(512);
        m.push(-1024);
        m.push(-1021);
        m.push(-10000);
    }
}
class MinStack {
    Stack<Integer> min=new Stack();
    Stack<Integer> stack=new Stack();
    public void push(int x) {
        stack.push(x);
        if(min.isEmpty()||min.peek().intValue()>=x) min.push(x);
    }

    public void pop() {
        if(stack.peek().intValue()==min.peek().intValue()) min.pop();
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }
}
/*
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
*/