public class Main{
    public static void main(String[] args){
        int N=3000000;
        Integer[] a=new Integer[N];
        for(int i=0; i<N; i++){
            a[i]=i/3000;
        }
        Sort<Integer> s=new Sort<Integer>();
        s.shuffle(a);
        s.isSorted(a);
        s.byInsertion(a);
        //s.bySelection(a);
        //s.byShell(a);
        s.isSorted(a);
    }
}