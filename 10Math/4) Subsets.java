/*
Given a set of distinct integers, S, return all possible subsets.
Note: 1) Elements in a subset must be in non-descending order. 2) The solution set must not contain duplicate subsets.
For example, given S = [1,2,3], the method returns:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
*/
public class Solution {
    public List<List<Integer>> subsets(int[] S) {
        Arrays.sort(S);
        HashMap<Integer, Integer> map=new HashMap();
        for (int i=0; i<S.length; i++)  map.put(S[i], i);
        ArrayList<List<Integer>> res=new ArrayList();
        ArrayList<Integer> newList;
        res.add(new ArrayList()); 
        if(S.length==0) return res;
        int todo=1, size, count;
        while (todo>0){
            ArrayList<Integer> curr;
            size=res.size();
            count=0;
            for (int i=1; i<=todo; i++){
                curr=(ArrayList<Integer>)res.get(size-i);
                int j= ((curr.size()==0)?0:map.get(curr.get(curr.size()-1))+1);
                newList=new ArrayList(curr);
                for (; j<S.length; j++){
                    newList=new ArrayList(curr);
                    newList.add(S[j]);
                    res.add(newList);
                    count++;
                }
            }
            todo=count;
        }
        return res;
    }
}


public class Solution {
    public List<List<Integer>> subsets(int[] S) {
        Arrays.sort(S);
        ArrayList<List<Integer>> res=new ArrayList();
        res.add(new ArrayList()); 
        if(S.length==0) return res;
        for (int i=0; i<S.length; i++){
            ArrayList<List<Integer>> tmp=new ArrayList();
            for (List<Integer> r : res) tmp.add(new ArrayList(r));
            for (List<Integer> t : tmp) {
                t.add(S[i]);
                res.add(t);                
            }
        }
        return res;
    }
}