package array;

public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {

        int left=0;
        int sum=0;
        int rs=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            while(sum>=s){
                rs=Math.min(rs,i-left+1);
                sum-=nums[left];
                left++;
            }
        }
        return rs;
    }
}
