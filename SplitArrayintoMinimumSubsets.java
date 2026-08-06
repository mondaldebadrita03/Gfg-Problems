import java.util.HashSet;
class Solution {
    public static int minSubsets(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
       // Store all unique elements in a HashSet
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int subsetCount = 0;
        // Traverse the array to find sequence boundaries
        for (int num : nums) {
            // If the previous sequential number is missing, 'num' starts a new subset
            if (!set.contains(num - 1)) {
                subsetCount++;
            }
        }
        return subsetCount;
    }
}

