// Brute Force Approach (This will give TLE for the current problem, will only work for some test cases only)
// T.C: O(n2)

class Solution {
    public int dominantPairs(int[] arr) {
        int n = arr.length;
        int count = 0;
        for(int i = 0; i < n / 2; i++){
            for(int j = n / 2; j < n; j++){
                if(arr[i] >= 5 * arr[j])
                    count++;
            }
        }
        return count;
    }
}

// Better Approach (Using Two Pointers and sorting)
// T.C: O(n logn)

class Solution {
    public int dominantPairs(int[] arr) {
        int n = arr.length;
        int count = 0;
        int j = n / 2;
        int mid = j;
        
        Arrays.sort(arr, 0, mid);
        Arrays.sort(arr, mid, n);
        
        for(int i = 0 ; i < mid; i++){
            while(j < n && arr[i] >= 5 * arr[j]){
                j++;
            }
            count += j - mid;
        }
        return count;
    }
}
