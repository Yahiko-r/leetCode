public class SearchA2DMatrix {
    public static boolean searchMatrix(int[][] matrix,int target){
        if(matrix==null||matrix.length==0||matrix[0].length==0)return false;
        int row=matrix.length;
        int col=matrix[0].length;
        if(matrix[0][0]>target)return false;
        if(matrix[row-1][col-1]<target)return false;
        int i=0,j=row-1,m=0,n=col-1;int rRow = 0;
        if(row>1) {
            while (i <= j) {
                int mid = (i + j) / 2;
                if (target > matrix[mid][0]) {
                    i = mid + 1;
                } else if (target < matrix[mid][0]) {
                    j = mid - 1;
                } else
                    return true;
            }
            rRow=i-1;
        }
        while(m<=n){
            int mid=(m+n)/2;
            if(target>matrix[rRow][mid])
                m=mid+1;
            else if(target<matrix[rRow][mid])
                n=mid-1;
            else
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix=new int[1][2];
        matrix[0][0]=1;
        matrix[0][1]=3;
        boolean rs=SearchA2DMatrix.searchMatrix(matrix,2);
        System.out.println(rs);
    }
}
