import java.util.Arrays;

class Solution {
    public long countTriplets(int[] arr, int l, int r) {
        Arrays.sort(arr);
        return count(arr, r) - count(arr, l - 1);
    }

    private long count(int[] arr, int target) {
        int n = arr.length;
        long count = 0;

        for(int i = 0; i < n - 2; i++){
            int j = i + 1;
            int k = n - 1;

            while(j < k){
                int sum = arr[i] + arr[j] + arr[k];

                if(sum <= target){
                    count += k - j;
                    j++;
                } else {
                    k--;
                }
            }
        }

        return count;
    }
}
