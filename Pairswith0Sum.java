class Solution {
    public static ArrayList<ArrayList<Integer>> getPairs(int[] arr) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        
        Arrays.sort(arr);
        int i = 0;
        int j = arr.length - 1;
        
        while(i < j) {
            if(arr[i] + arr[j] == 0){
                ArrayList<Integer> pair = new ArrayList<>();
                
                pair.add(arr[i]);
                pair.add(arr[j]);
                list.add(pair);
                
                int leftValue = arr[i];
                int rightValue = arr[j];

                while (i < j && arr[i] == leftValue) {
                    i++;
                }

                while (i < j && arr[j] == rightValue) {
                    j--;
                }
            }
            else if(arr[i] + arr[j] < 0){
                i++;
            }
            else{
                j--;
            }
        }
        return list;
    }
}
