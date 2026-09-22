class Solution {
    public int countIncreasing(int[] arr) {
        int j = 0;
        int count = 0;
        
        for(int i = 1; i < arr.length; i++){
            if(arr[i] <= arr[i - 1])
                j = i;
            count += (i - j);
        }
        return count;
    }
}
