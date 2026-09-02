class Solution {
    public int solve(int n, String s) {
        int[] track = new int[26];
        int computers = n;
        int leftOut = 0;
        
        for(char c: s.toCharArray()){
            int i = c - 'A';
            if(track[i] == 0){
                if(computers > 0){
                    track[i] = 1;
                    computers--;
                }
                else{
                    track[i] = 2;
                    leftOut++;
                }
            }
            else if(track[i] == 1){
                track[i] = 0;
                computers++;
            }
            else{
                track[i] = 0;
            }
        }
        return leftOut;
    }
}
