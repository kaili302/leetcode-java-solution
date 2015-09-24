/*
Implement the following operations of a queue using stacks.
push(x) -- Push element x to the back of queue.
pop() -- Removes the element from in front of queue.
peek() -- Get the front element.
empty() -- Return whether the queue is empty.
*/
class MyQueue{
    Stack<Integer> first, second;
    public MyQueue(){
        first=new Stack();
        second=new Stack();
    }
    public void push(int item){
        first.push(item);        
    }
    public int pop(){
        if (second.isEmpty()) moveToSecond();
        return second.pop();        
    }
    public int peek(){
        if (second.isEmpty()) moveToSecond();
        return second.peek();        
    }
    public boolean empty(){
        return first.isEmpty()&&second.isEmpty();
    }
    
    public void moveToSecond(){
        while (!first.isEmpty()) second.push(first.pop());        
    }
}