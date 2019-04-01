package array;

import static java.lang.Integer.MIN_VALUE;

/**
 * 当走到位置i的时候，记录前面i-1的最大值
 *
 */
public class BestSightSeeingPair {
    public int maxScoreSightseeingPair(int[] A){

        int n=A.length,best=MIN_VALUE;
        int most=-MIN_VALUE;
        for(int i=0;i<n;i++){
            best=Math.max(best,A[i]-i+most);
            most=Math.max(most,A[i]+i);
        }
        return best;
    }
}
