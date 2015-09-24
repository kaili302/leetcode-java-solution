/*
Count the number of prime numbers less than a non-negative number, n
*/
public int countPrimes(int n) {
    if (n==0) return 0;
    else if (n<=3) return n-1;
    ArrayList<Integer> primes=new ArrayList();
    primes.add(1);
    primes.add(2);
    primes.add(3);
    for (int i=4; i<n; i++){
        for (int prime : primes){
            if (i%prime==0) continue;
        }
        primes.add(i);
    }
    return primes.size();
}

public class Solution {
    public int countPrimes(int n) {
        int max=(int)Math.sqrt(n);
        boolean[] record =new boolean[n];
        int i=2; 
        while (i<=max){
            for (int j=i+i; j<n; j+=i){
                record[j]=true; //if true, deleted
            }        
            while (record[++i]==true);
        }
        int count=0;
        for (i=2; i<n; i++){
            if (record[i]==false) count++;
        }
        return count;
    }
}