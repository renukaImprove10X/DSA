package course.recursion.dp.gapMethod;

public class LongestPalindromicSubstring {


        // BLOCKER
        // public String longestPalindrome(String s) {
        //     // Recursion with memoization
        //     int n = s.length();
        //     return helper(s, 0, n-1, res);
        // }

        // private String helper(String s, int i, int j, String res){
        //     if(j < i) {
        //         isPal = false;
        //         res = "";
        //     }
        //     if(i == j) {
        //         isPal = false;
        //         res = s.substr(i,j+1);
        //     }
        //     else if(s.charAt(i) == s.charAt(j) && (j == i+1 || ) ))

        //     return res;
        // }

        public String longestPalindrome(String s) {
            // Tabulation or bottom up approach
            int n = s.length();
            String res = "";
            boolean[][] dp = new boolean[n][n];
            for(int l = 1; l<=n; l++){
                for(int i = 0; i<=n-l; i++){
                    int j = i+l-1;
                    if(i == j) dp[i][j] = true;
                    else if(s.charAt(i) == s.charAt(j) && (j == i+1 || dp[i+1][j-1])){
                        dp[i][j] = true;
                    } else dp[i][j] = false;
                    if(dp[i][j]) res = s.substring(i, j+1);
                }

            }
            return res;
        }
}
