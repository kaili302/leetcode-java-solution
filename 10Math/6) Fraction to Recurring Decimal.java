/*
Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
If the fractional part is repeating, enclose the repeating part in parentheses.

Given numerator = 1, denominator = 2, return "0.5".
Given numerator = 2, denominator = 1, return "2".
Given numerator = 2, denominator = 3, return "0.(6)".
*/


class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator==0) return "0";
        else if (denominator==0) return "";
        StringBuilder res=new StringBuilder();
        if ((numerator<0)^(denominator<0)) res.append("-");
        long num=Math.abs((long)numerator);
        long den=Math.abs((long)denominator);
        res.append(num/den);
        num=num%den;
        if (num==0) return res.toString();
        res.append(".");
        HashMap<Long, Integer> map=new HashMap(); 
        int count=res.length();
        while (num!=0){
            map.put(num, count++);
            num*=10;
            System.out.println(num+", res: "+res);
            res.append(Math.abs(num/den));
            num=num%den;
            if (map.containsKey(num)){
                res.insert(map.get(num), "(");
                res.append(")");
                break;
            }
        }
        return res.toString();
    }
}





























