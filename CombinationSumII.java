import java.util.*;

public class CombinationSumII {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> rs = new ArrayList<>();
        Arrays.sort(candidates);//一直想着怎么去重，先把数组排序简单很多
        find(candidates, 0, target, list, rs);
        return rs;
    }

    public static void find(int[] a, int begin, int target, List<Integer> list, List<List<Integer>> rs) {
        for (int i = begin; i < a.length; i++) {
            List<Integer> copy = new ArrayList<>(list);
            if (a[i] > target) break;
            else if (a[i] == target) {
                copy.add(a[i]);
                rs.add(copy);
                break;
            } else {
                if (i != begin && a[i] == a[i - 1]) continue;
                else {
                    copy.add(a[i]);
                    find(a, i + 1, target - a[i], copy, rs);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {10, 1, 2, 7, 6, 1, 5};
        List<List<Integer>> rs;
        rs = combinationSum2(a, 8);
        for (int i = 0; i < rs.size(); i++) {
            for (int j = 0; j < rs.get(i).size(); j++)
                System.out.print(rs.get(i).get(j) + ",");
            System.out.println(" ");
        }
    }
}
