/*
LeetCode - Reverse Integer:
Reverse digits of an integer.
Example1: x = 123, return 321
Example2: x = -123, return -321
*/
public static int reverse(int x) {
    int res = 0;
    while (x!=0){
        try{
            res+=x%10;
            res*=10;
            x=x/10;
        }catch(Exception e){
            return 0;            
        }
    }
    return res/10;
}