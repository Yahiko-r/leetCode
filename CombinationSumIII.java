import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k,int n){
        List<List<Integer>> rs=new ArrayList<>();
        find(rs,new ArrayList<>(),k,n,0);
        return rs;
    }
    public void find(List<List<Integer>> rs,List<Integer> tmp,int k,int n,int sum) {
        if (0== k) {
            if (sum == n) rs.add(new ArrayList<>(tmp));
            return;
        }
        int i = tmp.size() == 0 ? 1 : tmp.get(tmp.size() - 1) + 1;
        for (; i <= 9; i++) {
            if (sum + i <= n) {
                tmp.add(i);
                find(rs, tmp, k - 1, n, sum + i);
                tmp.remove(tmp.size() - 1);
            } else break;
        }
    }
}
