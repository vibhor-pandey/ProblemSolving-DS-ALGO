/**
 * 39 / 39 test cases passed.
 * Status: Accepted
 * Runtime: 9 ms
 * Memory Usage: 47.1 MB
 *
 * Time Complexity: O(n + n) ==> O(n)
 * Space Complexity: O(n)
 */

// Traverse the tree to find the max depth.
// Traverse the tree again to compute the sum required.


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
    public int deepestLeavesSum(TreeNode root) {

        if(root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int levels = 0;
        while(!queue.isEmpty()) {
            int nodes = queue.size();
            for(int i = 0; i < nodes; i++) {
                TreeNode current = queue.poll();
                if(current.left != null) queue.offer(current.left);
                if(current.right != null) queue.offer(current.right);
            }
            levels++;
        }


        queue.offer(root);
        int currentLevel = 1;
        int ans = 0;
        while(!queue.isEmpty()) {
            int nodes = queue.size();
            for(int i = 0; i < nodes; i++) {
                TreeNode current = queue.poll();
                if(currentLevel == levels) {
                    ans += current.val;
                }
                if(current.left != null) queue.offer(current.left);
                if(current.right != null) queue.offer(current.right);
            }
            currentLevel++;
        }
        return ans;
    }
}