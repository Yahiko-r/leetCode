package array;

public class Search2DMatrixII {
    public boolean searchmatrix(int[][] matrix,int target){

        if(matrix==null||matrix.length==0)return false;
        int n=matrix[0].length;
        return search(matrix,target,0,n-1);
    }
    public boolean search(int[][] matrix,int target,int m,int n){
        if(m>=matrix.length||n<0)return false;

        if(matrix[m][n]>target){
             return search(matrix,target,m,n-1);
        }else if(matrix[m][n]<target){
            return  search(matrix,target,m+1,n);
        }else{
            return true;
        }
    }
}
