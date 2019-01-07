package array;

import java.util.ArrayList;
import java.util.List;

public class PowerfulIntegers {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        List<Integer> rs = new ArrayList<>();
        int big = 0;
        int sma = 0;
        if (x >= y) {
            big = x;
            sma = y;
        } else {
            big = y;
            sma = x;
        }
        int i = 0, j = 0, num = 0;

        for (; ; j++) {
            int temp = (int) Math.pow(big, j);
            if (temp + 1 > bound) break;

            for (i = 0; ; i++) {
                num = temp + (int) Math.pow(sma, i);
                if (num <= bound) {
                    if (!rs.contains(num))
                        rs.add(num);
                }
                if(sma==1||num>bound)break;
            }
            if(big==1)break;
        }
        return rs;
    }

    public static void main(String[] args) {
        PowerfulIntegers p = new PowerfulIntegers();
        List<Integer> rs = p.powerfulIntegers(1, 2, 100);
        for (int i = 0; i < rs.size(); i++) {
            System.out.println(rs.get(i));
        }
    }
}
