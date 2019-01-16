import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums){
        Arrays.sort(nums);
        List<List<Integer>> ans=new ArrayList<>();
        recursion(ans,0,nums,new ArrayList<>());
        return ans;
    }
    public void recursion(List<List<Integer>> ans,int pos,int[] nums,List<Integer> temp){
        if(pos==nums.length){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i=pos;i<nums.length;i++){
            if(i>pos&&nums[i]==nums[pos])continue;
            swap(nums,i,pos);
            temp.add(nums[pos]);
            recursion(ans,pos+1,nums,temp);
            temp.remove(temp.size()-1);
          //  swap(nums,i,pos);
        }
    }
    public void swap(int[] nums,int i,int j){
        int a=nums[i];
        nums[i]=nums[j];
        nums[j]=a;
    }
}
