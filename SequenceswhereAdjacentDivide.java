class Solution {
    static final int MOD = 1000000007;
    public int count(int n, int m) {
        long[][] dp = new long[n + 1][m + 1];
        // Arrays of length 1
        for (int i = 1; i <= m; i++) {
            dp[1][i] = 1;
        }
        // Build DP
        for (int len = 2; len <= n; len++) {
            for (int last = 1; last <= m; last++) {
                for (int next = 1; next <= m; next++) {
                    if (last % next == 0 || next % last == 0) {
                        dp[len][next] =
                            (dp[len][next] + dp[len - 1][last]) % MOD;
                    }
                }
            }
        }
        long ans = 0;
        for (int i = 1; i <= m; i++) {
            ans = (ans + dp[n][i]) % MOD;
        }
        return (int) ans;
    }
}
