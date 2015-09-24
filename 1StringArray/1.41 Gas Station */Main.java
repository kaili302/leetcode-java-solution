public class Main{
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // two iterate
        int totalCost=0, totalGas=0;
        if (gas.length!=cost.length) return -1;
        int N=gas.length;
        int[] difference=new int[N];
        for (int i=0; i<N; i++){
            totalGas+=gas[i];
            totalCost+=cost[i];
            difference[i]=gas[i]-cost[i];
        }
        if(totalCost>totalGas) return -1;
        if(N==1) return 0;
        int start=0, end=-1, sum=0; 
        // count clock iterate
        do{
            sum +=difference[++end];
            while(sum<0) { start = (start+N-1)%N; sum+=difference[start];  }
        }while((start-end+N)%N!=1);
        return start;
    }
    
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // one iterate
        if (gas.length!=cost.length) return -1;
        int N=gas.length;
        if(N==1) {return gas[0]>=cost[0]? 0: -1;}
        int start=0, end=-1, sum=0; 
        // count clock iterate
        do{
            end++;
            sum +=gas[end]-cost[end];
            while(sum<0 && (start-end+N)%N!=1) { start = (start+N-1)%N; sum+=gas[start]-cost[start];  }
        }while((start-end+N)%N!=1);
        return sum>=0? start :-1;
    }
    
}
/*
There are N gas stations along a circular route, 
where the amount of gas at station i is gas[i].
You have a car with an unlimited gas tank and it costs cost[i] 
of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.
Return the starting gas station's index if you can travel around the circuit once, 
otherwise return -1.
Note:
The solution is guaranteed to be unique.*/