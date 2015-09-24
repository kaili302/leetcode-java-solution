import java.util.*;
public class Main{
    public static void main(String[] args){
        System.out.println("Hello World");
    }
    
    public String minWindow(String s, String t) {
        if(s.length()<t.length()) return "";
        HashMap<Character, Integer> target=new HashMap();
        for (int i=0; i<t.length(); i++){
            char c=t.charAt(i);
            if(target.containsKey(c)) target.put(c, target.get(c)+1);
            else target.put(c,1); 
        }
        int count=0, minLen=s.length()+1, start=0;
        String res="";
        HashMap<Character, Integer> map=new HashMap();
        for(int i=0; i<s.length(); i++){
            char sc=s.charAt(i);
            if(target.containsKey(sc)){
                if(map.containsKey(sc)){
                    if(map.get(sc)<target.get(sc)) count++;
                    map.put(sc, map.get(sc)+1);
                }else{
                    map.put(sc, 1);
                    count++;
                }
            }
            
            if(count==t.length()){
                char ssc=s.charAt(start);
                while(!map.containsKey(ssc)||map.get(ssc)>target.get(ssc)){
                    if(map.containsKey(ssc)&&map.get(ssc)>target.get(ssc)){
                        map.put(ssc, map.get(ssc)-1);
                    }
                    start++;
                    ssc=s.charAt(start);
                }
                if(minLen>i-start+1){
                    minLen=i-start+1;
                    res=s.substring(start, i+1);
                }
            }
        }
        return res;
    }
}

/*
Given a string S and a string T, find the minimum window in S which will
contain all the characters in T in complexity O(n). 
For example, S = "ADOBECODEBANC", T = "ABC", Minimum window is "BANC".
*/
public String minWindow(String s, String t) {
    HashMap<Character, Integer> target=new HashMap();
    for (int i=0; i<t.length(); i++){
        char c=t.charAt(i);
        if (target.containsKey(c)) target.put(c, target.get(c)+1);
        else target.put(c,1);
    }
    HashMap<Character, Integer> curr=new HashMap();
    int count=0, left=0, minL=0, minR=s.length()-1;
    for (int i=0; i<s.length(); i++){
        char c=s.charAt(i);
        if (target.containsKey(c)){
            if (curr.containsKey(c)) {
                if (curr.get(c)<target.get(c))  count++;
                curr.put(c, curr.get(c)+1);
            }else {
                curr.put(c, 1);
                count++;
            }
        }
        if (count==t.length()){
            char cc=s.charAt(left);
            while(!target.containsKey(cc)||curr.get(cc)>target.get(cc)){
                if(target.containsKey(cc)&&curr.get(cc)>target.get(cc)) curr.put(cc, curr.get(cc)-1);
                left++;
                cc=s.charAt(left);
                if(minR-minL>i-left){
                    minL=left; 
                    minR=i;
                }
            }
        }
    }
    return s.substring(minL, minR+1);
}