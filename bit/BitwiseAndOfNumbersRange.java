package bit;

/**
 *
 *
 */
public class BitwiseAndOfNumbersRange {
    public int rangeBitwiseAnd(int m,int n){
        if(m==0){
            return 0;
        }
        int moveTimes=0;
        while(m!=n){
            m=m>>1;
            n=n>>1;
            moveTimes<<=1;
        }


        return m*moveTimes;
    }
}
