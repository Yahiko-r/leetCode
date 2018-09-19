import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//记住回溯的形式，
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates,int target){
        Arrays.sort(candidates);
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        backtrace(result,list,candidates,target,0);
        return result;
    }
    public void backtrace(List<List<Integer>> result,List<Integer> list,int[] nums,int target,int deep){
        if(target<0)return;
        else if(target==0)
            result.add(new ArrayList<>(list));
        else{
            for(int i=deep;i<nums.length;i++){
                list.add(nums[i]);
                backtrace(result,list,nums,target-nums[i],i);
                list.remove(list.size()-1);//移除最后一个
            }
        }

    }
}
