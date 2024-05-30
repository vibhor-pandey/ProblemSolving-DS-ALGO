import common.TreeNode;

import java.util.Stack;

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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if((p == null && q != null) || (p != null && q == null)) return false;
        if(p.val != q.val) return false;

        Stack<TreeNode> stackP = new Stack<>();
        Stack<TreeNode> stackQ = new Stack<>();
        stackP.push(p);
        stackQ.push(q);

        while(!stackP.isEmpty() || !stackQ.isEmpty()) {
            TreeNode currentP = stackP.pop();
            TreeNode currentQ = stackQ.pop();

            if(isSymmetric(currentP, currentQ) && currentP.val == currentQ.val) {
                if(currentP.left != null) stackP.push(currentP.left);
                if(currentP.right != null) stackP.push(currentP.right);

                if(currentQ.left != null) stackQ.push(currentQ.left);
                if(currentQ.right != null) stackQ.push(currentQ.right);
            } else {
                return false;
            }
        }

        return true;
    }

    private boolean isSymmetric(TreeNode p, TreeNode q) {
        if((p.left == null && q.left != null)
                || (p.left != null && q.left == null)) {
            return false;
        }
        if((p.right == null && q.right != null)
                || (p.right != null && q.right == null)) {
            return false;
        }
        return true;
    }
}