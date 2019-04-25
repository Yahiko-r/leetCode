package matrix;

public class SetMatrixZeros {
    public void setZeroes(int[][] matrix) {
        int col=0;
        for(int i=0;i<matrix.length;i++){
            if(matrix[i][0]==0){
                col=1;
            }
        }
        int row=0;
        for(int i=0;i<matrix[0].length;i++){
            if(matrix[0][i]==0){
                row=1;
            }
        }

        for(int i=1;i<matrix.length;i++){
            for(int j=1;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }
        for(int i=1;i<matrix.length;i++){
            if(matrix[i][0]==0){
                setRowZeroes(matrix,i);
            }
        }
        for(int j=1;j<matrix[0].length;j++){
            if(matrix[0][j]==0){
                setColZeroes(matrix,j);
            }
        }
        if(row==1){
            setRowZeroes(matrix,0);
        }
        if(col==1){
            setColZeroes(matrix,0);
        }

    }
    private void setRowZeroes(int[][] matrix,int row){
        for(int i=0;i<matrix[0].length;i++){
            matrix[row][i]=0;
        }
    }
    private void setColZeroes(int[][] matrix,int col){
        for(int i=0;i<matrix.length;i++){
            matrix[i][col]=0;
        }
    }



    public static void main(String[] args) {
        int[][] m = new int[3][3];
        for (int i = 0; i < 3; i++) {
            m[0][i] = 1;
            m[2][i] = 1;
        }
        m[1][0] = 1;
        m[1][1] = 0;
        m[1][2] = 1;
        SetMatrixZeros s = new SetMatrixZeros();
        s.setZeroes(m);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(m[i][j]+" ");
            }
            System.out.println(" ");
        }
    }
}
