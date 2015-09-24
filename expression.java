Character

Integer.parseInt();

//HashMap
for (Map.Entry<Integer, String> entry : map.entrySet()) {
    System.out.println(entry.getKey()+":"+entry.getValue()); //不用转换类型
}
for (Integer key : map.keySet()) {}
for (String val : map.values()) {}
map.containsKey();

//Array
Integer.valueOf()//string to integer
Arrays.sort()  //sort an array
Arrays.toString(char[] a) //convert to string
Arrays.copyOf(T[] original, int newLength)
System.arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
Collections.sort(intervals, new Comparator<Interval>(){
    public int compare(Interval l, Interval r){
        return l.start-r.start;
    }
});

//String 
toCharArray() //get char array of a String
charAt(int x) //get a char at the specific index
length() //string length
substring(int beginIndex) 
substring(int beginIndex, int endIndex)
String.valueOf()/integer to string
StringBuilder s.deleteCharAt() setCharAt() insert(i, str)

//LinkedList
addAll(oldList), add all old list elements to end of new list

List<List<String>> fun (){
    LinkedList<List<String>> res=new LinkedList();
    res.add(new LinkedList<String>);
    (LinkedList<String>) res.remove();
}

//PriorityQueue
PriorityQueue<ListNode> heap =new PriorityQueue(lists.length, new Comparator<ListNode>(){
    public int compare(ListNode n1, ListNode n2 ){
        return n1.val-n2.val;
    }
});
insert get 最大（最小）值 复杂度都为log(n), 用于merge k list


LinkedList ArrayList的hashCode值与里面的元素值相关。 不同引用的list里面的元素若全部equal, 那么这些引用也equal!!!!
Leetcode permutations II

String == .equals() 区别
== tests for reference equality (whether they are the same object).
.equals() tests for value equality (HashCode) (whether they are logically "equal").
Consequently, if you want to test whether two strings have the same value you should use .equals().
// These two have the same value
new String("test").equals("test") // --> true 
// ... but they are not the same object
new String("test") == "test" // --> false 
// ... neither are these
new String("test") == new String("test") // --> false 
// ... but these are because literals are interned by 
// the compiler and thus refer to the same object
"test" == "test" // --> true 