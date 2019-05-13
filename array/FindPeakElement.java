package array;

/**
 * 题目很简单，但是
 * 要求log(n)的复杂度，
 * 遇到num[i]>num[i+1],i即为所求
 *
 */
public class FindPeakElement {
    public int findPeakElement(int[] nums){
        int length=nums.length;
        int left=0,right=length-1;
        while(left<right){
            int mid=left+(right-left)/2;
            int next=mid+1;
            if(nums[mid]<nums[next]){
                left=next;
            }else{
                right=mid;
            }
        }

        return left;
    }
}
