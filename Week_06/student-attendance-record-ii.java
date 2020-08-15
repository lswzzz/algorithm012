import java.util.*;

class Solution {
    public int checkRecord(int n) {
        int _MOD = 1000000007;
        long[][][] dp = new long[n + 1][2][3]; // i, A:{0:non, 1:contains}, L:{0,1,2}
         dp[1][0][0] = 1;
         dp[1][0][1] = 1;
         dp[1][0][2] = 0;
         dp[1][1][0] = 1;
         dp[1][1][1] = 0;
         dp[1][1][2] = 0;
        for (int i = 2; i <= n; i++) {
            // +P
            dp[i][0][0] = (dp[i-1][0][0]+dp[i-1][0][1]+dp[i-1][0][2]) % _MOD;
            dp[i][1][0] = (dp[i-1][1][0]+dp[i-1][1][1]+dp[i-1][1][2]) % _MOD;
            // +L
            dp[i][0][1] = dp[i-1][0][0];
            dp[i][0][2] = dp[i-1][0][1];
            dp[i][1][1] = dp[i-1][1][0];
            dp[i][1][2] = dp[i-1][1][1];
            // +A
            dp[i][1][0] = (dp[i][1][0] + dp[i-1][0][0] + dp[i-1][0][1] + dp[i-1][0][2]) % _MOD;
        }

        // 返回第 n 层的六种情况
        return (int) ((dp[n][0][0] + dp[n][0][1] + dp[n][0][2] + dp[n][1][0] + dp[n][1][1] + dp[n][1][2]) % _MOD);
    }
}