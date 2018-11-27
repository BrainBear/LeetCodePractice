package me.brainbear.explore;

import java.util.LinkedList;
import java.util.List;

public class L144PreorderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        preorder(root, list);
        return list;
    }

    private void preorder(TreeNode node, List<Integer> list) {
        if (null == node) {
            return;
        }

        list.add(node.val);
        if (null != node.left) {
            preorder(node.left, list);
        }

        if (null != node.right) {
            preorder(node.right, list);
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
