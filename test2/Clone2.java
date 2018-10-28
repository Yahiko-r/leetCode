package test2;

import test.CloneEx;

public class Clone2 extends CloneEx{
    public void pr(){
        Clone2 cl2 =new Clone2();
        CloneEx cl=new CloneEx();
        cl2.test();
    }
    public static void main(String[] args) {
        Clone2 c=new Clone2();
        c.pr();


    }
}
