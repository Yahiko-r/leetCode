public class RegularExpressionMatching {
    /*
    只考虑string的第一个能否在开头中找到匹配的，p有*时，要考虑前两个，其余的交给循环去做就行了。
     */
    public boolean isMatch(String s, String p) {
        if (p.isEmpty()) return s.isEmpty();
        boolean firstMatch = (!s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.'));

        if (p.length() >= 2 && p.charAt(1) == '*') {
            return (isMatch(s, p.substring(2)) || (firstMatch && isMatch(s.substring(1), p)));

        } else {
            return firstMatch && isMatch(s.substring(1), p.substring(1));
        }

    }

    /*
    按照顺序一个个0-i，0-j都测试能够匹配，用二位数组去记录能否被匹配到，测试数组中最后的点，缺点，如果不匹配也要走完全程（或许可以加个判断？？？）
    优点：
     */
    public boolean isMatch2(String s, String p) {
        boolean T[][] = new boolean[s.length()+1][p.length()+1];

        //初始化
        T[0][0] = true;
        for (int i = 1; i <= p.length(); i++) {
            if (p.charAt(i - 1) == '*') {
                T[0][i] = T[0][i - 2];
            }
        }
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                    T[i][j] = T[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    T[i][j] = T[i][j - 2];
                    if (p.charAt(j - 2) == '.' || p.charAt(j - 2) == s.charAt(i - 1)) {
                        T[i][j]=T[i][j]|T[i-1][j];
                    }
                }else{
                    T[i][j]=false;
                }
            }
        }
        return T[s.length()][p.length()];

    }
    public void test(){
        boolean rs=isMatch2("aa","a*");
        System.out.println(rs);
    }

    public static void main(String[] args) {
        RegularExpressionMatching r=new RegularExpressionMatching();
        r.test();
    }
}
