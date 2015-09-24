import java.util.*;
public class Main{
    public static void main(String[] args){
        System.out.println("Hello World");
    }
    public String reverseWords(String s) {
        StringBuilder word=new StringBuilder(); 
        StringBuilder str=new StringBuilder(); 
        for (int i=0; i<s.length(); i++){
            char c=s.charAt(i);
            if(c!=' ')
                word.append(c);
            if((c==' '||i==s.length()-1) && word.length()!=0){
                if(str.length()!=0) str.append(" ");
                str.append(word.reverse());
                word=new StringBuilder(); 
            }
        }
        return str.reverse().toString();
    }
}


/*
Given an input string, reverse the string word by word.
For example, given s = "the sky is blue", return "blue is sky the".
*/