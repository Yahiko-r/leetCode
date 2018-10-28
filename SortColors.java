public class SortColors {
    public void sortColors(int[] nums){
        int a=0,b=nums.length-1;
        for(int i=0;i<=b;i++){
            if(nums[i]==0){
                nums[i]=nums[a];
                nums[a]=0;
                a++;
            }else if(nums[i]==2){
                nums[i]=nums[b];
                nums[b]=2;
                b--;
                i--;
            }

        }

    }
}
