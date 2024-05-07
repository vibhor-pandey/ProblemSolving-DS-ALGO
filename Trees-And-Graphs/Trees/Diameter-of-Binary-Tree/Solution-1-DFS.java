import common.TreeNode;
import java.util.*;

/**
 * 106 / 106 test cases passed.
 * Status: Accepted
 * Runtime: 0 ms
 * Memory Usage: 44.4 MB
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

    int diameter = 0;

    /**
     * 1) diameter = longestPath(left) + longestPath(right)
     * @param root
     * @return
     */
    public int diameterOfBinaryTree(TreeNode root) {
        if(root.left == null && root.right == null) return 0;
        longPath(root);
        return diameter;
    }

    private int longPath(TreeNode node) {
        if(node == null) return 0;

        if(node.left == null && node.right == null) return 1;

        int left = longPath(node.left);
        int right = longPath(node.right);

        diameter = Math.max(diameter, (left + right));

        return Math.max(left, right) + 1;
    }
}