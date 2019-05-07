package array;

import java.util.HashSet;
import java.util.Set;

/**
 *
 */
public class LongestConsecutiveSequence {
    //bianli
    public int longestConsecutive(int[] nums){

        Set<Integer> numSet=new HashSet<>();
        for(int num:nums){
            numSet.add(num);
        }
        int longest=0;
        for(int num:numSet){
            if(!numSet.contains(num-1)){
                int curNum=num;
                int lg=1;
                while(numSet.contains(curNum+1)){
                    curNum++;
                    lg++;
                }
                longest=Math.max(lg,longest);
            }
        }




        return longest;
    }

}
