//Basic Approach : O(2^n)
class Solution {
    public int countFriendsPairings(int n) {
        if (n <= 2) {
            return n;
        }
        int singleOption = countFriendsPairings(n - 1);
        int pairOption = (n - 1) * countFriendsPairings(n - 2);
        return singleOption + pairOption;
    }
}

//Optimal Approach : O(n)
class Solution {
    public int countFriendsPairings(int n) {
        if (n <= 2) {
            return n;
        }
        long mod = 1000000007;
        long[] dp = new long[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + (i - 1) * dp[i - 2]) % mod;
        }
        return (int) dp[n];
    }
}
