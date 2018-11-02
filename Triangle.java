import java.util.List;

public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle){
        if(triangle==null)return 0;
        return findmin(triangle,0,0);

    }

    /**
     * 遍历所有可能性
     * @param t
     * @param layer
     * @param pos
     * @return
     */
    public int findmin(List<List<Integer>> t,int layer,int pos){
        int min=0;
        if(layer==t.size()-1){
            return Math.min(t.get(layer).get(pos).intValue(),t.get(layer).get(pos+1).intValue());
        }
        int left=findmin(t,layer+1,pos);
        int right=findmin(t,layer+1,pos+1);
        return Math.min(left,right)+t.get(layer).get(pos).intValue();
    }

    /**
     * 和之前遍历矩阵一个方法
     * @param triangle
     * @return
     */
    public int minimumTotal2(List<List<Integer>> triangle){
        int[] result = new int[triangle.size() + 1];
        for (int i = triangle.size() - 1; i >= 0; i--) {
            List<Integer> currRow = triangle.get(i);
            for (int j = 0; j < currRow.size(); j++) {
                result[j] = Math.min(result[j], result[j+1]) + currRow.get(j);
            }
        }
        return result[0];
    }


}
