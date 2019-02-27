package tree;

import node.TreeNode;

public class SumRootLeafNumbers {
    public int sumNumbers(TreeNode root) {
        return travel(root, 0);
    }

    private int travel(TreeNode node, int now) {
        if (node != null) {
            now *= 10;
            now += node.val;
            if(node.left==null&&node.right==null){
                return now;
            }
            return travel(node.left, now) +
                    travel(node.right, now);
        }
        return 0;
    }


}
