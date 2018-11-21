import java.util.ArrayList;
import java.util.List;

public class spiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix){
        if(matrix==null)return new ArrayList<Integer>();
        int row=matrix.length,col=matrix[0].length;
        int left=0,right=col-1,up=0,down=row-1;
        List<Integer> rs=new ArrayList<>();
        while(true){
            for(int i=left;i<=right;i++){
                rs.add(matrix[up][i]);
            }
            up++;
            if(up>down)break;
            for(int j=up;j<=down;j++){
                rs.add(matrix[j][right]);
            }
            right--;
            if(right<left)break;
            for(int k=right;k>=left;k--){
                rs.add(matrix[down][k]);
            }
            down--;
            if(down<up)break;
            for(int l=down;l>=up;l--){
                rs.add(matrix[l][left]);
            }
            left++;
            if(left>right)break;
        }

        return rs;
    }

    public static void main(String[] args) {
        int[][] m=new int[3][3];
        int num=1;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                m[i][j]=num;
                num++;
            }
        }
        spiralMatrix s=new spiralMatrix();
        List<Integer> rs=s.spiralOrder(m);
        System.out.println(rs);
    }
}
