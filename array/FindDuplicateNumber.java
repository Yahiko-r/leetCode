package array;

//将数组当成一个链表来看待，链表中的环就是重复的数字。
//因为数组的值不是从0开始，所以nums[0]必然不在环中，还有就是值都小于数组的长度。
public class FindDuplicateNumber {
    public int findDuplicate(int[] nums){
        int fast=nums[nums[0]];
        int slow=nums[0];
        while(fast!=slow){
            slow=nums[slow];
            fast=nums[nums[fast]];
        }
        fast=0;
        while(fast!=slow){
            slow=nums[slow];
            fast=nums[fast];
        }
        return slow;

    }
}
