/**
 * 53 / 53 test cases passed.
 * Status: Accepted
 * Runtime: 4 ms
 * Memory Usage: 63 MB
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
    public int minDepth(TreeNode root) {
        if(root == null) return 0;

        if(root.left == null && root.right == null) {
            return 1;
        }

        int leftDepth = 0;
        if(root.left != null) {
            leftDepth = minDepth(root.left);;
        }
        int rightDepth = 0;
        if(root.right != null) {
            rightDepth = minDepth(root.right);;
        }

        if(leftDepth == 0) return rightDepth + 1;
        else if(rightDepth == 0) return leftDepth + 1;
        else return Math.min(leftDepth, rightDepth) + 1;
    }
}