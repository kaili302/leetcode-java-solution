/*
Find all possible combinations of k numbers that add up to a number n, 
given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
Ensure that numbers within the set are sorted in ascending order.

Example 1: Input: k = 3, n = 7 Output: [[1,2,4]]
Example 2: Input: k = 3, n = 9 Output: [[1,2,6], [1,3,5], [2,3,4]]
*/
public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {        
        ArrayList<List<Integer>> res=new ArrayList();
        ArrayList<Integer> list=new ArrayList();
        helper(res, list, 1, k, n);
        return new ArrayList<List<Integer>>(res);
    }
    public void helper (ArrayList<List<Integer>> res, ArrayList<Integer> list, int start, int count, int target){
        if (target==0&&count==0){
            res.add(new ArrayList<Integer>(list));
        }else if (count==0) return;
        //加速完成
        else if (count==1){
            if (target<=9&&target>list.get(list.size()-1)) {
                list.add(target);
                res.add(new ArrayList<Integer>(list));
                list.remove(list.size()-1);
            }
            return;
        }
        for (int i=start; i<=9 && target>=i; i++){
            list.add(i);
            helper(res, list, i+1, count-1, target-i);
            list.remove(list.size()-1);
        }
    }
}

//simpler code, same object
public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {        
        ArrayList<List<Integer>> res=new ArrayList();
        ArrayList<Integer> list=new ArrayList();
        helper(res, list, 1, k, n);
        return new ArrayList<List<Integer>>(res);
    }
    public void helper (ArrayList<List<Integer>> res, ArrayList<Integer> list, int start, int count, int target){
        if (target==0&&count==0){
            res.add(new ArrayList<Integer>(list));
        }else if (count==0) return;
        for (int i=start; i<=9 && target>=i; i++){
            list.add(i);
            helper(res, list, i+1, count-1, target-i);
            list.remove(list.size()-1);
        }
    }
}