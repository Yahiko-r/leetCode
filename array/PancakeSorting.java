package array;

import java.util.ArrayList;
import java.util.List;

public class PancakeSorting {
    public static  List<Integer> pancakeSort(int[] A){
        int length=A.length;
        int target=length;
        List<Integer> rs=new ArrayList<>();
        while(target>1) {
            for (int i = 0; i < target; i++) {
                if (A[i] == target) {
                    rs.add(i + 1);
                    rs.add(target);
                    flip(A,i+1);
                    flip(A,target);
                    target--;
                    break;
                }
            }
        }
        return rs;
    }
    private static void flip(int[] a,int k){
        int length=a.length;
        for(int i=0,j=k-1;i<j;i++,j--){
            int temp=a[i];
            a[i]=a[j];
            a[j]=temp;
        }
    }

    public static void main(String[] args) {
        //PancakeSorting p=new PancakeSorting();
        int[] a=new int[]{3,2,4,1};
        List<Integer> rs=PancakeSorting.pancakeSort(a);
        for(int i=0;i<rs.size();i++){
            System.out.println(rs.get(i));
        }
    }
}
