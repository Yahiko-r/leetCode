package array;

/**
 * 先找出最后一个不满足升序的，再从最后面找出比a[i]小的数字,如果数字相等，找最靠前的，交换即可
 */
public class PreviousPerMutationOneSwap {
    public int[] prevPermOpt1(int[] A){

        int pre=-1;
        //找出pre之后最大的数
        for(int i=1;i<A.length;i++){
            if(A[i]>=A[i-1]){
                continue;
            }else{
                pre=i-1;
            }
        }
        if(pre==-1)return A;
        int right=0;
        for(int j=A.length-1;j>pre;j--){
            if(A[j]<A[pre]){
                right=j;
                while(A[right]==A[right-1]){
                    right--;
                }
                break;
            }
        }
        int temp=A[right];
        A[right]=A[pre];
        A[pre]=temp;
        return A;
    }

    public static void main(String[] args) {
        int[] a={3,1,1,3};
        PreviousPerMutationOneSwap p=new PreviousPerMutationOneSwap();
        int[] ints = p.prevPermOpt1(a);
        for(int i=0;i<ints.length;i++){
            System.out.println(ints[i]);
        }

    }
}
