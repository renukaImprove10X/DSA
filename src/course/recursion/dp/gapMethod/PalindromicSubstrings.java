package course.recursion.dp.gapMethod;

public class PalindromicSubstrings {
        private boolean helper(String s, int i, int j, boolean[][] dp){
            if(j<i) return false;
            if(i == j) return dp[i][j] = true;
            helper(s, i+1, j, dp);
            helper(s, i, j-1, dp);
            if(s.charAt(i) == s.charAt(j) && (j == i+1 || helper(s, i+1, j-1, dp))){
                return dp[i][j] = true;
            }
            return false;
        }
        public int countSubstrings(String s) {
            int n = s.length();
            // Memoize result of each substring - use dp 2D array of n*n size
            boolean[][] dp = new boolean[n][n]; // Dont forget - java boolean
            for(int i = 0; i<n; i++){
                for(int j=0; j<n; j++){
                    dp[i][j] = false;
                }
            }
            helper(s, 0, s.length()-1, dp);
            int res = 0;
            for(int l = 1; l<=n; l++){
                for(int i = 0; i<=n-l; i++){
                    int j = i+l-1;
                    if(dp[i][j]) {
                        res += 1;
                    }

                }
            }
            return res; // dont forget returning
        }

    public int countSubstrings(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        int res = 0;
        for(int l = 1; l<=n; l++){
            for(int i=0; i<=n-l; i++){
                int j = i+l-1;
                if(i == j){
                    res += 1;
                    dp[i][j] = 1;
                }
                else /* Dont forget else if here */ if(s.charAt(i) == s.charAt(j) && (i == j-1 || dp[i+1][j-1] == 1)){
                    dp[i][j] = 1;
                    res += 1;
                }
            }
        }
        return res;
    }

    // Space Optimization - Not working
    public int countSubstrings(String s) {
        int n = s.length();
        int[] curr = new int[n];
        int[] prev = new int[n];
        int res = 0;
        for(int l = 1; l<=n; l++){
            for(int i=0; i<=n-l; i++){
                int j = i+l-1;
                if(i == j){
                    res += 1;
                    curr[j] = 1;
                }
                else /* Dont forget else if here */ if(s.charAt(i) == s.charAt(j) && (i == j-1 || curr[j-1] == 1)){
                    curr[j] = 1;
                    res += 1;
                }
            }
            curr = prev.clone(); // DOnt forget curr = prev.clone()
        }
        return res;
    }
}
