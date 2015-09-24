/*
The set [1,2,3,…,n] contains a total of n! unique permutations.
By listing and labeling all of the permutations in order,
We get the following sequence (ie, for n = 3):
"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence. (Note: Given n will be between 1 and 9 inclusive.)
*/
public String getPermutation(int n, int k) {
    k--;
    int base=1;
    for(int i=n-1; i>=1; i--) base*=i;
    LinkedList<Integer> l=new LinkedList();
    for (int i=1; i<=n; i++) l.add(i);
    StringBuilder s=new StringBuilder();
    for (int i=n-1; i>0; i--){
        int quot=k/base;
        int remi=k%base;
        s.append(l.remove(quot));
        base/=i;
        k=remi;
    }
    s.append(l.remove(0));
    return s.toString();
}