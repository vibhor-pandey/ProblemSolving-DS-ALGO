import common.TreeNode;

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
    int ans = Integer.MAX_VALUE;
    public int closestValue(TreeNode root, double target) {
        if(root == null) return 0;
        if(Math.abs(ans - target) > Math.abs(root.val - target) ||
                (Math.abs(ans - target) == Math.abs(root.val - target) && ans > root.val)) {
            ans = root.val;
        }

        if(root.val > target) closestValue(root.left, target);
        else if(root.val < target) closestValue(root.right, target);

        return ans;
    }
}