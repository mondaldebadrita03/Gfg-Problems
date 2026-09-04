public class InfiniteArraySearch{
	public static void main(String[] args) {
		int[] arr ={3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170, 210, 250, 360, 450, 500, 580, 600, 625, 650, 700, 850, 900, 1000, 1200, 1500};
		int target = 10;
		
		System.out.println(search(arr, target));
	}
	
	static int search(int[] arr, int target){
	    int left = 0;
	    int right = 1;
	    
	    while(target > arr[right]){
	        int temp = right + 1;
	        right = right + (right - left + 1) * 2;
	        left = temp;
	   }
	   return binarySearch(arr, target, left, right);
	        
    }
    
    static int binarySearch(int[] arr, int target, int left, int right){
        while(left <= right){
            int mid = left + (right - left) / 2;
            
            if(target < arr[mid]){
                right = mid -1;
            }
            else if(target > arr[mid]){
                left = mid + 1;
            }
            else
                return mid;
        }
        return -1;
    }
}
