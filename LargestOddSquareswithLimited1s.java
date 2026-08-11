class Solution {
    ArrayList<Integer> largestSquare(int[][] mat, int[][] queries, int k) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] prefix = new int[n + 1][m + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                prefix[i + 1][j + 1] = mat[i][j] + prefix[i][j + 1] + prefix[i + 1][j] - prefix[i][j];
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for (int[] query : queries) {
            int r = query[0];
            int c = query[1];
            int low = 0;
            int high = Math.min(Math.min(r, n - 1 - r), Math.min(c, m - 1 - c));
            int best = -1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                int top = r - mid;
                int bottom = r + mid;
                int left = c - mid;
                int right = c + mid;
                int ones = prefix[bottom + 1][right + 1] - prefix[top][right + 1] - prefix[bottom + 1][left] + prefix[top][left];
                if (ones <= k) {
                    best = mid;
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            ans.add(best == -1 ? -1 : 2 * best + 1);
        }
        return ans;
    }
}
