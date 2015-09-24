/*
Given a collection of integers that might contain duplicates, nums, return all possible subsets.
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If nums = [1,2,2], a solution is:
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
*/

public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] S) {
        Arrays.sort(S);
        ArrayList<List<Integer>> res=new ArrayList();
        res.add(new ArrayList()); 
        if(S.length==0) return res;
        int prevAdded=0;
        for (int i=0; i<S.length; i++){
            ArrayList<List<Integer>> tmp=new ArrayList();
            if (i>0 && S[i]==S[i-1]) {   for (int j=1; j<=prevAdded; j++) tmp.add(new ArrayList(res.get(res.size()-j)));}
            else   {for (List<Integer> r : res) tmp.add(new ArrayList(r));}
            prevAdded=0;
            for (List<Integer> t : tmp) {
                t.add(S[i]);
                res.add(t);
                prevAdded++;
            }
        }
        return res;
    }
}

public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] S) {
        Arrays.sort(S);
        HashSet<List<Integer>> res=new HashSet();
        res.add(new ArrayList()); 
        ArrayList<ArrayList<Integer>> list;
        for (int i=0; i<S.length; i++){
            list=new ArrayList();
            for (List<Integer> r: res){
                ArrayList<Integer> tmp=new ArrayList<Integer>(r);
                tmp.add(S[i]);
                list.add(tmp);
            }
            for (ArrayList<Integer> l: list){
                res.add(l);
            }
        }
        return new ArrayList(res);
    }
}