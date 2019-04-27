package array;

public class KthLargestElement {
    public int findKthLargest(int[] nums,int k){
        int left=0;int right=nums.length-1;

        k=nums.length-k;
        while(left<=right) {
            int partition = partition(nums, left, right);
            if (partition < k) {
                left=partition+1;
            } else if(partition > k) {
                right=partition-1;
            }else{
                break;
            }
        }

        return nums[k];
    }
    private int partition(int[] nums,int left,int right){
        int pivot=nums[left];
        int pos=left;
        left++;
        while(left<=right){
            //这种写法，无论有没有=，可能会超过数组范围
            //最稳的方法，把while改成if
            if(nums[left]<=pivot){
                left++;
            }
            else if(nums[right]>pivot){
                right--;
            }else {
                swap(nums, left++, right--);
            }
        }
        swap(nums,right,pos);
        return right;
    }
    public void swap(int[] nums,int left,int right){
        int temp=nums[left];
        nums[left]=nums[right];
        nums[right]=temp;
    }

    public static void main(String[] args) {
        int[] nums={2,3,4,1,6,8};
        KthLargestElement k=new KthLargestElement();
        int kthLargest = k.findKthLargest(nums, 3);
        System.out.println(kthLargest);

    }
}
