package test;

public class IntegerTest {
    public static void main(String[] args) {
//        String s1=new StringBuilder("ji").toString();
//        String s2=new StringBuilder("java").toString();
//        System.out.println(s1.intern()==s1);
//        System.out.println(s2.intern()==s2);
        test();
    }
    public static void test(){
        String s = new String("1");
        s.intern();
        String s2 = "1";
        System.out.println(s == s2);

        String s3 = new String("1");
       // s3.intern();
        String s4 = "1";
        System.out.println(s3 == s4);
    }

}
