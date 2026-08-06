class Solution {
    public int countMinOperations(int[] arr) {
        int operations = 0;
        while (true) {
            int zeroCount = 0;
            boolean hasOdd = false;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == 0) {
                    zeroCount++;
                } else if (arr[i] % 2 != 0) {
                    arr[i]--;
                    operations++;
                    hasOdd = true;
                }
            }
            if (zeroCount == arr.length) {
                break;
            }
            if (!hasOdd) {
                for (int i = 0; i < arr.length; i++) {
                    arr[i] /= 2;
                }
                operations++; 
            }
        }
        return operations;
    }
}
