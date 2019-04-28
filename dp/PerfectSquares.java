package dp;

import java.util.Arrays;

public class PerfectSquares {
    public int numSquares(int n){
        int[] dp=new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;

        for( int i=1;i<=n;i++){
              for(int j=1;j*j<=i;j++){
                int min=dp[i-j*j]+1;
                dp[i]=Math.min(min,dp[i]);
              }
        }
        return dp[n];




    }
}
