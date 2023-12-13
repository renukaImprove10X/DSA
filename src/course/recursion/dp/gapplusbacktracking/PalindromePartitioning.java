package course.recursion.dp.gapplusbacktracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
        public List<List<String>> partition(String s) {
            List<List<String>> res = new ArrayList<>();
            List<String> curr = new ArrayList<>();
            int n= s.length();
            boolean[][] dp = new boolean[n][n]; // declare size
            for(int l=1; l<=n; l++){
                for(int i=0; i<=n-l; i++){
                    int j=i+l-1;
                    if(i==j) dp[i][j] = true;
                    else if(s.charAt(i) == s.charAt(j) && (j==i+1 || dp[i+1][j-1])){
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = false;
                    }
                }
            }
            helper(curr, res, 0, s, dp); // dont call this in for loop
            return res;
        }

        private void helper(List<String> curr, List<List<String>> res, int i, String s, boolean[][] dp){
            if(i==s.length()){
                res.add(new ArrayList<>(curr));
                return;
            }
            for(int j = i; j < s.length(); j++){
                if(dp[i][j]){
                    curr.add(s.substring(i, j+1));
                    helper(curr, res, j+1, s, dp);
                    curr.remove(curr.size()-1);
                }
            }
        }
}
