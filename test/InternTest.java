package test;

public class InternTest {
    public static void main(String[] args) {

        String s1 = new StringBuilder("漠").append("然").toString();
        System.out.println(s1.intern() == s1);

        String s2 = new StringBuilder("ja").append("va").toString();
        System.out.println(s2.intern() == s2);

    }
}
