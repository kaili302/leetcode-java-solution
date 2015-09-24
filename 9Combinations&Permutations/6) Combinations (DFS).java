/*
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
For example, if n = 4 and k = 2, a solution is:
[   [2,4], [3,4], [2,3], [1,2], [1,3], [1,4]    ]
*/
public class Solution {
    public List<List<Integer>> combine(int n, int k) {        
        ArrayList<List<Integer>> res=new ArrayList();
        ArrayList<Integer> list=new ArrayList();
        helper(res, list, k, 1, n);
        return new ArrayList<List<Integer>>(res);
    }
    public void helper (ArrayList<List<Integer>> res, ArrayList<Integer> list, int count, int start, int end){
        if (count==0){
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i=start; i<=end; i++){
            list.add(i);
            helper(res, list, count-1, i+1, end);
            list.remove(list.size()-1);
        }
    }
}
