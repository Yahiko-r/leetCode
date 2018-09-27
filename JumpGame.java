class Solution {
    public boolean canJump(int[] nums) {
       
        int[] num0=new int[nums.length];
        int j=0;int f=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                num0[j]=i;
                j++;
            }
        }
        if(j==0||(j==1&&nums.length==1))return true;
        for(int i=0;i<num0[f];i++){
            if(nums[i]+i>=nums.length-1)return true;
            if(nums[i]+i>num0[f]){
                f++;
                i--;
                if(f>=j){
                    return true;
                }
            }
        }
        return false;
    }
}