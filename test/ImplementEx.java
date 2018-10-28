package test;

 interface InterfaceEx {
    void func1();
    default void func2(){
        System.out.println("func2");
    }
    int x=0;
}
public class ImplementEx implements InterfaceEx{

    @Override
    public void func1() {
        System.out.println("func1");
    }

    public static void main(String[] args) {
        ImplementEx a=new ImplementEx();
        a.func1();
        a.func2();
    }
}
