public String longestCommonPrefix(String[] strs) {
    if(strs.length==0) return "";
    if(strs.length==1) return strs[0];
    int N=strs.length, count=0;
    for(; count<strs[0].length(); count++){
        int j=1;
        while(j<N){
            if(count==strs[j].length()||strs[j].charAt(count)!=strs[0].charAt(count)) return strs[0].substring(0, count);
            j++;
        }
    }    
    return strs[0].substring(0, count);
}
/*
Write a function to find the longest common prefix string 
amongst an array of strings.
*/