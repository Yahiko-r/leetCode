package tree;

import node.TreeNode;

import java.util.*;

public class BTRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        order(root, 0, map);
        List<Integer> list = new ArrayList<>(map.size());
        for (int i = 0; i < map.size(); i++) {
            list.add(map.get(i));
        }
        return list;


    }

    private void order(TreeNode node, int depth, Map<Integer, Integer> map) {
        if (node != null) {
            if (!map.containsKey(depth)) {
                map.put(depth, node.val);
            }
            order(node.right, depth + 1, map);
            order(node.left, depth + 1, map);
        }
    }
}
