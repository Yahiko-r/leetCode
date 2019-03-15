package array;

public class MoveZeroes {
    public void moveZeroes(int[] nums){
        int pos=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                if(pos!=i){
                    nums[pos]=nums[i];
                }
                pos++;

            }
        }
        while(pos<nums.length){
            nums[pos]=0;
            pos++;
        }
    }

    public static void main(String[] args) {
        int[] nums={0,1,0,3,12};
        MoveZeroes m=new MoveZeroes();
        m.moveZeroes(nums);
        for(int i=0;i<nums.length;i++)
             System.out.println(nums[i]);
    }
}
