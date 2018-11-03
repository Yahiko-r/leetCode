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
```