package array;

public class SquaresOfASortedArray {
    public int[] sortedSquares(int[] A){
        int length=A.length;
        int left=0,right=length-1;
        int[] b=new int[length];
        for(int i=length-1;i>=0;i--){
            if(Math.abs(A[right])>Math.abs(A[left])){
                b[i]=A[right]*A[right];
                right--;
            }else{
                b[i]=A[left]*A[left];
                left++;
            }
        }
        return b;
    }
}
