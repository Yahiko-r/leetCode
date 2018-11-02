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