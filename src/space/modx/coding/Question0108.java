package space.modx.coding;

/*
将有序数组转换为二叉搜索树
将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。

本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。

示例:

给定有序数组: [-10,-3,0,5,9],

一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：

      0
     / \
   -3   9
   /   /
 -10  5
*/

/**
 * 二叉搜索树的中序遍历结果为递增序列，那么构造一棵二叉搜索树，就是要我们实现这一特性的逆过程。
 * 中序遍历的顺序为：左节点 → 根节点 → 右节点
 *
 * 构造树的每个节点以及该节点的左右子树。因此，递归函数要素如下：
 * 1. 选取要构造关系的节点并创建它
 * 2. 构造该节点的左子树
 * 3. 构造该节点的右子树
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Question0108 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return helper(nums, 0, nums.length - 1);
    }

    TreeNode helper(int[]nums, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (end - start + 1)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = helper(nums, start, mid - 1);
        node.right = helper(nums, mid + 1, end);
        return node;
    }
}
