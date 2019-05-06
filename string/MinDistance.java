package string;

/**
 * 如果word2在word1中都有并且顺序相同，那么length1-length2
 * 只有部分，剩余顺序相同，length1-length2+replace
 * 顺序不同，
 */
public class MinDistance {
    public int minDistance(String word1,String word2) {
        int[][] times = new int[word1.length()+1][word2.length()+1];

        for (int i = 0; i <= word1.length(); i++) {
            times[i][0] = i;
        }
        for (int i = 0; i <=word2.length(); i++) {
            times[0][i] = i;
        }
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    times[i][j] = times[i - 1][j - 1];
                } else {
                    int a = times[i][j - 1];
                    int b = times[i - 1][j];
                    int c = times[i - 1][j - 1];
                    a = Math.min(a, b);
                    a = Math.min(a, c);
                    times[i][j] = 1 + a;
                }
            }
        }
        return times[word1.length()][word2.length()];
    }

}
