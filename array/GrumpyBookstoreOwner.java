package array;

/**
 * dp，到i的人数和，不考虑x
 * sum，到i的时候，x分钟多出来的人数
 */
public class GrumpyBookstoreOwner {
    public int maxSatisfied(int[] customers,int[] grumpy,int x){
        int sum=0;
        int[] dp=new int[customers.length];
        if(grumpy[0]==0){
            dp[0]=customers[0];
        }
        for(int i=0;i<x;i++){
            if(grumpy[i]==1){
                sum+=customers[i];
            }
            if(i!=0&&grumpy[i]==0){
                dp[i]=dp[i-1]+customers[i];
            }
            if(i!=0&&grumpy[i]==1){
                dp[i]=dp[i-1];
            }
        }
        //dp[i]就是所有不考虑x分钟的所有的和

        for(int i=x;i<grumpy.length;i++){
            if(grumpy[i]==0){
                dp[i]=dp[i-1]+customers[i];

            }else{
                int tmp=0;
                for(int j=i;j>i-x;j--){
                    if(grumpy[j]==1){
                        tmp+=customers[j];
                    }
                }
                sum=Math.max(tmp,sum);
                dp[i]=dp[i-1];
            }

        }
        return sum+dp[grumpy.length-1];
    }

    public static void main(String[] args) {
        GrumpyBookstoreOwner g=new GrumpyBookstoreOwner();
        int[] cus={1,0,1,2,1,1,7,5};
        int[] gru={0,1,0,1,0,1,0,1};
        int i = g.maxSatisfied(cus, gru, 3);
        System.out.println(i);
    }
}
