import common.TreeNode;
import java.util.*;

/**
 * 33 / 33 test cases passed.
 * Status: Accepted
 * Runtime: 1 ms
 * Memory Usage: 41.8 MB
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        boolean isLeftToRight = true;
        List<List<Integer>> ans = new ArrayList<>();

        while(!queue.isEmpty()) {
            int nodes = queue.size();
            LinkedList<Integer> level = new LinkedList<>();

            for(int i = 0; i < nodes; i++) {
                TreeNode current = queue.poll();
                if(isLeftToRight) {
                    level.addLast(current.val);
                } else {
                    level.addFirst(current.val);
                }

                if(current.left != null) queue.offer(current.left);
                if(current.right != null) queue.offer(current.right);

            }
            ans.add(level);
            isLeftToRight = !isLeftToRight;
        }
        return ans;
    }
}