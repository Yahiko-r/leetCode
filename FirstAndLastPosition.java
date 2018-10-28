public class FirstAndLastPosition {
    /**两次二分分别找左右就行了，刚开始想着能不能一次循环直接找出两侧，找出mid==target之后，需要再嵌套循环才能分别找出，更麻烦
     *
     */
    public static int[] searchRange(int[] nums,int target){
        int l=nums.length;
        int left=0,right=l-1,first=-1,last=-1;
        if(l==0||target<nums[0]||target>nums[l-1])return new int[]{first,last};
        while(left<right){
            int mid =(left+right)/2;
            if(nums[mid]<target)left=mid+1;
            else{
                right=mid;
            }
        }
        if(nums[left]!=target)return new int[]{first,last};
        first=left;
        right=l-1;
        while(left<right){
            int mid=(left+right+1)/2;
            if(nums[mid]>target)right=mid-1;
            else left=mid;
        }
        last=right;
        return new int[]{first,last};
    }

    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int[] r = searchRange(nums, 5);
        for (int i = 0; i < r.length; i++)
            System.out.println(r[i]);
    }
}
