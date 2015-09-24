/*
Given a collection of numbers that might contain duplicates, 
return all possible unique permutations.
For example, [1,1,2] have the following unique permutations:
[1,1,2], [1,2,1], and [2,1,1].
*/
public static List<List<Integer>> permuteUnique(int[] num){
    LinkedList<List<Integer>> res= new LinkedList();
    if(num.length==0) return res;
    LinkedList<Integer> list=new LinkedList();
    Set<LinkedList<Integer>> set=new HashSet();
    list.add(num[0]);
    res.add(list);
    set.add(list);
    for (int i=0; i<num.length; i++){
        int size=res.size();
        for(int j=0; j<size; j++){
            list=(LinkedList<Integer>)res.remove();
            set.remove(list);
            for (int k=0; k<=list.size(); k++){
                LinkedList<Integer> tmp=new LinkedList();
                tmp.addAll(list);
                tmp.add(k, num[i]);
                if (!set.contains(tmp))    {
                    res.add(tmp);
                    set.add(tmp);
                }
            }
        }
    }
    return res;
}

//use set
public static List<List<Integer>> permuteUnique(int[] num){
    LinkedList<List<Integer>> res= new LinkedList();
    if(num.length==0) return res;
    res.add(new LinkedList());
    for (int i=0; i<num.length; i++){
        HashSet<LinkedList<Integer>> set=new HashSet();
        for (List<Integer> l: res){
            for (int k=0; k<=l.size(); k++){
                LinkedList<Integer> tmp=new LinkedList(l);
                tmp.add(k, num[i]);
                set.add(tmp);
            }
        }           
        res=new LinkedList(set);
    }
    return res;
}
