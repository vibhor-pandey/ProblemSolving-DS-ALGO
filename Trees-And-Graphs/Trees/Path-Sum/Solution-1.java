import common.TreeNode;

/**
 * 117 / 117 test cases passed.
 * Status: Accepted
 * Runtime: 0 ms
 * Memory Usage: 43.2 MB
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */



/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    int target = 0;

    public boolean hasPathSum(TreeNode root, int targetSum) {
        target = targetSum;
        return traverse(root, 0);
    }

    private boolean traverse(TreeNode node, int current) {
        if(node == null) {
            return false;
        }

        current += node.val;

        if(node.left == null && node.right == null) {
            return current == target;
        }

        boolean left = traverse(node.left, current);
        boolean right = traverse(node.right, current);

        return left || right;
    }
}