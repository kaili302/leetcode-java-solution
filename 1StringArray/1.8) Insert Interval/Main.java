/*
Given a set of non-overlapping & sorted intervals, insert a new interval into the intervals (merge if necessary).
Example 1:
Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
Example 2:
Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].
This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
*/
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        int newStart=newInterval.start, newEnd=newInterval.end;
        boolean start_is_inside, end_is_inside;
        int start_after_existed_start_at, end_before_existed_end_at; 
        int i=0;
        for (; i<intervals.size(); i++){
            if (newStart<=intervals.get(i).end)   {
                if (newStart>=intervals.get(i).start) {
                    start_is_inside=true;
                    start_after_existed_start_at=i;
                }else{
                    start_is_inside=false;
                    start_after_existed_start_at=i-1;
                }
            }         
            if(newEnd<intervals.get)
        }
    }
}