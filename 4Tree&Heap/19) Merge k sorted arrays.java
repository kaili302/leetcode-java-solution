/*
Merge K Sorted Arrays in Java Another similar problem is "merge k sorted lists".
This problem can be solved by using a heap. The time is O(nlog(n)).
Given m arrays, the minimum elements of all arrays can form a heap. 
It takes O(log(m)) to insert an element to the heap and it takes O(1) to delete the minimum element.
*/

//这样是错的 {{13, 16, 18, 20},{1, 2, 4, 7},{3, 6, 10, 15}}; 会出问题 
//可以弄个ArrayContainer, 用来保存当前值 还有该array下一个值这样就跟merge k sorted list一样了
//每次必须加入新出的那一个item所在array的下一个item
class Solution {
    public int[] mergeKSortedArray(int[][] arr) {
        if (arr.length==0||arr[0].length==0) return null;
        int m=arr.length, n=arr[0].length;
        int[] res=new int[m*n];
        int[] pos=new int[m];
        PriorityQueue<Integer> heap=new PriorityQueue(m, new Comparator<Integer>(){
            public int compare(Integer p, Integer q){
                return p-q;
            }
        });
        for (int i=0; i<m; i++) heap.add(arr[i][pos[i]++]);
        int i=0;
        for (int k=0; k<m*n; k++){
            res[k]=heap.remove();
            if (pos[i]<n) heap.add(arr[i][pos[i]++]);
            i++;
            i%=m;
        }
        return res;
    }
}
