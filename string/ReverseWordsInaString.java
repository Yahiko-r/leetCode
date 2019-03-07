package string;

public class ReverseWordsInaString {
    public String reverseWords(String s){
        int star,flag=0;
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!=' '){
                i=add(i,s,sb);
            }
        }
        if(sb.length()==0)return "";
        return sb.substring(0,sb.length()-1);
    }
    private  int add(int start,String s,StringBuilder sv){
        int i=start+1;
        while(i<s.length()){
            if(s.charAt(i)==' '){
                sv.insert(0,s.substring(start,i)+' ');
                return i;
            }
            i++;
        }
        sv.insert(0,s.substring(start,i)+' ');
        return i;
    }

    public static void main(String[] args) {
        String s=" ";
        ReverseWordsInaString r=new ReverseWordsInaString();
        String s1 = r.reverseWords(s);
        System.out.println(s1);
    }
}
