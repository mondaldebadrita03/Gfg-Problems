class Solution {
    public int maxSumWithK(int[] arr, int k) {
        int n = arr.length;
        int[] maxSum = new int[n];
        maxSum[0] = arr[0];
        int curr = arr[0];
        for (int i = 1; i < n; i++) {
            curr = Math.max(arr[i], curr + arr[i]);
            maxSum[i] = curr;
        }
        // first window of size k
        int windowSum = 0;
        for (int i = 0; i < k; i++)
            windowSum += arr[i];
        int ans = windowSum;
        for (int i = k; i < n; i++) {
            // slide window
            windowSum += arr[i] - arr[i - k];
            // exactly k elements
            ans = Math.max(ans, windowSum);
            // more than k elements
            ans = Math.max(ans, windowSum + maxSum[i - k]);
        }
        return ans;
    }
}
