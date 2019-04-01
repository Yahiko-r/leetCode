package array;

import java.util.ArrayList;
import java.util.List;

/**
 * 利用数组下标，将重复的值变成0，最后再遍历一遍
 */
public class FindAllNumbersDisappeared {
    public List<Integer> findDisappearedNumbers(int[] nums){
        List<Integer> rs=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0)continue;
            if(nums[i]!=i+1){
                if(nums[nums[i]-1]==nums[i]){
                    nums[i]=0;
                }else{
                    swap(nums,i,nums[i]-1);
                    i--;
                }
            }
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=i+1){
                rs.add(i+1);
            }
        }
        return rs;
    }
    private void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }


}
