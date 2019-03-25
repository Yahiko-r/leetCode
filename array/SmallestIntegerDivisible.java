package array;

/**
 *用每次剩下的余数*10+1，放到下一次计算上。
 */
public class SmallestIntegerDivisible {
    public int smallestRepunitDivByK(int K){
        int value=0,length=0;
        for(int i=0;i<1e6;i++){
            value=(10*value+1)%K;
            length++;
            if(value==0)
                return length;
        }
        return -1;


  /*      int  a=K%10;
        if(a==1||a==3||a==7||a==9){

        }else{
            return -1;
        }
        return 0;*/
    }

//    public int
}
