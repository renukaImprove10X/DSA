package course.recursion.dp;

import java.util.Arrays;

public class LCS {

//     public int longestCommonSubsequence(String text1, String text2) {
//     int m = text1.length();
//     int n = text2.length();

//     // Ensure text1 is the longer string
//     if (m < n) {
//         String temp = text1;
//         text1 = text2;
//         text2 = temp;

//         int tempLen = m;
//         m = n;
//         n = tempLen;
//     }

//     int[] dp = new int[n + 1];

//     for (int i = 1; i <= m; i++) {
//         int prev = 0;

//         for (int j = 1; j <= n; j++) {
//             int temp = dp[j];

//             if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
//                 dp[j] = prev + 1;
//             } else {
//                 dp[j] = Math.max(dp[j], dp[j - 1]);
//             }

//             // Update prev with the previous value of dp[j] before moving to the next iteration
//             prev = temp;
//         }
//     }

//     return dp[n];
// }


        // public int longestCommonSubsequence(String s1, String s2) {
        //     if(s1.length() >= s2.length()){
        //         return helper(s1, s2);
        //     } else {
        //         return helper(s2,s1);
        //     }
        //     // 6. Space Optimization
        // }

        // private int helper(String s1, String s2){
        //     int n = s1.length();
        //     int m = s2.length();
        //     int[] prev = new int[m+1];
        //     int[] curr = new int[m+1];
        //     for(int i=1; i <= n; i++){
        //         for(int j=1; j <= m; j++){
        //             if(s1.charAt(i-1) == s2.charAt(j-1)){
        //                 curr[j] = prev[j-1]+1;
        //             } else{
        //                 curr[j] = Math.max(prev[j], curr[j-1]);
        //             }
        //         }
        //         prev = (int[]) (curr.clone());
        //     }
        //     return curr[m];
        // }
        // public int longestCommonSubsequence(String s1, String s2) {
        //     int n = s1.length();
        //     int m = s2.length();
        //     int[][] dp = new int[n+1][m+1];
        //     for(int i=0; i <= n; i++){
        //         for(int j=0; j <= m; j++){
        //             dp[i][j] = 0;
        //         }
        //     }
        //     for(int i=1; i <= n; i++){
        //         for(int j=1; j <= m; j++){
        //             if(s1.charAt(i-1) == s2.charAt(j-1)){
        //                 dp[i][j] = dp[i-1][j-1]+1;
        //             } else{
        //                 dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
        //             }
        //         }
        //     }
        //     return dp[n][m];

        //     // 3. Bottom Up - Tabulation approach
        // }

        // public int longestCommonSubsequence(String s1, String s2) {
        //     // 5. Memoization - Top down approach, n,m -> 0
        //     int[][] dp = new int[s1.length()][s2.length()];
        //      for(int[] row: dp) {
        //         Arrays.fill(row, -1);
        //     }
        //     return helper(s1, s2, s1.length()-1, s2.length()-1, dp);
        // }

        // private int helper(String s1, String s2, int n, int m, int[][] dp){
        //     if(n < 0 || m < 0){
        //         return 0;
        //     }
        //     if(dp[n][m] != -1) return dp[n][m];
        //     if(s1.charAt(n) == (s2.charAt(m))){
        //         return dp[n][m] = 1 + helper(s1, s2, n-1, m-1, dp);
        //     }
        //     else{
        //         return dp[n][m] = Math.max(helper(s1, s2, n-1, m, dp), helper(s1, s2, n, m-1, dp));
        //     }
        // }

        public int longestCommonSubsequence(String s1, String s2) {
            // 2. Memoization - Top down approach
            int[][] dp = new int[s1.length()][s2.length()];
            for(int[] row: dp) {
                Arrays.fill(row, -1);
            }
            return helper(s1, s2, 0, 0, dp);
        }

        private int helper(String s1, String s2, int i1, int i2, int[][] dp){
            if(i1 >= s1.length() || i2 >= s2.length()){
                return 0;
            }
            if(dp[i1][i2] != -1) return dp[i1][i2];
            if(s1.charAt(i1) == (s2.charAt(i2))){
                return dp[i1][i2] = 1 + helper(s1, s2, i1+1, i2+1, dp);
            }
            else{
                return dp[i1][i2] = Math.max(helper(s1, s2, i1+1, i2, dp), helper(s1, s2, i1, i2+1, dp));
            }
        }

        //  public int longestCommonSubsequence(String s1, String s2) {
        //      return helper(s1, s2, s1.length()-1, s2.length()-1);
        //  }

// 4. Recursive approach n,m -> 0
        // public int helper(String s1, String s2, int i, int j){
        //     if(i < 0 || j < 0){
        //         return 0;
        //     }
        //     if(s1.charAt(i) == (s2.charAt(j))){
        //         return 1 + helper(s1, s2, i-1, j-1);
        //     }
        //     else{
        //         return Math.max(helper(s1, s2, i-1, j), helper(s1, s2, i, j-1));
        //     }
        // }

        // 1. Recursive approach
        // public int helper(String s1, String s2, int i1, int i2){
        // if(i1 >= s1.length() || i2 >= s2.length()){
        //     return 0;
        // }
        // if(s1.charAt(i1) == (s2.charAt(i2))){
        //     return 1 + helper(s1, s2, i1+1, i2+1);
        // }
        // else{
        //     return Math.max(helper(s1, s2, i1+1, i2), helper(s1, s2, i1, i2+1));
        // }
        // }

}
