public class NextPermutation {
    public void nextPermutation(int[] nums){
        int l=nums.length;
        int i=l-2;
        for(;i>=0;i--){

            if(nums[i]<nums[i+1]){
                break;
            }
        }
        for(int j=l-1;j>i;j--){
            if(i==-1)break;
            if(nums[j]>nums[i]) {
                swap(nums,i,j);
                break;
            }

        }
       int m=i+1,n=l-1;
        while(m<n){
            swap(nums,m,n);
            m++;
            n--;
        }

    }
    public void swap(int[] nums,int i,int j){
       int temp=nums[i];
       nums[i]=nums[j];
       nums[j]=temp;
    }

    public static void main(String[] args) {
        NextPermutation np=new NextPermutation();
        int[] nums={3,2,1};
        np.nextPermutation(nums);

    }
}
