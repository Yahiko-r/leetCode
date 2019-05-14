package bit;

public class NumberOf1Bits {
    public int hammingWeight(int n){
        int rs=0;
        while(n!=0){
            if((n&1)==1){
                rs++;
            }
            n=n>>>1;
        }
        return rs;
    }

    public static void main(String[] args) {
        NumberOf1Bits n=new NumberOf1Bits();
        int i = n.hammingWeight(-3);
        System.out.println(i);
    }
}
