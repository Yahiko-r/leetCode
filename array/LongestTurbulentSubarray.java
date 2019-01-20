package array;

public class LongestTurbulentSubarray {
    public int maxTurbulenceSize(int[] A){
        if(A==null)return 0;
        int length=A.length;
        if(length==1)return 1;

        int max=0;
        int size=2;

        for(int i=2;i<length;i++){
            if((A[i]>A[i-1]&&A[i-1]<A[i-2])||(A[i]<A[i-1]&&A[i-1]>A[i-2])){
                size++;

            }
            else{
                size=2;
            }
            if(size>max)max=size;
        }
        return max;
    }
}
