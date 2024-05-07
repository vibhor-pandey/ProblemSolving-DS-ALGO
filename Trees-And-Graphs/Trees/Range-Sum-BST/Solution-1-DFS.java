import common.TreeNode;

/**
 * 41 / 41 test cases passed.
 * Status: Accepted
 * Runtime: 1 ms
 * Memory Usage: 50.9 MB
 *
 * Time Complexity: O(n) {All Nodes will be traversed}
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
    int sum = 0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null) return 0;

        if(root.val >= low && root.val <= high) {
            sum += root.val;
        }
        int left = rangeSumBST(root.left, low, high);
        int right = rangeSumBST(root.right, low, high);

        return sum;
    }
}