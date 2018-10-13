import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Permutations {
    public  static List<List<Integer>> permute(int[] nums){
        int l=nums.length;
        List<List<Integer>> r=new ArrayList<>();
        ArrayList<Integer> list=new ArrayList<>(nums.length);
        for(int f=0;f<nums.length;f++){
            list.add(nums[f]);
        }
        r.add(list);
        for(int i=0;i<l-1;i++){
            int[] copynums=new int[nums.length];
            System.arraycopy(nums,0,copynums,0,nums.length);
            swapOthers(copynums,i,r);
        }
        return r;
    }
    public static void swapOthers(int[] nums,int i,List r){

        for(int j=i+1;j<nums.length;j++){
            int[] copynums=new int[nums.length];
            System.arraycopy(nums,0,copynums,0,nums.length);
            swap(copynums,i,j);
            ArrayList<Integer> list=new ArrayList<>(nums.length);
            for(int f=0;f<nums.length;f++){
                list.add(copynums[f]);
            }
            r.add(list);
            swapOthers(copynums,i+1,r);
        }
    }
    public static void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

    public static void main(String[] args) {
        int[] nums={1,2,3};
        List<List<Integer>> r=permute(nums);
        for(int i=0;i<r.size();i++){
            for(int j=0;j<r.get(i).size();j++){
                System.out.print(r.get(i).get(j));
            }
            System.out.println(" ");
        }
    }
}
