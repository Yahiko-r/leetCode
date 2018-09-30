import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums.length < 4 && target == 0) return new ArrayList<List<Integer>>();

        Arrays.sort(nums);
        List<List<Integer>> rs = new ArrayList<>();
        for (int n1 = 0; n1 <= nums.length - 4; n1++) {
            for (int n2 = n1 + 1; n2 <= nums.length - 3; n2++) {
                int i = n2 + 1;
                int j = nums.length - 1;
                while (i < j) {
                    int sum = nums[n1] + nums[n2] + nums[i] + nums[j];
                    if (sum == target) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[n1]);
                        temp.add(nums[n2]);
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        if (!rs.contains(temp))
                            rs.add(temp);
                        while (i < nums.length - 1 && nums[i] == nums[i + 1]) i++;
                        while (j > 0 && nums[j] == nums[j - 1]) j--;
                        j--;
                        i++;
                    } else if (sum > target) {

                        while (j > 0 && nums[j] == nums[j - 1]) j--;
                        j--;
                    } else if (sum < target) {
                        while (i < nums.length - 1 && nums[i] == nums[i + 1]) i++;
                        i++;
                    }
                }
            }
        }
        return rs;
    }

}
