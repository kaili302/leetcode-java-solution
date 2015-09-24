public List<Integer> getRow(int rowIndex) {
    List<Integer> res=new ArrayList(); 
    res.add(1);
    for (int i=0; i<=numRows; i++){//level
        int prev=1;
        for (int p=0; p<=i; p++){
            if(p==0) res.set(0, 1);
            else if (p==i) res.add(1);
            else {
                res.set(p, prev+res.get(p));
                prev=res.get(p)-prev;
            }
        }
    }
    return res;
}
/*
Given an index k, return the kth row of the Pascal's triangle. 
For example, when k = 3, the row is [1,3,3,1].
*/