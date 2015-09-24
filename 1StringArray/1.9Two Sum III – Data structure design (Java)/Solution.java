/*
Design and implement a TwoSum class. It should support the following operations: add and find.
add - Add the number to an internal data structure.
find - Find if there exists any pair of numbers which sum is equal to the value.
For example,
add(1); 
add(3); 
add(5);
find(4) -> true
find(7) -> false
*/

public class Solution{
    ArrayList<Integer> list;
    public Solution(){
        list=new ArrayList();
    }
    
    public void add(int num){
        list.add(num);        
    }
    
    public boolean find(int target){
        HashSet<Integer> set=new HashSet();
        for (int i:list){
            if (set.contains(i)) return true;
            set.add(target-i);
        }
        return false;
    }
}