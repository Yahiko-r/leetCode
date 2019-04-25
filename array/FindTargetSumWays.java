package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**全排列
 * 超时了。。
 *
 */
public class FindTargetSumWays {

    /**
     * 这种傻逼写法怎么想出来的，明显可以优化
     * list和rs完全是没有必要的，因为没有要求记录具体的操作
     * * @param nums
     * @param S
     * @return
     */
    public int findTarget(int[] nums,int S){
        /*List<Integer> list=new ArrayList<>();

        int rs=0;
        List<List<Integer>> rss=new ArrayList<>();
        find(0,nums,S,list,0,rss);*/
        calculate(nums,0,0,S);
        return count;
    }
    public void find(int cur,int[] nums,int s,List<Integer> list,int now,List<List<Integer>> rs){
        if(cur==nums.length&&now==s){
            rs.add(list);
        }

        if(cur<nums.length){
                list.add(1);
                find(cur+1, nums, s,new ArrayList<Integer>(list),now+nums[cur],rs);
                list.remove(list.size()-1);
                list.add(-1);
                find(cur+1,nums,s,list,now-nums[cur],rs);
        }
    }


    private int count=0;
    public void calculate(int[] nums,int i,int sum,int S){
        if(i==nums.length){
            if(sum==S){
                count++;
            }
        }
        else{
            calculate(nums,i+1,sum+nums[i],S);
            calculate(nums,i+1,sum-nums[i],S);
        }
    }


    /**
     * 用一个数组来记录，走到i位置时能够得到的不同的值，下表表示当前sum值，value表示后面的数字还能排列成多少个结果。
     * 还是有种全排列的感觉。
     * @param nums
     * @param S
     * @return
     */
    public int findTargetSumWays(int[] nums, int S) {
        int[][] memo = new int[nums.length][2001];
        for (int[] row: memo)
            Arrays.fill(row, Integer.MIN_VALUE);
        return calculate(nums, 0, 0, S, memo);
    }
    public int calculate(int[] nums, int i, int sum, int S, int[][] memo) {
        if (i == nums.length) {
            if (sum == S)
                return 1;
            else
                return 0;
        } else {
            if (memo[i][sum + 1000] != Integer.MIN_VALUE) {
                return memo[i][sum + 1000];
            }
            int add = calculate(nums, i + 1, sum + nums[i], S, memo);
            int subtract = calculate(nums, i + 1, sum - nums[i], S, memo);
            memo[i][sum + 1000] = add + subtract;
            return memo[i][sum + 1000];
        }
    }

    /**
     * 讨论区最高赞，dp
     * 这里从sum=1,从sum开始是为了考虑全为-的情形
     *
     * @param nums
     * @param s
     * @return
     */
    public int findII(int[] nums,int s){
        int sum = 0;
        for(int i: nums) sum+=i;
        if(s>sum || s<-sum) return 0;
        int[] dp = new int[2*sum+1];
        dp[0+sum] = 1;
        for(int i = 0; i<nums.length; i++){
            int[] next = new int[2*sum+1];
            for(int k = 0; k<2*sum+1; k++){
                if(dp[k]!=0){
                    next[k + nums[i]] += dp[k];
                    next[k - nums[i]] += dp[k];
                }
            }
            dp = next;
        }
        return dp[sum+s];
    }

    public static void main(String[] args) {
        FindTargetSumWays f=new FindTargetSumWays();
        int[] nums={1, 1, 1, 1, 1};


        int target = f.findII(nums, 3);
        System.out.println(target);
    }
}
