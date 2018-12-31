package array;

public class SearchInRotatedSortedArrayII {
    public boolean search(int[] nums,int target){
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return true;
            else {
                if (nums[mid] < nums[right]) {
                    if (nums[mid] < target && target <= nums[right]) left = mid + 1;
                    else {
                        right = mid - 1;
                    }
                } else if(nums[mid]>nums[right]){
                    if (nums[mid] > target && target >= nums[left]) right = mid - 1;
                    else {
                        left = mid + 1;
                    }
                 //此时，中间和最右边相同，有重复的元素，将最右边排除
                }else {
                    right--;
                    }
                }

            }

        return false;
    }
}
