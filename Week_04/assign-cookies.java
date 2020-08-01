import java.util.*;

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int p=0, q=0;
        int count = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        while(p<g.length&&q<s.length)
        {
            if(g[p]<=s[q])
            {
                q++;
                p++;
                count++;
            }else
            {
                q++;
            }
        }
        return count;
    }
}