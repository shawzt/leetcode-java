package space.modx.coding;

/*
二叉树的层次遍历
给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。

例如:
给定二叉树: [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回其层次遍历结果：

[
  [3],
  [9,20],
  [15,7]
]
*/

import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Question0102 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    List<List<Integer>> levels = new ArrayList<>();

    public List<List<Integer>> levelOrder_1(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {
            result.add(new ArrayList<>());
            int queueLen = queue.size();
            for (int i = 0; i < queueLen ; i++) {
                TreeNode node = queue.poll();

                result.get(level).add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            level++;
        }

        return result;
    }

    public List<List<Integer>> levelOrder_2(TreeNode root) {
        if (root == null) {
            return levels;
        }
        helper(root, 0);

        return levels;
    }

    void helper(TreeNode node, int level) {
        if (levels.size() == level) {
            levels.add(new ArrayList<>());
        }

        levels.get(level).add(node.val);

        if (node.left != null) {
            helper(node.left, level+1);
        }
        if (node.right != null) {
            helper(node.right, level+1);
        }
    }
}
