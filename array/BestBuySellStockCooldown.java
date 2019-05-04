package array;

public class BestBuySellStockCooldown {
    public int maxProfit(int[] prices){
        if(prices==null||prices.length<1){
            return 0;
        }
        int length=prices.length;
        int[] buy=new int[length+1];
        int[] sell=new int[length+1];

        buy[1]=-prices[0];

        for(int i=2;i<=length;i++){
            int price=prices[i-1];
            buy[i]=Math.max(buy[i-1],sell[i-2]-price);
            sell[i]=Math.max(sell[i-1],buy[i-1]+price);
        }
        return sell[length];




    }
}
