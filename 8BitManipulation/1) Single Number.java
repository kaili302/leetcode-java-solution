public int singleNumber(int[] A) {
    int a=0;
    for (int i=0; i<A.length; i++)
        a^=A[i];
    return a;
}
/*
The problem:
Given an array of integers, every element appears twice except for one. 
Find that single one.
*/