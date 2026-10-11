class Solution {
    public void mergeTwoParts(int[] arr) {
        int pivot = -1;
        
        for(int i = 0; i < arr.length - 1; i++){
            if(arr[i] > arr[i + 1]){
                pivot = i;
                break;
            }
        }
        if(pivot == -1)
            return;
            
        int[] temp = new int[arr.length];
        int i = 0;
        int j = pivot + 1;
        int k = 0;
        
        while(i <= pivot && j < arr.length){
            if(arr[i] <= arr[j]){
                temp[k++] = arr[i++];
            }
            else{
                temp[k++] = arr[j++];
            }
        }
        
        while (i <= pivot) {
            temp[k++] = arr[i++];
        }

        while (j < arr.length) {
            temp[k++] = arr[j++];
        }

        for (int x = 0; x < arr.length; x++) {
            arr[x] = temp[x];
        }
        
    }
}
