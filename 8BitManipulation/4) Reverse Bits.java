public class Solution {
    public static int reverseBits(int n) {
        for (int i=0; i<16; i++){
            int lbit=(n>>i)&1;
            int rbit=(n>>(31-i))&1;
            if (rbit!=lbit) n=n^(1<<i)^(1<<(31-i));
        }
        return n;
    }
}

/*
Reverse bits of a given 32 bits unsigned integer.
For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), return 964176192 (represented in binary as 00111001011110000010100101000000).
Follow up:
If this function is called many times, how would you optimize it?
*/
