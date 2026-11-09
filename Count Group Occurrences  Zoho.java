class Solution {
    int getCount(String s, int k) {
        int[] groups = new int[26];

        for (int i = 0; i < s.length(); i++) {
            if (i == 0 || s.charAt(i) != s.charAt(i - 1)) {
                int index = s.charAt(i) - 'a';
                groups[index]++;
            }
        }

        int answer = 0;

        for (int i = 0; i < 26; i++) {
            if (groups[i] == k) {
                answer++;
            }
        }
        return answer;
        
    }
}
