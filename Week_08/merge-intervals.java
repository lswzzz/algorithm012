import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        ArrayList<int[]> res = new ArrayList<>();
        if(intervals==null||intervals.length==0||intervals[0].length==0) return res.toArray(new int[0][]);
        int n = intervals.length;
        int m = intervals[0].length;
        Arrays.sort(intervals, (n1, n2)->{return n1[0]-n2[0];});
        for(int[] interval : intervals)
        {
            int L = interval[0];
            int R = interval[1];
            if(res.size()==0||res.get(res.size()-1)[1]<L)
                res.add(new int[]{L, R});
            else
                res.get(res.size()-1)[1] = Math.max(res.get(res.size()-1)[1], R);
        }
        return res.toArray(new int[0][]);
    }
}