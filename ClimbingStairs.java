public class ClimbingStairs {
    public int climbStairs(int n) {
        if(n==1)return 1;
        int last=1;
        int nextToLast=2;
        int answer=2;
        for(int i=3;i<=n;i++){
            answer=last+nextToLast;
            nextToLast=last;
            last=answer;
        }
        return answer;
    }

}
