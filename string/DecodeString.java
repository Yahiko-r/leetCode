package string;

import java.util.Stack;

public class DecodeString {
    public String decodeString(String s){
        Stack<String> stringStack=new Stack<>();
        Stack<Integer> numStack=new Stack<>();

        int i=0;
        StringBuilder sb=new StringBuilder();

        int sum=0;
        while(i<s.length()){
            int n=s.charAt(i)-'0';
            if(n>=0&&n<=9){
                sum=sum*10+n;
                i++;
            }
            else if(s.charAt(i)=='['){
                numStack.push(sum);
                sum=0;
                stringStack.push(sb.toString());
                sb=new StringBuilder();
                i++;
            }
            else if(s.charAt(i)==']'){
                int times=numStack.pop();
                StringBuilder tmp=new StringBuilder();
                tmp.append(stringStack.pop());
                for(int j=0;j<times;j++){
                    tmp.append(sb.toString());
                }
                sb=tmp;

//                stringStack.push(tmp.toString());
//                sb=new StringBuilder();
                i++;

            }else {
                sb.append(s.charAt(i));
                i++;
            }

        }
//        sb.insert(0,stringStack.pop());
        return sb.toString();



    }

    public static void main(String[] args) {
        DecodeString d=new DecodeString();
        String s="2[abc]3[cd]ef";
        String s1 = d.decodeString(s);
        System.out.println(s1);
    }
}
