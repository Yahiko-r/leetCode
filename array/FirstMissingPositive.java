package array;



public class FirstMissingPositive {
    /**
     * https://zhuanlan.zhihu.com/p/25865715
     * 看的别人的提示，主要思路是数组本身就能够标记
     * 写非常不简洁，需要改进。
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums){
        int length=nums.length;
        int right=length-1,left=0;
        for(;left<right;left++){
            if(nums[left]!=left+1){
                if(nums[left]>=length||nums[left]<=0){
                    swap(nums,left,right);
                    right--;
                }
                else{
                    if(nums[nums[left]-1]==nums[left]){
                        swap(nums,left,right);
                        right--;
                    }else {
                        swap(nums, left, nums[left] - 1);
                    }
                }
                left--;

            }
        }
        for(int i=0;i<length;i++){
            if(nums[i]-1!=i){
                return i+1;
            }
        }
        return length+1;

    }

    private void swap(int[] nums,int left,int right){
        int temp=nums[left];
        nums[left]=nums[right];
        nums[right]=temp;

    }

}
