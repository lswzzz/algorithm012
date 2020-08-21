import java.util.*;

class Solution {
    int minStepCount = Integer.MAX_VALUE;
    public int minMutation(String start, String end, String[] bank) {
        backtrack(new HashSet<String>(), start, end, bank);
        return minStepCount == Integer.MAX_VALUE ? -1 : minStepCount;
    }

    public void backtrack(HashSet<String> track, String start, String end, String[] bank)
    {
        if(start.equals(end))
        {
            minStepCount = Math.min(track.size(), minStepCount);
            return;
        }
        for(String bk : bank)
        {
            if(track.contains(bk)) {
                continue;
            }
            int diff = 0;
            for(int i=0; i<bk.length(); i++)
            {
                if(bk.charAt(i)!=start.charAt(i))if(++diff>1)break;
            }
            if(diff == 1)
            {
                track.add(bk);
                backtrack(track, bk, end, bank);
                track.remove(bk);
            }
        }
    }
}