/*
Given a collection of candidate numbers (C) and a target number (T), 
find all unique combinations in C where the candidate numbers sums to T. Each number in C may only be used ONCE in the combination.
Note:
1) All numbers (including target) will be positive integers.
2) Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
3) The solution set must not contain duplicate combinations.
*/
public class Solution {
    public List<List<Integer>>  combinationSum2(int[] candidates, int target) {
        HashSet<List<Integer>> res=new HashSet();
        ArrayList<Integer> list=new ArrayList();
        Arrays.sort(candidates);
        helper(res, list, 0, candidates, target);
        return new ArrayList<List<Integer>>(res);
    }
    public void helper (HashSet<List<Integer>> res, ArrayList<Integer> list, int start, int[] candidates, int target){
        if (target==0){
            res.add(new ArrayList<Integer>(list));
        }
        for (int i=start; i<candidates.length&& candidates[i]<=target; i++){
            list.add(candidates[i]);
            helper(res, list, i+1, candidates, target-candidates[i]);
            list.remove(list.size()-1);
        }
    }
}