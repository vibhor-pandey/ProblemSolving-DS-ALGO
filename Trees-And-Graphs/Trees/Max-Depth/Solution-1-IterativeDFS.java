import common.TreeNode;
import java.util.*;

/**
 * 39 / 39 test cases passed.
 * Status: Accepted
 * Runtime: 0 ms
 * Memory Usage: 41.9 MB
 *
 * Time Complexity: O(n) -> number of nodes
 * Space Complexity: O(n) -> Stack
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

        Pair(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    public int maxDepth(TreeNode root) {

        if(root == null) return 0;

        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root, 1));
        int ans = -1;

        while(!stack.isEmpty()) {
            Pair top = stack.pop();
            TreeNode curr = top.node;

            ans = Math.max(ans, top.depth);
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