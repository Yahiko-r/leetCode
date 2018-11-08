public class SpiralMatrixII {
    public int[][] generateMatrix(int n){
        int right=0,left=0,north=0,south=0,num=1;
        int[][] rs=new int[n][n];
        while(num<=n*n) {
            for (int i =  left; i < n - right; i++) {
                rs[north][i]=num;
                num++;
            }
            if(num>n*n)break;
            north++;
            for(int down=north;down<n-south-1;down++){
                rs[down][n-right-1]=num;
                num++;
            }
            right++;
            if(num>n*n)break;
            for(int back=n-right;back>=left;back--){
                rs[n-south-1][back]=num;
                num++;
            }
            south++;
            for(int up=n-south-1;up>=north;up--){
                rs[up][left]=num;
                num++;
            }
            left++;
        }
        return rs;
    }

    public static void main(String[] args) {
        SpiralMatrixII s=new SpiralMatrixII();
        int [][] sd=s.generateMatrix(3);
        System.out.println(sd);
    }
}
