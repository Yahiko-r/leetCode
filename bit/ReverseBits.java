package bit;

public class ReverseBits {
    public int reverseBits(int n){
        int rs=0;
        for(int i=0;i<32;i++){
            if((n&1)==1){
                rs+=1;
            }
            n=n>>>1;
            if(i<31)
             rs=rs<<1;
        }
        return rs;
    }
}
