package array;

public class DailyTemperatures {
    /**
     * 每一个和后面的相比较，只需要比较比较大的，小的忽视掉。k+days【k]，只查找数字比较大的。
     * @param T
     * @return
     */
    public int[] dailyTemperatures(int[] T){
        if (T == null || T.length == 0) {
            return T;
        }
        int[] days = new int[T.length];
        days[T.length - 1] = 0;
        for (int i = T.length - 2; i >= 0; i--) {
            if (T[i] < T[i + 1]) {
                days[i] = 1;
            } else {
                for (int k = i + 1; ; k = k + days[k]) {
                    if (T[k] > T[i]) {
                        days[i] = k - i;
                        break;
                    }
                    if (days[k] == 0) {
                        days[i] = 0;
                        break;
                    }
                }
            }
        }
        return days;
    }
}
