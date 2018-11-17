public class UniquePaths {
    public int uniquePaths(int m,int n){
        int[][] rs=new int[n][m];
        for(int i=0;i<m;i++){
            rs[0][i]=1;
        }
        for(int j=0;j<n;j++){
            rs[j][0]=1;
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                rs[i][j]=rs[i-1][j]+rs[i][j-1];
            }
        }
        return rs[n-1][m-1];
    }
}
