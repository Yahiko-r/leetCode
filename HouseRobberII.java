public class HouseRobberII {
    public int rob(int[] nums,int be,int end) {
        int pre1=0,pre2=0;
        for(int i=be;i<=end;i++){
            int temp=pre2;
            pre2=Math.max(pre1+nums[i],pre2);
            pre1=temp;
        }
        return pre2;
    }
    public int rob(int[] nums){
        if(nums.length==1)return nums[0];
        return Math.max(rob(nums,0,nums.length-2),rob(nums,1,nums.length-1));

    }
}
