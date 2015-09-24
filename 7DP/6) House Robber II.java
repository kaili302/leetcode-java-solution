/*
This time, all houses at this place are arranged in a circle. 
That means the first house is the neighbor of the last one. 
Meanwhile, the security system for these houses remain the same as for those in the previous street.
Given a list of non-negative integers representing the amount of money of each house, 
determine the maximum amount of money you can rob tonight without alerting the police.
*/

//2 condition: rob num[0] or don't rob num[0]
public int rob(int[] num) {
    if(num.length==0) return 0;
    //rob num[0]
    int robThisMax=num[0], skipThisMax=Integer.MIN_VALUE;
    for(int i=1; i<num.length-1; i++){
        int tmp=robThisMax;
        robThisMax=skipThisMax+num[i];
        skipThisMax=Math.max(tmp, skipThisMax);
    }
    int max=Math.max(robThisMax, skipThisMax);
    //don't rob num[0]
    if (num.length==1) return max;
    robThisMax=num[1]; skipThisMax=0;
    for(int i=2; i<num.length; i++){
        int tmp=robThisMax;
        robThisMax=skipThisMax+num[i];
        skipThisMax=Math.max(tmp, skipThisMax);
    }
    return Math.max(max, Math.max(robThisMax, skipThisMax));
}