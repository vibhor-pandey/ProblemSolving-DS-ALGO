import common.*;
import java.util.*;


/**
 * 189 / 189 test cases passed.
 * Status: Accepted
 * Runtime: 1 ms
 * Memory Usage: 44.2 M
 *
 * Time Complexity: Traversal of Tree O(n) + Iterate List for Min Difference O(n) == O(n)
 * Space Complexity: O(n) + O(n) == O(n) - Function Stack + List
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
    public int getMinimumDifference(TreeNode root) {
        if(root == null) return 0;

        List<Integer> values = new ArrayList<>();
        traverse(root, values);
        int min = Integer.MAX_VALUE;
        for(int i = 1; i < values.size(); i++) {
            min = Math.min(min, (values.get(i) - values.get(i - 1)));
        }
        return min;
    }

    private void traverse(TreeNode node, List<Integer> values) {
        if(node == null) return;

        if(node.left != null) traverse(node.left, values);
        values.add(node.val);
        if(node.right != null) traverse(node.right, values);
    }
}