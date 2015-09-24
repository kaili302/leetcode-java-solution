public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int len=prerequisites.length;
        int[] res = new int[numCourses];
        if(len == 0){
            for(int m=0; m<numCourses; m++){
                res[m]=m;
            }
            return res;
        }
        int r=0;
        LinkedList<Integer> queue=new LinkedList();
        int [] counter=new int[numCourses];
        for (int i=0; i<len; i++){
            counter[prerequisites[i][0]]++;            
        }
        for (int i=0; i<numCourses; i++){
            if (counter[i]==0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()){
            int top=queue.remove();
            res[r++]=top;
            for (int i=0; i<len; i++){
                if (prerequisites[i][1]==top){
                    --counter[prerequisites[i][0]];
                    if(counter[prerequisites[i][0]]==0){
                        queue.add(prerequisites[i][0]);
                    }
                }
            }
        }
        return (r==numCourses)? res: new int[0];
    }
}