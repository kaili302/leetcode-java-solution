public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res=new ArrayList<List<Integer>>(); 
        if(numRows==0) return res;
        ArrayList<Integer> line=new ArrayList();
        line.add(1);
        res.add(line);//level 1    
        for (int i=1; i<numRows; i++){//level
            line=new ArrayList();
            for (int p=0; p<=i; p++){
                int l=p-1>=0? res.get(i-1).get(p-1):0;
                int r=p<i? res.get(i-1).get(p):0;
                line.add(l+r);
            }
            res.add(line);
        }
        return res;
    }
    
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res=new ArrayList<List<Integer>>(); 
        ArrayList<Integer> line;
        for (int i=0; i<numRows; i++){//level
            line=new ArrayList();
            for (int p=0; p<=i; p++){
                if(p-1<0) line.add(1);
                else if (p==i) line.add(1);
                else res.add(line.get(i-1).get(p-1)+res.get(i-1).get(p));
            }
            res.add(line);
        }
        return res;
    }
}
/*
Given numRows, generate the first numRows of Pascal's triangle. 
For example, given numRows = 5, the result should be:

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
*/