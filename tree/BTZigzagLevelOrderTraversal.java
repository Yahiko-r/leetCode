package tree;

import node.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BTZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> rs = new ArrayList<>();
        int level = 0;
        add(rs, root, level);
        return rs;
    }

    private void add(List<List<Integer>> rs, TreeNode root, int level) {
        if (root == null) return;
        if (rs.size() <= level) {
            List<Integer> list = new ArrayList<>();
            list.add(root.val);
            rs.add(list);
        } else {
            if (level % 2 == 0) {
                rs.get(level).add(0,root.val);
            } else
                rs.get(level).add(root.val);
        }
        add(rs, root.left, level + 1);
        add(rs, root.right, level + 1);
    }
}
