package array;

public class MajorityElement {
    public int majortyElement(int[] nums){
        int cur=nums[0],count=1;
        for(int i=1;i<nums.length;i++){
//            cur=nums[i];
            if(cur!=nums[i]){
//                count--;
                if(count==1){
                    cur=nums[i];
                }else{
                    count--;
                }

            }else{
                count++;
            }
        }
        return cur;
    }
}
