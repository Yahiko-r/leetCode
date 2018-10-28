import java.util.*;

public class SudokuSolver {
    public void solveSudoku(char[][] board){
        char[] nums={'1','2','3','4','5','6','7','8','9'};
        char[][] blank=new char[27][9];
        List<Integer> num=new ArrayList<>();
        List<List<Integer>> bl=new ArrayList<>(27);
        for(int i=0;i<9;i++){
            num.add(i);
        }
        Set<Integer> list=new HashSet<>();
        Set<Integer> list2=new HashSet<>();
        Set<Integer> list3=new HashSet<>();

        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
               if(board[i][j]!='.'){
                   list.add(board[i][j]-'0');
               }
               if(board[j][i]!='.'){
                   list2.add(board[j][i]-'0');
               }
               if(board[i/3*3+j/3][i%3*3+j%3]!='.'){
                   list3.add(board[i/3*3+j/3][i%3*3+j%3]-'0');
               }
            }
            for(int f=0;f<9;f++){
                if(!list.contains(f)) {
                    bl.get(f).add(f);
                }
                if(!list2.contains(f)){
                    bl.get(9+f).add(f);
                }
                if(!list3.contains(f)){
                    bl.get(18+f).add(f);
                }
            }
            list.clear();
            list2.clear();
            list3.clear();
        }
//        solveOthers(board,bl,0,0);

    }
//    public void solveOthers(char[][] board,List<List<Integer>> list,int iOfList,int jOfList){
//        for(int i=0;i<9;i++){
//            for(int j=0;j<9;j++){
//                if(board[i][j]=='.'){
//                    board[i][j]=(char)list.get(iOfList).get(jOfList);
//                }
//            }
//        }
//    }
}
