class Solution {
    public int maxFruits(ArrayList<Integer> arr, int m) {
        int n = arr.size();
        int fruitsCount = 0;
        
        if(m >= n){
            for(int x: arr){
                fruitsCount += x;
            }
            return fruitsCount;
        }
        
        for(int i = 0; i < m; i++){
            fruitsCount += arr.get(i); 
        }
        
        int ans = fruitsCount;
        
        for(int i = 1; i < n; i++){
            int j = i - 1;
            fruitsCount -= arr.get(j);
            
            int k = (i + m - 1) % n;
            fruitsCount += arr.get(k);
            ans = Math.max(ans, fruitsCount);
        }

        return ans;
    }
}
