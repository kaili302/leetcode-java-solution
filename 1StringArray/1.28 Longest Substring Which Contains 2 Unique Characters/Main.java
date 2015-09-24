public String maxSubString2UniqueChars(String s) {
    if (s.length()<=2) return s;
    int max_l=0, max_r=0, this_l=0;
    HashSet<Character> set=new HashSet();
    HashMap<Character, Integer> map=new HashMap();
    for (int i=0; i<s.length(); i++){
        char c=s.charAt(i);
        if (set.contains(c)) map.put(c,i);
        else if (!set.contains(c)&&set.size()<2) {
            set.add(c);
            map.put(c,i);
        }else {
            if (max_r-max_l+1<i-this_l){
                max_r=i-1;
                max_l=this_l;
            }      
            char toKeep=s.charAt(i-1);
            char toRemove='';
            for (Map.Entry<Character, Integer> entry: map.getEntrySet()){
                if (entry.getKey()!=toKeep) toRemove= entry.getKey();
            }
            set.remove(toRemove);
            set.add(c);
            this_l=map.get(toRemove)+1;
            map.remove(toRemove);
            map.add(c);            
        }
    }
    if (s.length()-this_l>max_r-max_l+1) return s.substring(this_l);
    return s.substring(max_l, max_r+1);
}
/*
Given a string, find the longest substring that contains only two unique characters. 
For example, given "abcbbbbcccbdddadacb", the longest 
substring that contains 2 unique character is "bcbbbbcccb". 
*/