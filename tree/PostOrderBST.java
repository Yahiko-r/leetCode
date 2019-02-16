package tree;

public class PostOrderBST {
    public boolean existBST(int[] a) {
        int length=a.length;
        return exist(a,0,length-1);
    }

    private boolean exist(int[] a, int start, int end) {
        if (start == end || start + 1 == end) return true;
        int headValue = a[end];
        int right = end;
        for (int i = 0; i < end; i++) {
            if (a[i] > headValue) {
                right = i;
                break;
            }
        }
        for (int j = right; j < end; j++) {
            if (a[j] < headValue) return false;
        }
        if(right==start||right==end){
            return exist(a,start,end-1);
        }
        return exist(a,start,right-1)&&exist(a,right,end-1);

    }
}
