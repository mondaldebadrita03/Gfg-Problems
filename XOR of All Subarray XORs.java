class Solution {
    public int subarrayXor(int[] arr) {
        int n = arr.length;
        int xr = 0;

        for (int i = 0; i < n; i++) {
            int start = i + 1;
            int end = n - i;

            int total = start * end;

            if (total % 2 != 0) {
                xr ^= arr[i];
            }
        }

        return xr;
    }
}
