/*
Implement the following operations of a stack using queues.
push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
empty() -- Return whether the stack is empty.
Note: only standard queue operations are allowed, i.e., poll(), offer(), peek(), size() and isEmpty() in Java.
Analysis
This problem can be solved by using two queues.
*/

class MyStack{
    LinkedList<Integer> queue1, queue2;
    public MyStack(){
        queue1=new LinkedList();
        queue2=new LinkedList();
    }
    public void push (int item ){
        if (empty()) queue1.add(item);
        else {
            if (queue1.size()>0){
                queue2.add(item);
                while (!queue1.isEmpty()) queue2.add(queue1.remove());
            }else {
                queue1.add(item);
                while (!queue2.isEmpty()) queue1.add(queue2.remove());
            }            
        }
    }
    public int top(){
        if (queue1.size()>0) return queue1.get(0);
        return queue2.get(0);
    }
    public int pop(){
        if (queue1.size()>0) return queue1.remove();
        return queue2.remove();        
    }
    public boolean empty(){
        return queue1.isEmpty()&&queue2.isEmpty();
    }
}