import java.util.*;

class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        for(int i=0; i<prices.length-1; i++)
        {
            int diff = prices[i+1]-prices[i];
            if(diff>0)max+= diff;
        }
        return max;
    }
}