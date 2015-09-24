public String countAndSay(int n) {
    StringBuilder res=new StringBuilder();
    StringBuilder prev;
    res.append("1");
    for (int i=2; i<=n; i++){
        int count=1; prev=res;
        res=new StringBuilder();
        for (int j=0; j<prev.length()-1; j++){
            if(prev.charAt(j)!=prev.charAt(j+1)) {
                res.append(count+""+prev.charAt(j));
                count=1;
            }else count++;
        }
        res.append(count+""+prev.charAt(j));
    }
    return res.toString();
}



/*
The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.

Given an integer n, generate the nth sequence.
*/