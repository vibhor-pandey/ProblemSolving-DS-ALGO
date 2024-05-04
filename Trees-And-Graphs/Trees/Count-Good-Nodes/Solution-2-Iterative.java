/**
 * 63 / 63 test cases passed.
 * Status: Accepted
 * Runtime: 17 ms
 * Memory Usage: 52.6 MB
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
        int max;

        Pair(TreeNode node, int max) {
            this.node = node;
            this.max = max;
        }
    }

    public int goodNodes(TreeNode root) {
        if(root == null) return 0;

        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root, Integer.MIN_VALUE));
        int ans = 0;
        while(!stack.isEmpty()) {
            Pair top = stack.pop();
            TreeNode curr = top.node;

            if(curr.left != null) stack.push(new Pair(curr.left, Math.max(curr.val, top.max)));
            if(curr.right != null) stack.push(new Pair(curr.right, Math.max(curr.val, top.max)));

            if(curr.val >= top.max) ans++;
        }
        return ans;
    }
}