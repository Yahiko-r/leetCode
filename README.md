# leetCode
## 递归
***
### 95 [Unique Binary Search Trees II](UniquePathsII.java)
能够想到用递归左右产生子树的方法，但是程序就是写不出来，主要在于对于一个root i, 要实现左右子树的所有情况，左右子树是独立的，
添加两层循环，把左右子树的各种情况放到list中，之后与root相连，
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
### 337 [House Robber III](tree/HouseRobberIII.java)
数组的偷是用dp的思想。
对于树来说，是按层来分配，1.偷了当前层，下一层不能偷。2.不偷当前层，递归算下一层（左右两个子树）。

数组是用两个变量pre1,pre2来记录前两个状态。这里是用一个数组（容量为2）,记录1.偷当前层，2.不偷当前层
  讨论区赞数最高的评论很好。第三种方法是对第二种方法的空间优化，因为只需要记录两个结果即可，而
  第二种方法记录了每个节点的结果
## backtracking
就是穷举，但是用了递归，不满足判断条件的去掉，剪枝
### 216 [Combination Sum III](CombinationSumIII.java)
一个数组，将其中数字挨个添加到子列中，如果最后判断条件，如果满足，添加到结果中，不满足就去掉。注意这种List对象类要
`List.add(new ArrayList<>(cur));`不谈添加的都是同一个对象，导致List中的每个元素都一样。
```java
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
### 102 [Binary Tree Level Order Traversal](tree/BTLevelOrderTraversal.java)
把树的每一层深度的值放到list中，遍历一下，如果把list的大小和深度进行比较，如果小于等于，说明是第一次遍历到，新建一个层list,加到结果中
如果大于，说明之前已经走到过该层深度了，直接在list.get(deep).add(val)就行了。
### 103 [Binary Tree Zigzag Level Order Traversal](tree/BTZigzagLevelOrderTraversal.java)
和上一题一样，只不过，如果深度是奇数，再添加到list中时，从list的首位开始添加就行了。
### 99 [Recover Binary Search Tree](tree/RecoverBinarySearchTree.java)
首先是树的遍历，前中后序的遍历的原理弄清除，主要是遍历的过程中变量的变化。
### 98 [ValidateBinarySearchTree](tree/ValidateBinarySearchTree.java)
判断二叉查找树。
### 970 [Powerful Integers](array/PowerfulIntegers.java)
找出所有的就行了，不过要注意特例1
### 969 [Pancake Sorting](array/PancakeSorting.java)
不求最快的翻转方式，从最大的慢慢向前反转，找到最大的，换到第一个数字的位置上，在换到最后面，
### 971 [Flip Binary Tree To Match Preorder Traversal](tree/FlipBTMatchPreorderTraversal.java)
前序遍历和给的序列想比较，如果不能就不能，如果能和右子树交换的就换，不能交换就返回false.
### 60 [Permutation Sequence](PermutationSequence.java)
字典序，n个数字，求第k个，第一个数字是(k-1)/(n-1)!,k-1是为了在分清临界出，1，2，3/3  应该都是一样的，然后在数字序列中去掉第一个，
第二个数字，是前一个的余数/(n-2)!，然后在剩余的序列中找出这个数字，数字序列可以用list，也可以用一个数组来表示数字有没有被用到。
### 978 [Longest Turbulent Subarry](array/LongestTurbulentSubarray.java)
动态规划，安装顺序遍历一遍就行了。
### 979 [Distribute Coins in Binary Tree](tree/DistributeConsInBT.java)
左子树需要多少步，右子树需要多少步，然后和节点的值相比较，是改节点需要多少个coin，正表示向外传递，负表示向内传递。
需要注意的是关于树的题目基本上都是那三个遍历方式，此外加上，深度、广度优先。
### 150 [Evaluate Reverse Polish Notation](other/EvaluateReversePolishNotation.java)
用栈实现就行了，注意出栈操作数得顺序和'-'， '*' 的顺序别弄反了，其余注意细节。
### 104 [Maximum Depth of Binary Tree](tree/MaximumDepthOfBinaryTree.java)
对树进行遍历即可。
### 105 [Construct BT From PreOrder And Inorder](tree/ConstructBTFromPreOrderAndInorder.java)
在前序中是父结点，在中序中找到对应的节点，左边的就是左子树，右边的就是右子树
### 108 [Convert Sorted Array to Binary Search Tree](tree/ConvertSortedArrayToBinarySearchTree.java)
把中点当成根，然后左右继续安装这种方法即可。
### 113 [Path Sum II](tree/PathSumII.java)
遍历一下，找一下就行了
### 119 [Pascal's Triangle II](other/PascalTriangle.java)
看讨论区的答案，用一个list就行了，每增加一行就在list上增加一个1，同时把中间的几个数字更新。
### 50 [Pow(x,n)](other/PowXY.java)
容易想到将幂换成多个2的倍数的和的形式，然后采用位运算，唯一需要注意的是INT_MIN=-INT_MIN;
### 41 [FirstMissingPositive](array/FirstMissingPositive.java)
大佬的提示：数组本身就可以做标记，然后就是不用管错误的数字放在什么位置，只要正确的数字能够放到位置上就行了。
### 37 [Sudoku Solver](backtracking/SudokuSolver.java)
回溯，怎么把每一行缺失的数字找出来才能不用每次都从0来一遍？讨论区也都是从0检测一遍，还有就是for(char c;xx;xx),在for
循环中，也可以用char
### 91 [Decode Ways](dp/DecodeWays.java)
dp问题，斐波那契数列，但是要考虑中间有0的情况，然后判断两个相邻的数是否大于26，讨论区用的是
Integer.parseInt(s.substring(i,i+2))<=26，每次做题我都想不出用Integer里的函数，了解的还不够多。
### 116 [Populating Next Right Pointers in Each Node](tree/PopulatingNextRightPointer.java)
树的层序遍历，需要知道每一层的编号。评论区更好的方法，直接按照左子树来向下遍历，对于每一层，使用next节点向右边遍历
类似与一个链表，每个链表的节点又是一个链表。当前行处理的是下一层的next指向。
### 117 [Populating Next Right Pointers in Each Node ](tree/PopulatingNextRightPointerII.java)
与上一题答题想法类似，自己的写法每次都没有评论区简洁。每次要构思好思路再开始写。
### 155 [Min Stack](other/MinStack.java)
怎么让最小值随着pop()动态变化，维护一个数组的话，不能动态增加或者减少。解答区用的是将值压入栈中。
### 151 [Reverse Words in a String](string/ReverseWordsInaString.java)
注意String 中null和""的区别
### 148[Sort List](list/SortList.java)
归并。
### 287[Find the Duplicate Number](array/FindDuplicateNumber.java)
满足题意的数组可以当成链表来看待。
### 494 [Target Sum](dp/FindTargetSumWays.java)
从数组中通过+或者-来使结果等于target。
第一思路：暴力求解，通过递归把所有的可能都找出来，结果和target相比较就行了。
DP方法：递归遍历的时候，指数个结果，在某层i上，可能会有多个值都相等。因此，通过数组记录下所有可能的结果值，如果有多个值
只需要在dp数组中次数相加就行了，在往下遍历的时候，就会只计算一次。
### 73 [Set Matrix Zeroes](matrix/SetMatrixZeros.java)
用第一行来存储为0的列，第一列来存储为0的行，只不过第一列和第一行是否为0 要新建变量来存储。
### 406 [Queue Reconstruction by Height](other/QueueReconstruction.java)
从大到小排序，然后按照顺序进行一个个按照k，放到合适的位置上。
### 279 [Perfect Squares](dp/PerfectSquares.java)
dp，把从1到n的所有值都算出来。
dp[i]=min{dp[i-j*j]}  j*j<=i,
### 347 [Top K Frequent Elements](array/TopKFrequentElements.java)
先统计每个数的频率放到hashmap中，O(n);之后求频率的top k问题，堆排序。
> hashmap： map.getOrDefault(n,1)
> 优先队列，每次poll,add都会排序一次，别忘记加循环。
### 322 [Coin Change](dp/CoinChange.java)
标准动态规划问题，`dp[i]=min{i-coins[j]}  j<coins.length;`
### 394 [Decode String](string/DecodeString.java)
用一个栈存储[]中的数据，另一个栈存储[]前面的数字，遇到']'就构造字符串加到前面的字符串上。
### 309 [Best Time Buy Sell Stock CoolDown](array/BestBuySellStockCooldown.java)

在第i天总共有两种状态，手里有股票，没股票。buy[i]表示有，sell[i]表示没有。
cooldown只是在状态方程中变了一下。
不会做就记住这种类型：dp中的两个状态。
### 238 [Product of Array Except Self](array/ProductAttayExceptSelf.java)
用两个数组分别记录i左边和右边的乘积。最后遍历I,左右相乘，简化空间：其中一个数组用一个变量来代替即可，在最后遍历的过程中
一直乘nums[i]