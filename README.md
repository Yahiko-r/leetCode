# leetCode
## 递归
***
### 95 [Unique Binary Search Trees II](UniquePathsII.java)
能够想到用递归左右产生子树的方法，但是程序就是写不出来，主要在于对于一个root i, 要实现左右子树的所有情况，左右子树是独立的，添加两层循环，把左右子树的各种情况放到list中，之后与root相连，另外程序没有通过，结果中[[]]和[]有什么区别吗
```
        for(int i=s;i<=n;i++){
            List<TreeNode> leftTree=genTree(s,i-1);
            List<TreeNode> rightTree=genTree(i+1,n);
            for(TreeNode leftNode:leftTree){
                for(TreeNode rightNode:rightTree){
                    TreeNode root=new TreeNode(i);
                    root.left=leftNode;
                    root.right=rightNode;
                    rs.add(root);
                }
            }
        }
```
### 120 [Triangle](Triangle.java)
和矩阵的最小路径（64 [Minimum Path Sum](MinimumPathSum.java)）相同，用路径相加求最小值的方式
```angular2html
 int[] result = new int[triangle.size() + 1];
        for (int i = triangle.size() - 1; i >= 0; i--) {
            List<Integer> currRow = triangle.get(i);
            for (int j = 0; j < currRow.size(); j++) {
                result[j] = Math.min(result[j], result[j+1]) + currRow.get(j);
            }
        }
        return result[0];
```
### 32 [Longest Valid Parenthese](LongestValidPatentheses.java)
只能想到用栈，方法也没有答案中的好，dp就是首先找到规律，然后创建一个和要遍历的数据/矩阵相同大小的复制，然后
在遍历的过程中记录下每一步的记录。
```angularjs
int maxans = 0;
        int dp[] = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxans = Math.max(maxans, dp[i]);
            }
        }
        return maxans;
        
        //栈
int maxans = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    //直接记录的就是这一段的长度，不用逐一考虑"(((((...)))"的情况
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
```
### 198 [House RObber](HouseRobber.java)
讨论区分享的：DP的一些套路。
1. recursive

直接按照题意写出递推公式，对当前i，其和之前i-1,i-2的关系。
2. recursive memo(up-down)

从上到下，new一个数组放置从底层到当前i的结果，在遍历的时候就可以直接从数组中找，不用重复计算。

3. iterative+memo(bottom-up)

现在是从初始向后遍历

4. iterative+2variables(bottom-up)

数组在每个循环中只用到了两个数据（有的题目也可能是多个），因此改用双指针，节约空间，但是提交之后用时比第3个时间长
```angularjs
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        int prev1 = 0;
        int prev2 = 0;
        for (int num : nums) {
            int tmp = prev1;
            prev1 = Math.max(prev2 + num, prev1);
            prev2 = tmp;
        }
        return prev1;
    }
```
## backtracking
就是穷举，但是用了递归，不满足判断条件的去掉，剪枝
### 216 [Combination Sum III](CombinationSumIII.java)
一个数组，将其中数字挨个添加到子列中，如果最后判断条件，如果满足，添加到结果中，不满足就去掉。注意这种List对象类要
`List.add(new ArrayList<>(cur));`不谈添加的都是同一个对象，导致List中的每个元素都一样。
```angularjs
void backtracking(){
    if(满足条件){
        添加到结果中；
        return;
    }
    for(每个需要考虑的元素i){
        将i添加到curList中，
        backtracking;进行判断
        移除i,
    }
}

```
### 61 [RotateList](list/RotateRight.java)
简单题，求出长度，k=k%length,尾部指向头部，返回新头部
### 80 [RemoveDuplicatesFrom SortedArray](array/RemoveDuplicates.java)
用一个指针指向数组，如果num[i]>nums[i-2],就将nums[i]写入nums[j]，j是去掉多于两次重复值后数组的位置。
### 79 [Word Search](backtracking/WordSearch.java)
在检测到一个字符的时候，因为每个字符最多用一次，主要是用什么来给已经用过的字符做标记。
### 89 [Gray Code](backtracking/GrayCode.java)
如果知道具体的公式，可以立即求出。不知道公式，看了评论区才知道，可以用回溯的方法，不过在回溯的过程中，上一次回溯的过程是将上一阶倒序并，
不然不能将顺序挨着。