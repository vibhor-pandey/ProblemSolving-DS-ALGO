/**
 * 41 / 41 test cases passed.
 * Status: Accepted
 * Runtime: 0 ms
 * Memory Usage: 50.8 MB
 *
 * Time Complexity: O(lg n) - Binary Search
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
        traverse(root, low, high);
        return sum;
    }

    private void traverse(TreeNode node, int low, int high) {
        if(node == null) return;

        if(node.val >= low && node.val <= high) {
            sum += node.val;
        }

        if(low < node.val) {
            traverse(node.left, low, high);
        }
        if(high > node.val) {
            traverse(node.right, low, high);
        }
    }
}