public class DivideTwoNum {
    public static  int divide(int dividend,int divisor){
        int sign;
        if(divisor==0)return Integer.MAX_VALUE;
        if((dividend>0&&divisor<0)||(dividend<0&&divisor>0))sign=-1;
        else
            sign=1;
        long absDd=Math.abs((long)dividend);
        long absDs=Math.abs((long)divisor);
        long rs=0;

        while(absDd>absDs){
            long count=1;
            long temp=absDs;
            while(absDd>temp){
                temp<<=1;
                count<<=1;
            }
            rs+=count>>1;
            absDd-=temp>>1;
        }
        return sign>0?rs>Integer.MAX_VALUE?Integer.MAX_VALUE:(int)rs:(int)~rs+1;

    }

    public static void main(String[] args) {
        int r=divide(10,3);
        System.out.println(r);
    }
}
