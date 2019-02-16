package other;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangleII {
    public List<Integer> getRow(int rowIndex){
        List<Integer> rs=new ArrayList<>();
        for(int i=0;i<=rowIndex;i++){
            rs.add(1);
            for(int j=i-1;j>0;j--){
                rs.set(j,rs.get(j)+rs.get(j-1));
            }
        }
        return rs;
    }
}
