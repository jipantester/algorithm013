package Week_06;

public class SolutionOfLongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m+1][n+1];
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                //获取两个字符串
                char c1 = text1.charAt(i);
                char c2 = text2.charAt(j);
                if (c1 == c2){
                    //各退一个加1
                    dp[i+1][j+1] = dp[i][j] + 1;
                } else {
                    //text1或text2往前退一格，取两者最大值
                    dp[i+1][j+1] = Math.max(dp[i+1][j], dp[i][j+1]);
                }
            }
        }
        return dp[m][n];
    }  
}
