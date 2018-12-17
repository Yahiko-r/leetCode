package backtracking;

import java.util.Set;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        int height = board.length;
        int width=board[0].length;
        char[] charList = word.toCharArray();
        int charPos=0;
        for (int i = 0; i < height; i++) {   //对字符串中的每个字符
            for (int j = 0; j < width; j++) {


                    boolean rs=isExist(board,charList,charPos,i,j);
                    if(rs==true)return true;


            }
        }
        return false;
    }

    private boolean isExist(char[][] board, char[] word,int charPos,int i, int j){
        if(charPos==word.length)return true;
        if(i<0||j<0||i==board.length||j==board[0].length||board[i][j]!=word[charPos])return false;
        board[i][j]='*';
        boolean rs=isExist(board,word,charPos+1,i,j+1)||
                isExist(board,word,charPos+1,i,j-1)||
                isExist(board,word,charPos+1,i-1,j)||
                isExist(board,word,charPos+1,i+1,j);
        board[i][j]=word[charPos];
        return rs;


    }
}
