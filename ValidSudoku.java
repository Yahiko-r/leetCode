import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board){
        int i=0,j=0;

        Set<Character> list=new HashSet<>();
        Set<Character> list2=new HashSet<>();

        for(i=0;i<9;i++) {
            for (j=0; j < 9; j++) {
                if(board[i][j]!='.'){
                    if(list.contains(board[i][j]))return false;
                    else
                        list.add(board[i][j]);
                }
                if(board[j][i]!='.'){
                    if(list2.contains(board[j][i]))return false;
                    else
                        list2.add(board[j][i]);
                }
            }
            list.clear();
            list2.clear();
        }


        for(int row=0;row<3;row++){
            for(int column=0;column<3;column++){
                for(i=0+3*row;i<3+3*row;i++){
                    for(j=0+3*column;j<3+3*column;j++){
                        if(board[i][j]!='.'){
                            if(list.contains(board[i][j]))return false;
                            else
                                list.add(board[i][j]);
                        }
                    }
                }
                list.clear();

            }
        }
        return true;

    }
}
