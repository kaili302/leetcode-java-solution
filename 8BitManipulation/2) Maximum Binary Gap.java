public static int solution(int N) {
    int max_gap=0, count=0;
    while(N!=0){
        int b=N&1;
        N=N>>1;
        if (b==0) count++;
        else {
            if (count>max_gap) max_gap=count;
            count=0;
        }
    }
    return max_gap;    
}

/*
Problem: Get maximum binary Gap.
For example, 9's binary form is 1001, the gap is 2.
*/