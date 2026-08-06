class Solution
{
    public static void swap(int[] arr, int x, int y) {
        int t = arr[x]; arr[x] = arr[y]; arr[y] = t;
    }
    public static int maxSubsetXOR(int arr[])
    {
        int max = arr[0];
        for(int x : arr) {
            max = Math.max(x, max);
        }
        int  msb = 31;
        for(int i = 31; i>=0; i--) {
            int ithBit = (max >> i)&1;
            if(ithBit == 1) {
                msb = i;
                break;
            }
        }
        int index = 0;
        for(int i = msb; i>=0;i--) {
            int maxIndex = 0;
            int maxEle = Integer.MIN_VALUE;
            
            for(int j = index;j<arr.length;j++) {
                int setBit = (arr[j]>>i) & 1;
                if(setBit!=0 && arr[j] >maxEle) {
                    maxEle = arr[j];
                    maxIndex = j;
                }
            }
            if(maxEle == Integer.MIN_VALUE) {
                continue;
            }
            swap(arr, index, maxIndex);
            
            for(int k = 0;k<arr.length;k++) {
                if(k == index) continue;
                if(((arr[k]>>i) & 1) == 1) {
                    arr[k] = arr[k]^arr[index];
                }
            }
            index++;
        }
        int ans = 0;
        for(int i = 0;i<arr.length; i++) {
            ans = ans^arr[i];
        }
        return ans;
    }
}
