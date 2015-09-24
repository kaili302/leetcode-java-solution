public class Solution {
    public double myPow(double x, int n) {
        if (n<0) return 1/helper(x, -n);
        else return helper(x, -n);
    }
    
    public double helper(double x, int n) {
        if (n==0) return 1;
        else if (n==1) return x;
        double tmp=pow(x, n/2);
        return tmp*tmp*(n%2==0?1:x);
    }
}