package other;

public class PowXY {
    public double myPow(double x,int n){
        double r=1;

        if(n<0){
            x=1/x;
            n=-(n+1);
            r=r*x;
        }

        while(n!=0){
            if((n&1)==1){
                r*=x;
            }
            x*=x;
            n=n>>1;
        }
        return r;

    }
    public static void main(String[] args) {
        PowXY p=new PowXY();
        int a=-2147483648;
        a=-a;
        System.out.println(a);
        System.out.println("over");
    }
}
