/*
Given two numbers represented as strings, 
return multiplication of the numbers as a string.
*/
//死办法  太麻烦了 
public String multiply(String num1, String num2) {
    char[] n1=num1.toCharArray();
    char[] n2=num2.toCharArray();
    StringBuilder res=new StringBuilder();
    int carry;
    for (int i=n2.length-1; i>=0; i--){
        if (n2[i]=='0') continue;
        StringBuilder tmp=new StringBuilder();
        int k=n2.length-1-i; 
        while (k-->0) tmp.append('0');
        carry=0;
        for(int j=n1.length-1; j>=0; j--){
            int sum=(n2[i]-'0')*(n1[j]-'0')+carry;
            carry=sum/10;
            tmp.insert(0, sum%10);
        }
        if (carry!=0) tmp.insert(0, carry);
        carry=0;
        System.out.println("tmp: "+tmp);
        System.out.println("res before: "+res);
        StringBuilder swap=new StringBuilder();
        for (k=1; k<=tmp.length(); k++){
            int sum=(tmp.charAt(tmp.length()-k)-'0')+carry+(res.length()>=k?res.charAt(res.length()-k)-'0':0);
            carry=sum/10;
            swap.insert(0, sum%10);
        }
        if (carry!=0) swap.insert(0, carry);
        res=swap;
        System.out.println("res after: "+res);
    }
    int k=0; 
    while (res.length()>0 && res.charAt(0)=='0') res.deleteCharAt(0);
    if (res.length()==0) res.append('0');
    return res.toString();
}
//better
public static String multiply2(String num1, String num2) {
    char[] n1=(new StringBuilder(num1)).reverse().toString().toCharArray();
    char[] n2=(new StringBuilder(num2)).reverse().toString().toCharArray();
    System.out.println(Arrays.toString(n1));
    System.out.println(Arrays.toString(n2));
    int[] dig=new int[n1.length+n2.length-1];
    for (int i=0; i<n2.length; i++){
        for (int j=0; j<n1.length; j++){
            dig[i+j]+=(n1[j]-'0')*(n2[i]-'0');
        }    
    }    
    System.out.println(Arrays.toString(dig));
    int carry=0;
    StringBuilder res=new StringBuilder();
    for (int k=0; k<dig.length; k++){
        res.insert(0, (dig[k]+carry)%10);
        carry=(dig[k]+carry)/10;
        System.out.println(res);
    }
    if (carry!=0) res.insert(0, carry);
    while (res.length()>0 && res.charAt(0)=='0') res.deleteCharAt(0);
    if(res.length()==0) res.append(0);
    return res.toString();
}