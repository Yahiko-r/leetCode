public class UniquePathsII {
    //时间复杂度太高了
    static int rs=0;
    public static int uniquePathsWithObstacles(int[][] obstacleGrid){
        int m=obstacleGrid.length,n=obstacleGrid[0].length;
        rs=0;
        if(obstacleGrid[0][0]==1)return 0;
        findNextPath(obstacleGrid,0,0);
        return rs;
    }

    public static void findNextPath(int[][] obstacleGrid,int i,int j){
        if(i==obstacleGrid.length-1&&j==obstacleGrid[0].length-1) rs++;
        else if(j+1<=obstacleGrid[0].length-1&&obstacleGrid[i][j+1]!=1){
            findNextPath(obstacleGrid,i,j+1);
        }
        if(i+1<=obstacleGrid.length-1&&obstacleGrid[i+1][j]!=1){
            findNextPath(obstacleGrid,i+1,j);
        }
    }

    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        int width = obstacleGrid[0].length;
        int[] dp = new int[width];
        dp[0] = 1;
        for (int[] row : obstacleGrid) {
            for (int j = 0; j < width; j++) {
                if (row[j] == 1)
                    dp[j] = 0;
                else if (j > 0)
                    dp[j] += dp[j - 1];
            }
        }
        return dp[width - 1];
    }

    public static void main(String[] args) {
        int[][] ob=new int[1][1];
        ob[0][0]=0;
        int rs=uniquePathsWithObstacles(ob);
        System.out.println(rs);
    }

}
