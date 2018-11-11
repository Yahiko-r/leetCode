import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> rs = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        int inx = 0;
        if (inx < nums.length)
            subset(nums, inx, rs, cur);
        return rs;
    }

    public void subset(int[] nums, int inx, List<List<Integer>> rs, List<Integer> cur) {
        if (inx == nums.length) {
            rs.add(cur);
        } else if (inx < nums.length) {
            List<Integer> addNum=new ArrayList<>(cur);
            subset(nums, inx + 1, rs, cur);

            addNum.add(nums[inx]);
            subset(nums, inx + 1, rs, addNum);
        }
    }

    public static void main(String[] args) {
        Subsets s=new Subsets();
        int[] nums=new int[]{1,2,3};
        List<List<Integer>> rs=s.subsets(nums);
        for(int i=0;i<rs.size();i++){
            for(int j=0;j<rs.get(i).size();j++)
                System.out.println(rs.get(i).get(j));
            System.out.println("---");
        }

    }
}
