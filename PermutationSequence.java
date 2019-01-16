import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {
    private String getPermutation(int n,int k) {
        List<Integer> nums=new ArrayList<>();
        int fac=1;
        for(int i=1;i<=n;i++){
            fac*=i;
            nums.add(i);
        }
        k--;
        StringBuilder sb= new StringBuilder();
        for(int i=n;i>=1;i--){
            fac/=i;
            int idx=k/fac;
            k%=fac;
            sb.append(nums.get(idx));
            nums.remove(idx);
        }
        return sb.toString();
    }
    public static String Permutation(int n, int k) {
        int fac= 1;
        for (int i=1; i<=n; i++) fac*=i;
        k--;
        StringBuilder sb= new StringBuilder();
        boolean[] vis= new boolean[n+1];
        for (int i=n; i>0; i--){
            fac/=i;
            int idx=k/fac;
            k%=fac;
            int j=1;
            while (vis[j] || idx-->0) j++;
            vis[j]=true;
            sb.append(j);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s=PermutationSequence.Permutation(3,3);
        System.out.println(s);
    }
}
