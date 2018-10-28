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

    public List<List<Integer>> test(int[] nums , int target)

    {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList();
        for (int i = 0; i < nums.length - 3; i++) {
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            if (nums[i] + nums[nums.length - 1] + nums[nums.length - 2] + nums[nums.length - 3] < target) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }

                if (nums[i] + nums[j] + nums[nums.length - 1] + nums[nums.length - 2] < target) {
                    continue;
                }
                int t = target - nums[i] - nums[j];
                int l = j + 1;
                int r = nums.length - 1;

                while (l < r) {
                    if (nums[l] + nums[r] == t) {
                        List<Integer> tmp = new ArrayList();
                        tmp.add(nums[i]);
                        tmp.add(nums[j]);
                        tmp.add(nums[l]);
                        tmp.add(nums[r]);
                        res.add(tmp);
                        while (l + 1 < r && nums[l] == nums[l + 1]) {
                            l++;
                        }
                        l++;
                        while (l < r - 1 && nums[r] == nums[r - 1]) {
                            r--;
                        }
                        r--;

                    } else if (nums[l] + nums[r] > t) {
                        r--;
                    } else {
                        l++;
                    }
                }

                while (j + 1 < nums.length && nums[j] == nums[j + 1]) {
                    j++;
                }
            }
            while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                i++;
            }
        }

        return res;
    }

}
