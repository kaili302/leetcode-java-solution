public int largestRectangleArea(int[] height) {
    int i=0, j=height.length-1, maxArea=0;
    while(i<=j){
        int area=(j-i+1)*Math.min(heigth[i],heigth[j]);
        if(maxArea<area) maxArea=area;
        if(heigth[i]<heigth[j]) i++;
        else j--;
    }
    return maxArea;    
}


/*
Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, 
find the area of largest rectangle in the histogram.
*/
