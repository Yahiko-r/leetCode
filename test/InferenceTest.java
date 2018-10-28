package test;

public class InferenceTest {
    class Node{
        int a;
        Node next;
        Node(int a){
            this.a=a;
        }
    }
    public void test(){

        Node node= new Node(9);
        Node node1=node;
        node=null;
        System.out.println(node1.a);
    }
    public static void main(String[] args) {
        InferenceTest i=new InferenceTest();
        i.test();
    }

}
