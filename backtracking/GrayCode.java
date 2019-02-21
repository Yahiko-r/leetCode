package backtracking;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {
    public List<Integer> grayCode(int n) {

        List<Integer> rs = new ArrayList<>(1<<n);
        rs.add(0);
        if (n == 0) return rs;
        int idx = 1;
        int addition;
        for (int m = 0; m < n; m++) {
            addition = 1 << m;
            for (int k = idx - 1; k >= 0; k--) {
                rs.add(idx++, addition + rs.get(k));
            }
        }
        return rs;
    }
}
