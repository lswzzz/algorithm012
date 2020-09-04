import java.util.*;

class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        if(n<=0)return "";
        char[] cs = s.toCharArray();
        boolean[][] dp = new boolean[n][n];
        int left=0, right=0;
        //从下表j到i的最长回文子串
        for(int i=0;i<n;i++)
        {
            dp[i][i]=true;
            for(int j=0;j<i;j++)
            {
                if(cs[i]==cs[j])
                {
                    if(i-j-1>1) dp[i][j] = dp[i-1][j+1];
                    else dp[i][j] = true;
                    if(dp[i][j] && right-left+1<i-j+1)
                    {
                        right=i;
                        left=j;
                    }
                }
            }
        }
        return s.substring(left, right+1);
    }
}