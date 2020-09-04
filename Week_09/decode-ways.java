import java.util.*;

class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        if(n==0)return 0;
        char[] cs = s.toCharArray();
        if(cs[0]=='0')return 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for(int i=1;i<n;i++)
        {
            if(cs[i]=='0')
            {
                if(cs[i-1]!='1'&&cs[i-1]!='2') return 0;
                if(i>=2)
                {
                    dp[i] = dp[i-2];
                }else
                {
                    dp[i] = dp[i-1];
                }
            }else
            {
                if(cs[i-1]=='1'||(cs[i-1]=='2'&&cs[i]>='1'&&cs[i]<='6'))
                {
                    dp[i] = (i-2>=0?dp[i-2]:1) + dp[i-1];
                }else
                {
                    dp[i] = dp[i-1];
                }
            }
        }
        return dp[n-1];
    }
}