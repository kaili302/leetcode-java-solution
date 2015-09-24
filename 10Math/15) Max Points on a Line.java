/*
Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
Analysis This problem can be solve by counting points that have the same slope for each point. 
When counting, we need to be careful about the duplicate points and points on the vertical lines.
*/

public class Solution {
    public int maxPoints(Point[] points) {
        if (points.length<=2) return points.length;
        HashMap<Double, Integer> slopes=new HashMap();
        int max=2;
        for (int i=0; i<points.length-1; i++){
            int duplicates=0;
            int verticals=1;
            int max_tmp=1;
            slopes=new HashMap();
            for (int j=i+1; j<points.length; j++){
                if (points[j].x==points[i].x){
                    if (points[i].y==points[j].y){
                        duplicates++;
                    }else {
                        verticals++;
                    }
                }else{
                    double slope;
                    slope= (points[j].y==points[i].y)? 0.0: ((double)(points[j].y-points[i].y))/((double)(points[j].x-points[i].x));
                    if (slopes.containsKey(slope)){
                        slopes.put(slope, slopes.get(slope)+1);
                    }else slopes.put(slope, 2);
                    max_tmp=Math.max(max_tmp, slopes.get(slope));
                }
            }
            max_tmp+=duplicates;
            verticals+=duplicates;
            max=Math.max(max, max_tmp);
            max=Math.max(max, verticals);
        }
        return max;
    }
}