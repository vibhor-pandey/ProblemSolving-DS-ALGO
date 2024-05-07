import common.TreeNode;
import java.util.*;

/**
 * 78 / 78 test cases passed.
 * Status: Accepted
 * Runtime: 2 ms
 * Memory Usage: 45 MB
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
    public List<Integer> largestValues(TreeNode root) {
        if(root == null) return new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> ans = new ArrayList<>();
        while(!queue.isEmpty()) {
            int nodesInLevel = queue.size();
            int max = Integer.MIN_VALUE;
            for(int i = 0; i < nodesInLevel; i++) {
                TreeNode current = queue.poll();
                max = Math.max(max, current.val);
                if(current.left != null) queue.offer(current.left);
                if(current.right != null) queue.offer(current.right);
            }
            ans.add(max);
        }
        return ans;
    }
}