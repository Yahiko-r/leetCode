public class Sqrt {
    public int mySqrt(int x) {

        if (x == 0 || x == 1) return 1;
        int half, low = 0, high = x;
        while (true) {
            half = (low + high) / 2;
            if (half <= x / half && (half + 1) > x / (half + 1)) return half;
            else if (half < x / half) low = half;
            else high = half;
        }


    }
}
