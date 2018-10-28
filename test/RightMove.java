package test;

public class RightMove {
    public static int test(int n){
      int a=n>>1;
        return a;
    }

    public static void main(String[] args) {
        int n=1;
        n=test(n);
        System.out.println(n);
    }
}
