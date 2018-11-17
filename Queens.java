import com.sun.xml.internal.bind.v2.TODO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Queens {
    public List<List<String>> solveQueens(int n) {
        List<List<String>> rs = new ArrayList<>();
        List<List<Integer>> r = new ArrayList<>();
        List<Integer> col=new ArrayList<>(n);
        backtracking(n,col,r);
        if(r!=null)
            addChar(rs,r);
        return rs;
    }

    public void backtracking(int n, List<Integer> col, List<List<Integer>> r) {
        int l = col.size();
        if (n == l) {
            r.add(col);
        } else {
            int now = col.size();
            int[] atkPos = new int[n];
            for (int j = 0; j < now; j++) {

                int posJ = col.get(j);
                atkPos[posJ] = 1;
                if (posJ + now - j < n)
                    atkPos[posJ + now - j] = 1;
                if (posJ - now + j >= 0)
                    atkPos[posJ - now + j] = 1;
            }

            for (int i = 0; i < n; i++) {
                //位置i能不能放皇后
                if (atkPos[i] == 1) continue;
                else {
                    List<Integer> newList = new ArrayList<>(col);
                    newList.add(i);
                    backtracking(n, newList, r);
                }
            }
        }
    }

    public void addChar(List<List<String>> rs, List<List<Integer>> pos) {
        for(int i=0;i<pos.size();i++){
            int n=pos.get(0).size();//就是n
            List<String> s=new ArrayList<>(n);
            for(int j=0;j<n;j++){
                char[] c=new char[n];
                for(int k=0;k<n;k++)
                    c[k]='.';
                int Qpos=pos.get(i).get(j);
                c[Qpos]='Q';
                s.add(new String(c));
            }
            rs.add(s);
        }
    }

    public static void main(String[] args) {
        Queens q=new Queens();
        List<List<String>> r=new ArrayList<>();
        r=q.solveQueens(4);
        System.out.println(r);
    }
}
//n 为当前行数，i为n行的遍历，
//        for(int i=0;i<n;i++) {
//            if (board[n][i] == 1) continue;
//            else {//剩余行，皇后攻击到的位置放1；
//                int[][] newBoard=new int[][](board);//这里问题是多种可能性怎么存放
//                for (int j = n + 1; j < board.length; j++) {
//                    board[j][i] = 1;
//                    if (j - n + i < board.length)
//                        board[j][j - n + i] = 1;
//                    if (i - j + n >= 0)
//                        board[j][i - j + n] = 1;
//                }
//            }
//
//
//
//        }