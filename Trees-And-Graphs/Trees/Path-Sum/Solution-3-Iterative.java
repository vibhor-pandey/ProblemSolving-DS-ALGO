import common.TreeNode;

/**
 * 117 / 117 test cases passed.
 * Status: Accepted
 * Runtime: 2 ms
 * Memory Usage: 43 MB
 *
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
        int sum;

        Pair(TreeNode node, int sum) {
            this.node = node;
            this.sum = sum;
        }
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) {
            return false;
        }

        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root, 0));

        while(!stack.isEmpty()) {
            Pair top = stack.pop();
            TreeNode current = top.node;
            int sum = top.sum + current.val;

            if(current.left == null && current.right == null) {
                if(sum == targetSum) return true;
            }

            if(current.left != null) stack.push(new Pair(current.left, sum));
            if(current.right != null) stack.push(new Pair(current.right, sum));
        }
        return false;
    }
}