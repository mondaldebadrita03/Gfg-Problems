class Solution {
    public int findMax(int n) {
        int maxSum = digitSum(n);
        int num = n;
        int x = n;
        int d = 1;

        while(x > 0){
            int newNum = (x - 1) * d + (d - 1);
            int sum = digitSum(newNum);
            if(maxSum < sum){
                maxSum = sum;
                num = newNum;
            }
            x /= 10;
            d *= 10;
        }
        return num;
    }
    
    private int digitSum(int n){
        int sum = 0;
        while(n > 0){
            sum += (n % 10);
            n /= 10;
        }
        return sum;
    }
}
