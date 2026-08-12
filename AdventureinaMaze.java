import java.util.*;

class Solution {
    public ArrayList<Integer> findWays(int[][] grid) {
        int n = grid.length;
        int MOD = 1000000007;
        int[] nextWays = new int[n];
        int[] nextAdv = new int[n];
        Arrays.fill(nextAdv, -1);

        for (int i = n - 1; i >= 0; i--) {
            int[] currWays = new int[n];
            int[] currAdv = new int[n];
            Arrays.fill(currAdv, -1);

            for (int j = n - 1; j >= 0; j--) {
                if (i == n - 1 && j == n - 1) {
                    currWays[j] = 1;
                    currAdv[j] = grid[i][j];
                    continue;
                }

                long ways = 0;
                int adventure = -1;

                if ((grid[i][j] == 1 || grid[i][j] == 3) && j + 1 < n && currAdv[j + 1] != -1) {
                    ways = (ways + currWays[j + 1]) % MOD;
                    adventure = Math.max(adventure, grid[i][j] + currAdv[j + 1]);
                }

                if ((grid[i][j] == 2 || grid[i][j] == 3) && i + 1 < n && nextAdv[j] != -1) {
                    ways = (ways + nextWays[j]) % MOD;
                    adventure = Math.max(adventure, grid[i][j] + nextAdv[j]);
                }

                currWays[j] = (int) ways;
                currAdv[j] = adventure;
            }

            nextWays = currWays;
            nextAdv = currAdv;
        }

        ArrayList<Integer> result = new ArrayList<>();
        result.add(nextWays[0]);
        result.add(nextAdv[0] == -1 ? 0 : nextAdv[0]);
        return result;
    }
}
