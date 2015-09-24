/*
Given a non-negative number represented as an array of digits, plus one to the number.
The digits are stored such that the most significant digit is at the head of the list.
*/

public int[] plusOne(int[] digits) {
    int carry=1;
    for (int i=digits.length-1; i>=0; i--){
        int sum=digits[i]+carry;
        digits[i]=sum%10;
        carry=sum/10;
    }
    if (carry==0) return digits;
    int[] res=new int[digits.length+1];
    res[0]=carry;
    for(int i=0; i<digits[i]; i++)  res[i+1]=digits[i];
    return res;
}