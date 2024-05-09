import common.TreeNode;

/**
 * 35 / 35 test cases passed.
 * Status: Accepted
 * Runtime: 0 ms
 * Memory Usage: 54.4 MB
 *
 * Time Complexity: O(lg n)
 * Time Complexity: O(n)
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
        TreeNode curr = root;
        if(curr == null) return new TreeNode(val);
        while(curr != null) {
            if(val > curr.val) {
                if(curr.right == null) {
                    curr.right = new TreeNode(val);
                    break;
                }
                curr = curr.right;
            } else {
                if(curr.left == null) {
                    curr.left = new TreeNode(val);
                    break;
                }
                curr = curr.left;
            }
        }
        return root;
    }
}