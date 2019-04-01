package array;

public class BestBuySellStockIII {
    public int maxProfit(int[] prices){
        int[] profit=new int[2];
        int min=0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]>=prices[i-1]){
                if(i==prices.length-1){
                    int newP=prices[i]-prices[min];
                    updateProfit(profit,newP);
                }
            }
            else{
                int newP=prices[i-1]-prices[min];
                updateProfit(profit,newP);
                min=i;
            }
        }
        return profit[0]+profit[1];
    }
    private void updateProfit(int[] profit,int newP){
        if(profit[0]>profit[1]){
            if(newP>profit[1])
                profit[1]=newP;
        }else{
            if(newP>profit[0])
                profit[0]=newP;
        }
    }

    public static void main(String[] args) {
        int[] a={1,2,4,2,5,7,2,4,9,0};
        BestBuySellStockIII b=new BestBuySellStockIII();
        int i = b.maxProfit(a);
        System.out.println(i);
    }
}
