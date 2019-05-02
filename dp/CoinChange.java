package dp;

import java.util.Arrays;

public class CoinChange {
    public int coinChange(int[] coins,int amount){
        int[] dp=new int[amount+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        Arrays.sort(coins);
        for(int i=1;i<=amount;i++){
            for(int j=0;j<coins.length;j++){
                if(i-coins[j]>=0){
                    if(dp[i-coins[j]]!=Integer.MAX_VALUE) {
                        int temp = dp[i - coins[j]] + 1;
                        dp[i]=Math.min(dp[i],temp);
                    }
                }else{
                    break;
                }
            }
        }
        if(dp[amount]!=Integer.MAX_VALUE){
            return dp[amount];
        }else{
            return -1;
        }
    }
}
