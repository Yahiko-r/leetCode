package array;

import java.util.Arrays;

/**
 * 找出需要的空格数，然后减去能够填充的
 */
public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        int[] letters = new int[26];
        int lei = 0;
        for (int i = 0; i < tasks.length; i++) {
            int idx = tasks[i] - 'A';
            if (letters[idx] == 0) {
                lei++;
            }
            letters[idx]++;
        }
        Arrays.sort(letters);

        int base = letters[25] - 1;
        int numOfIdle = base*n;

        for (int i = 2; i <=lei; i++) {
            numOfIdle-=Math.min(letters[25-i+1],base);

        }
        if(numOfIdle>0){
            return numOfIdle+tasks.length;
        }else{
            return tasks.length;
        }


    }
}
