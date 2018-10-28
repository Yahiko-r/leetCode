import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {
//        SingleTon singleTon = SingleTon.getInstance();
//        System.out.println("count1=" + singleTon.count1);
//        System.out.println("count2=" + singleTon.count2);
        Pattern p=Pattern.compile("a*b");
        Matcher m=p.matcher("faaaaaabcdef");
        boolean b=m.matches();
        boolean c=m.find();
        boolean d=m.lookingAt();

    }
}

class clinit{

}
class SingleTon {

    public static int count1;
    public static int count2 = 0;
    private static SingleTon singleTon = new SingleTon();

    private SingleTon() {
        count1++;
        count2++;
    }

    public static SingleTon getInstance() {
        return singleTon;
    }
}
