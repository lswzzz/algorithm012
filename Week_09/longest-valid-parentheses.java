import java.util.*;

class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();
        if(n<=1)return 0;
        char[] cs = s.toCharArray();
        int max = 0;
        int[] dp = new int[n];
        dp[0] = 0;
        for(int i=1;i<n;i++){
            if(cs[i]==')')
            {
                if(cs[i-1]=='(')
                {
                    dp[i] = (i-2>=0?dp[i-2]:0) + 2;
                }else if(i-dp[i-1]-1>=0&&cs[i-dp[i-1]-1]=='(')
                {
                    if(i-dp[i-1]-2>=0)
                    {
                        dp[i] = dp[i-dp[i-1]-2] + dp[i-1] + 2;
                    }else
                    {
                        dp[i] = dp[i-1] + 2;
                    }
                }
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }
}