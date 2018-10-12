public class SingleNum {
    public static int singleN(int[] nums){
        int a=0;
        for(int i:nums)
            a^=i;
        return a;
    }

}
