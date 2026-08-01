//My try

import java.util.Arrays;
class Solution {
    public int findMax(int n, int[] a, int[] b, int[] k) {
        int[] arr = new int[n];
        for (int i = 0; i < a.length; i++) {   // number of operations
            int l = a[i];
            int r = b[i];
            for (int j = l; j <= r; j++) {
                arr[j] += k[i];
            }
        }
        return Arrays.stream(arr).max().getAsInt();
    }
}

//Optimized code

class Solution {
    public int findMax(int n, int[] a, int[] b, int[] k) {
        int[] diff = new int[n];
        for (int i = 0; i < a.length; i++) {
            diff[a[i]] += k[i];
            if (b[i] + 1 < n) {
                diff[b[i] + 1] -= k[i];
            }
        }
        int max = diff[0];
        for (int i = 1; i < n; i++) {
            diff[i] += diff[i - 1];
            max = Math.max(max, diff[i]);
        }
        return max;
    }
}
