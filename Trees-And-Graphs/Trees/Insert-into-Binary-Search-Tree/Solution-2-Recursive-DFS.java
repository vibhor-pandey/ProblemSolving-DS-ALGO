import common.TreeNode;

/**
 * 35 / 35 test cases passed.
 * Status: Accepted
 * Runtime: 0 ms
 * Memory Usage: 44.9 MB
 *
 * Time Complexity: O(lg n)
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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) return new TreeNode(val, null, null);

        if(root.left == null && root.val > val) {
            TreeNode node = new TreeNode(val, null, null);
            root.left = node;
        } else if(root.right == null && root.val < val) {
            TreeNode node = new TreeNode(val, null, null);
            root.right = node;
        }

        if(val > root.val) {
            insertIntoBST(root.right, val);
        } else {
            insertIntoBST(root.left, val);
        }
        return root;
    }
}