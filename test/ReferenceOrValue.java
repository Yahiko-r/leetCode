package test;

import java.util.Arrays;

public class ReferenceOrValue {
    public void test1(int[] a) {
        Arrays.sort(a);
    }

    //对象a传进去，可以直接修改。
    public int[] test2(int[] a) {
        a[0] = 10;
        int[] b = new int[]{4, 5, 8};
        b[2] = a[0];
        return b;
    }

    public int[] test3(int[] a, int[] b) {
        a = b;
        a[0] = 12;
        print(a);
        return a;
    }

    //形参中的a，和原来的a指向同一个地址，但是两个引用a是不同的。
    public void test4(int[] a, int[] b) {
        a = b;
        print(a);
    }

    public void print(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
        System.out.println(" ");
    }

    public static void main(String[] args) {
        ReferenceOrValue v = new ReferenceOrValue();
        int[] a = {0, 9, 8, 7};
        int[] b = {4, 3, 2, 1};
        v.test1(a);
        v.print(a);
        v.test2(a);
        v.print(a);
        v.test3(a, b);
        v.print(a);
        v.test4(a, b);
        v.print(a);
    }
}
