public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval l, Interval r){
                return l.start-r.start;
            }
        });
        ArrayList<Interval> res=new ArrayList();
        if (intervals.size()==0) return res;
        res.add(intervals.get(0));
        for (int i=1; i<intervals.size(); i++){
            Interval res_prev=res.get(res.size()-1);
            Interval int_curr=intervals.get(i);
            if (res_prev.end<int_curr.start) res.add(int_curr);
            else if(int_curr.end>res_prev.end) res_prev.end=int_curr.end;
        }
        return res;
    }
}

/*
Given a collection of intervals, merge all overlapping intervals.
For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].
*/