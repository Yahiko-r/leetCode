package test;

public class ValueTransmissionTest {
    public static int test(int a,int b){
        int t=a;
        a=b;
        b=t;
        return a;
    }

    public static void main(String[] args) {
        int a=1,b=2;
        System.out.println(test(a,b));
    }
}
