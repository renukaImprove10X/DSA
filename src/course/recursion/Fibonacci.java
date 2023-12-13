package course.recursion;

public class Fibonacci {
    public static void main(String[] args) {
        // https://leetcode.com/problems/fibonacci-number/
    }
    public int fib(int n) {
        int[] dp = new int[n+1];
        for(int i=0; i<=n; i++){
            dp[i] = -1;
        }
        return helper(n, dp);
    }

    private int helper(int n, int[] dp){
        //Memoization - Top down approach
        if(dp[n] != -1){
            return dp[n];
        }
        if(n <= 1) return dp[n] = n;
        return dp[n] = helper(n-1, dp) + helper(n-2, dp);
    }


    // public int fib(int n){
    //     if(n<=1) return n;
    //     int arr[] = new int[n+1];
    //     arr[0]= 0; arr[1]=1;
    //     for(int i=2; i<= n; i++){
    //         arr[i] = arr[i-1] + arr[i-2];
    //     }
    //      Bottom Up Approach - Tabulation
    //     return arr[n];
    // }

    // public int fib(int n){
    //     if(n<=1) return n;

    //     int a= 0, b=1, c=0;
    //     for(int i=2; i<= n; i++){
    //         c = a+b;
    //         a = b;
    //         b = c;
    //     }
    //     return c;
    //     // Space optimized bottom up DP
    // }


    // public int fib(int n) {
    //     if(n<=1) return n;
    //     return fib(n-1)+fib(n-2);
    // }
}
