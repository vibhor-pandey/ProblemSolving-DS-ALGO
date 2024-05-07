import common.TreeNode;
import java.util.*;


/**
 * 53 / 53 test cases passed.
 * Status: Accepted
 * Runtime: 25 ms
 * Memory Usage: 68.2 MB
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

    class Pair {
        TreeNode node;
        int depth;

        public Pair(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    public int minDepth(TreeNode root) {
        if(root == null) return 0;

        if(root.left == null && root.right == null) {
            return 1;
        }

        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root, 1));
        int ans = Integer.MAX_VALUE;
        while(!stack.isEmpty()) {
            Pair top = stack.pop();
            TreeNode curr = top.node;

            if(curr.left == null && curr.right == null) {
                ans = Math.min(ans, top.depth);
            }

            if(curr.left != null) {
                stack.push(new Pair(curr.left, top.depth + 1));
            }
            if(curr.right != null) {
                stack.push(new Pair(curr.right, top.depth + 1));
            }
        }
        return ans;
    }
}