import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Main m = new Main();
        // m.strStrTest();
        // m.searchInsertTest();
        //m.countAndSayTest();
        // m.testLongestPalindrome();
        //m.testThreeSum();
        //m.testThreeSumClosest();
        //m.testLetterCombinations();
        //System.out.println(m.generateParenthesis(3));
//        int[] nums={-2,1,-3,4,-1,2,1,-5,4};
//        System.out.println(m.maxSubArray(nums));

        String s="hello world";
        int sr=m.lengthOfLastWord(s);
        System.out.println(sr);
    }
    public int lengthOfLastWord(String s){
        int i=s.lastIndexOf(' ');
        int l=s.length();
        return l-i-1;
    }



    public int maxSubArray(int[] nums){
        int nowMax=nums[0];
        int max=nums[0];
        for(int i=1;i<nums.length;i++){
            nowMax=(nowMax>0)?(nowMax+nums[i]):nums[i];
            max=Math.max(nowMax,max);
        }
        return max;
    }

    public List<String> generateParenthesis(int n){
        List<String> ans=new ArrayList<>();
        backtrack(ans,"",0,0,n);
        return ans;
    }
    public void backtrack(List<String> ans,String cur,int open,int close,int max){
        if(cur.length()==max*2){
            ans.add(cur);
            return;
        }
        if(open<max)
            backtrack(ans,cur+"(",open+1,close,max);
        if(close<open)
            backtrack(ans,cur+")",open,close+1,max);
    }
    public String intToRoman(int num){


        return null;
    }
    public void testLetterCombinations(){
        List<String> l=letterCombinations("23");

    }
    public List<String> letterCombinations(String digits){
        LinkedList<String> ans = new LinkedList<String>();
        if(digits.isEmpty()) return ans;
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        for(int i =0; i<digits.length();i++){
            int x = Character.getNumericValue(digits.charAt(i));
            while(ans.peek().length()==i){
                String t = ans.remove();
                for(char s : mapping[x].toCharArray())
                    ans.add(t+s);
            }
        }
        return ans;




    }

    public void testThreeSumClosest() {
        int[] nums = {-1, 2, 1, -4};
        int i = threeSumClosest(nums, 1);
        System.out.println(i);
    }

    public int threeSumClosest(int[] nums, int target) {


        Arrays.sort(nums);
        int i = 0;
        int min = Integer.MAX_VALUE;
        int rs=0;
        while (i < nums.length - 2) {

            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (target - sum == 0) {
                    return target;
                }
                if(target-sum>0) {
                    if (target - sum <= min) {
                        min = target - sum;
                        rs=sum;
                    }
                    while (j < k && nums[j] == nums[j + 1]) {
                        j++;
                    }
                    j++;
                }

                if (target - sum < 0) {
                    if (sum - target <= min) {
                        min = sum - target;
                        rs=sum;
                    }
                    while (j < k && nums[k] == nums[k - 1]) {
                        k--;
                    }
                    k--;
                }

            }
            while (i + 1 < nums.length - 2 && nums[i] == nums[i + 1]) {
                i++;
            }
            i++;
        }


        return rs;
    }

    public void testThreeSum() {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> res = threeSum(nums);
        System.out.println(res);

    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length <= 2)
            return res;
        Arrays.sort(nums);
        int i = 0;
        while (i < nums.length - 2) {
            if (nums[i] > 0) break;
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    List<Integer> array = new ArrayList<>();
                    array.add(nums[i]);
                    array.add(nums[j]);
                    array.add(nums[k]);
                    res.add(array);
                }
                if (sum <= 0) {
                    while (nums[j] == nums[j + 1] && j < k) {
                        j++;
                    }
                    j++;
                }
                if (sum >= 0) {
                    while (nums[k] == nums[k - 1] && k > j) {
                        k--;
                    }
                    k--;
                }
            }
            while (i + 1 < nums.length - 2 && nums[i] == nums[i + 1]) {
                i++;
            }
            i++;
        }
        return res;
    }

    public int myAtoi(String str) {
        int sign = 1, num = 0, i = 0;
        while (i < str.length() && str.charAt(i) == ' ') i++;
        if (i >= str.length()) return 0;
        if (str.charAt(i) == '-' || str.charAt(i) == '+') {
            if (str.charAt(i) == '-')
                sign = -1;
            i++;
        }
        while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            if (num > Integer.MAX_VALUE / 10 || (num == Integer.MAX_VALUE / 10 && str.charAt(i) - '0' > 7)) {
                if (sign == -1) return Integer.MIN_VALUE;
                else
                    return Integer.MAX_VALUE;
            }

            num = 10 * num + (str.charAt(i) - '0');
            i++;
        }
        return num * sign;
    }


    /*
    longestPalindrome
     */
    public void testLongestPalindrome() {
        String s = "abadd";
        String rs = longestPalindrome(s);
        String r = TruePalindrome(s);
        System.out.println(rs);
        System.out.println(r);
    }

    public String TruePalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expand(s, i, i);
            int len2 = expand(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expand(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    //不能识别abba，只能aba类型的
    public String longestPalindrome(String s) {
        char[] cs = s.toCharArray();
        int l = s.length();
        int j = 1, max = 1, iMax = 0;
        for (int i = 1; i < l - 1; i++) {
            j = 1;
            while (i - j >= 0 && i + j <= l - 1) {
                if (cs[i - j] == cs[i + j]) {
                    j++;
                } else {
                    if (j > max) {
                        max = j;
                        iMax = i;
                    }


                    break;
                }
            }
            if (j > max) {
                max = j;
                iMax = i;
            }

        }
        return s.substring(iMax - max + 1, iMax + max);
    }

    /*
    median of two sorted arrays
     */
    public double findMedian(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        if (l1 < l2 && nums1[l1 - 1] <= nums2[0]) {
            if ((l1 + l2) / 2 == 0) return (nums2[(l1 + l2) / 2] + nums2[(l1 + l2) / 2 + 1]) / 2.0;
            else return nums2[(l1 + l2) / 2 + 1];
        }
        if (l2 < l1 && nums2[l2 - 1] <= nums1[0]) {
            if ((l1 + l2) / 2 == 0) return (nums1[(l1 + l2) / 2] + nums1[(l1 + l2) / 2 + 1]) / 2.0;
            else return nums1[(l1 + l2) / 2 + 1];
        }
        if (l1 > l2) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
            int l_temp = l1;
            l1 = l2;
            l2 = l_temp;
        }
        int min = 0, max = l1, half = (l1 + l2 + 1) / 2;
        while (min <= max) {
            int i = (min + max) / 2;
            int j = half - i;
            if (i < max && nums2[j - 1] > nums1[i]) {
                min = min + 1;
            } else if (i > min && nums1[i - 1] > nums2[j]) {
                max = max - 1;
            } else {

            }
        }
        return 0;
    }

    /*
    countAndSay
     */
    public void countAndSayTest() {
        String s = countAndSay(5);
        System.out.println(s);
    }

    public String countAndSay(int n) {

        StringBuffer temp = new StringBuffer("1");
        StringBuffer next;
        int i;
        int flag = 1;
        for (i = 2; i <= n; i++) {


            int l = temp.length();

            next = new StringBuffer("");
            for (int j = 0; j < l; j++) {

                if (j < l - 1 && temp.charAt(j) == temp.charAt(j + 1)) {
                    flag++;
                } else {
                    next.append("" + flag);
                    next.append("" + temp.charAt(j));
                    flag = 1;
                }
            }
            temp = next;

        }
        return temp.toString();

    }

    /*
    数在数列中的位置
     */
    public void searchInsertTest() {
        int[] nums = {1, 2, 3, 4};

        int i = searchInsert(nums, 7);
        System.out.println(i);
    }

    public int searchInsert(int[] nums, int target) {
        int i;
        for (i = 0; i < nums.length; i++) {
            if (target <= nums[i]) {
                return i;
            }


        }
        return i;
    }

    /*
    子字符串的位置
     */
    public void strStrTest() {
        int i = strStr("a", "a");
        System.out.println(i);
    }

    public int strStr(String haystack, String needle) {
        int l1 = haystack.length();
        int l2 = needle.length();
        if (l2 == 0) return 0;
        if (l2 > l1) return -1;
        int j = 0;
        int i = 0;
        int p = 0;
        while (i < l1) {
            if (haystack.charAt(i) == needle.charAt(j)) {

                for (p = 0; p < l2; p++) {
                    if ((i + p) == l1) return -1;
                    if (haystack.charAt(i + p) != needle.charAt(j + p)) {
                        p = 0;
                        j = 0;
                        i++;
                        break;
                    }


                }
                if (p == l2)
                    return i;


            } else {
                j = 0;
                i++;
            }

        }
        return -1;
    }
}
