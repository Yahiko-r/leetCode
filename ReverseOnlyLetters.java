public class ReverseOnlyLetters {
    public String reverseOnlyLetters(String S) {
        int len = S.length();
        StringBuilder tmp = new StringBuilder(S);
        int i = 0, j = len - 1;
        while (i < j) {


            while (i<j&&(!((S.charAt(i) >= 'a' && S.charAt(i) <= 'z') || (S.charAt(i) >= 'A' && S.charAt(i) <= 'Z')))) i++;
            while (j>i&&(!((S.charAt(j) >= 'a' && S.charAt(j) <= 'z') || (S.charAt(j) >= 'A' && S.charAt(j) <= 'Z')))) j--;
            if (i < j) {
                tmp.setCharAt(i, S.charAt(j));
                tmp.setCharAt(j, S.charAt(i));
                i++;j--;
            }
        }
        return tmp.toString();
    }

    public static void main(String[] args) {
        String S="7_28]";
        ReverseOnlyLetters r=new ReverseOnlyLetters();
        System.out.println(r.reverseOnlyLetters(S));
    }
}
