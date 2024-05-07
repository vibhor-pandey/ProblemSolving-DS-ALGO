import common.TreeNode;
import java.util.*;

/**
 * 30 / 30 test cases passed.
 * Status: Accepted
 * Runtime: 0 ms
 * Memory Usage: 41.2 MB
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

    int max = Integer.MIN_VALUE;
    public int maxAncestorDiff(TreeNode root) {
        traverse(root, root.val, root.val);
        return max;
    }

    private void traverse(TreeNode root, int maxSoFar, int minSoFar) {
        if(root == null) return;
        int diff = Math.max(Math.abs(maxSoFar - root.val), Math.abs(minSoFar - root.val));
        max = Math.max(max, diff);
        traverse(root.left, Math.max(maxSoFar, root.val), Math.min(minSoFar, root.val));
        traverse(root.right, Math.max(maxSoFar, root.val), Math.min(minSoFar, root.val));
    }
}