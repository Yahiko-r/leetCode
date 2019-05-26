package array;

import java.util.Arrays;

public class HeightChecker {
    public int heightChecker(int[] heights){
        int[] copy=Arrays.copyOf(heights,heights.length);
        Arrays.sort(copy);
        int sum=0;
        for(int i=copy.length-1;i>=0;i--){
            if(copy[i]!=heights[i]){
                sum++;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        HeightChecker h=new HeightChecker();
        int[] a={1,1,4,2,1,3};
        int i = h.heightChecker(a);
        System.out.println(i);
    }
}
