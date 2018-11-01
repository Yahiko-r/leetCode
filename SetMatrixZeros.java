public class SetMatrixZeros {
    public void setZeroes(int[][] matrix) {

        for (int i = 0; i <= matrix.length - 1; i++) {
            for (int j = 0; j <= matrix[0].length - 1; j++) {
                if (matrix[i][j] == 0) {
                    setUpAndLeftZero(matrix, i, j);
                    setDownAndLeft(matrix, i, j);
                }
            }
        }
    }

    public void setUpAndLeftZero(int[][] matrix, int row, int col) {
        for (int i = col; i >= 0; i--) {
            if (i > 0 && matrix[row][i - 1] == 0) break;
            else {
                matrix[row][i] = 0;
            }
        }
        for (int i = row - 1; i >= 0; i--) {
            if (i > 0 && matrix[i - 1][col] == 0) break;
            else
                matrix[i][col] = 0;
        }
    }

    public void setDownAndLeft(int[][] matrix, int row, int col) {
        for (int i = col; i < matrix[0].length; i++) {
            if (matrix[row][i] == 0) {
                setUpAndLeftZero(matrix, row, i);

            } else
                matrix[row][i] = 0;
        }
        for (int i = row; i < matrix.length; i++) {
            if (matrix[i][col] == 0) {
                setUpAndLeftZero(matrix, row, col);
            } else
                matrix[i][col] = 0;
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
                System.out.println(m[i][j]);
            }
        }
    }
}
