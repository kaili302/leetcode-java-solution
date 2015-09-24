/*
Given a collection of numbers, return all possible permutations.
For example,
[1,2,3] have the following permutations:
[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
*/
public class Solution {
    public List<List<Integer>> permute(int[] num){
        LinkedList<List<Integer>> res= new LinkedList();
        if(num.length==0) return res;
        LinkedList<Integer> list=new LinkedList();
        list.add(num[0]);
        res.add(list);
        for (int i=1; i<num.length; i++){
            int size=res.size();
            for(int j=0; j<size; j++){
                list=(LinkedList<Integer>)res.remove();
                for (int k=0; k<=list.size(); k++){
                    LinkedList<Integer> tmp=new LinkedList();
                    tmp.addAll(list);
                    tmp.add(k, num[i]);
                    res.add(tmp);
                }
            }
        }
        return res;
    }
}