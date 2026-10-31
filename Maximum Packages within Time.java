class Solution {
    public int maxPackages(int[] arr, int totalTime) {
        
        int n = arr.length;
        totalTime = Math.min(totalTime, n);
        int sum = 0;
        
        for(int i = 0; i < totalTime; i++){
            sum += arr[i];
        }
        
        int ans = sum;
        
        for(int i = totalTime; i < n; i++){
            sum += arr[i];
            sum -= arr[i - totalTime];
            
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}
