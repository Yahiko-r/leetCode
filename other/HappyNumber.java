package other;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public boolean isHappy(int n){
        Set<Integer> set=new HashSet<>();
        set.add(n);
        int now=sum(n);
        while(!set.contains(now)){
            set.add(now);
            now=sum(now);
        }
        if(now==1)return true;
        else return false;

    }

    private int sum(int n) {
        int sum = 0;
        while (n != 0) {
            int i = n % 10;
            sum += i*i;
            n = n / 10;
        }
        return sum;
    }

}
