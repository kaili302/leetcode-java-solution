/*
Determine whether an integer is a palindrome. Do this without extra space.
*/
public static boolean isPalindrome(int x) {
    if (x<0) return false;
    int a=1;
    while (x/a>=10) a*=10;
    while (x>10){
        int l =x/a;
        int r =x%10;
        if (l!=r) return false;
        x=x%a;
        x/=10;
        a/=100;
    }
    return x<10;
}
