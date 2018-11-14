public class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        int[] rs = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            int n2 = findnum(numbers, i + 1, numbers.length - 1, target - numbers[i]);
            if (n2 == -1) continue;
            else {
                rs[0] = i + 1;
                rs[1] = n2 + 1;
                return rs;
            }
        }
        return rs;
    }

    public int findnum(int[] numbers, int s, int e, int tar) {
        int left = s, right = e, mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if (tar == numbers[mid]) {
                return mid;
            } else if (tar > numbers[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

}
