package me.brainbear.explore;

import java.util.LinkedList;
import java.util.List;

public class L94InorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        preorder(root, list);
        return list;
    }

    private void preorder(TreeNode node, List<Integer> list) {
        if (null == node) {
            return;
        }

        if (null != node.left) {
            preorder(node.left, list);
        }

        list.add(node.val);


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
