import java.util.*;
public class Sort<T extends Comparable>{
    public void byInsertion(T[] a){
        for(int i=0; i<a.length-1; i++){
            for(int j=i+1; j>0; j--){
                if(less(a[j], a[j-1])) exc(a, j, j-1);
                else break;
            }
        }
    }
    public void bySelection(T[] a){
        for (int i=0; i<a.length-1; i++){
            int min=i;
            for(int j=i+1; j<a.length; j++)
                if(less(a[j], a[min])) min =j;
            exc(a, i, min);
        }
    }
    public void byShell(T[] a){
        int h=0; 
        while (h<a.length/3) h=3*h+1;
        while (h>=1){
            for(int i=0; i+h<a.length; i++){
                for (int j=i+h; j-h>=0 && less(a[j], a[j-h]); j=j-h){
                    exc(a, j, j-h);
                }                
            }
            h/=3;
        }
    }
    
    
    public boolean isSorted(T[] a){
        boolean sorted=true;
        for (int i=0; i<a.length-1; i++){
            if (greater(a[i],a[i+1])) {sorted=false; break;}
        }
        System.out.println("Is Sorted? ==>"+sorted);
        return sorted;
    }
    public void shuffle(T[] a){
        Random randomGenerator = new Random();
        for (int i=1; i<a.length; i++){
            int j=randomGenerator.nextInt(i+1);
            exc(a, i, j);
        }
    }
    public boolean less(T t1, T t2){
        return t1.compareTo(t2)<0;
    }
    public boolean greater(T t1, T t2){
        return t1.compareTo(t2)>0;
    }
    public void exc(T[] a, int p, int q){
        T swap=a[p];
        a[p]=a[q];
        a[q]=swap;
    }
    public void print(T[] a){
        System.out.println(Arrays.toString(a));
    }
}