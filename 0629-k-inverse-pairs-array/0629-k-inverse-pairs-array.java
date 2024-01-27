
public class Solution {
    public int kInversePairs(int n, int k) {
        int[][] dp = new int[n + 1][k + 1];

        // building answer for all values of N starting 1 going upto N
        for (int i = 1; i <= n; i++) {

            for (int j = 0; j <= k; j++) {
                if (j == 0) {
                    // since J is 0,  sorted case would make it count to 1q
                    dp[i][j] = 1;
                }
                else {
                    for (int p = 0; p <= Math.min(j, i - 1); p++)
                        dp[i][j] = (dp[i][j] + dp[i - 1][j - p]) % 1000000007;
                }
            }
        }
        return dp[n][k];
    }
}