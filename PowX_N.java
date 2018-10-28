public class PowX_N {
    public static double myPow(double x,int n){
        int absN=Math.abs(n);
        double rs=1;
        while(absN>0){
            if((absN&1)==1)rs=rs*x;
            absN>>=1;
            x*=x;
        }
        return n>0?rs:1/rs;
    }

    public static void main(String[] args) {
        double rs=myPow(2.0,4);
        System.out.println(rs);
    }
}
