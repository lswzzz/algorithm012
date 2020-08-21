import java.util.*;

class Solution {
    public int climbStairs(int n) {
        int p = 0, s=1;
        for(int i=1; i<=n; i++)
        {
            int max = s + p;
            p = s;
            s = max;
        }
        return s;
    }
}