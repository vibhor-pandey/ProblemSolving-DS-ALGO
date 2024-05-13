import java.util.*;
import common.*;

/**
 * 57 / 57 test cases passed.
 * Status: Accepted
 * Runtime: 15 ms
 * Memory Usage: 42.4 MB
 *
 * Time Complexity: O(n)
 *  -> Populate Parent - O(n) Traversing complete Tree using BFS
 *  -> Traverse BSF(target) - O(n) - Worst case k == height/depth of tree
 *
 * Space Complexity: O(n)
 */


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        // 1) Build Graph
        // 2) TraverseBFS(source, k)
        if(k == 0) return Arrays.asList(target.val);
        Map<TreeNode, TreeNode> parent = populateParent(root);
        return traverseBFS(parent, target, k);
    }

    private List<Integer> traverseBFS(Map<TreeNode, TreeNode> parent, TreeNode target, int k) {
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> seen = new HashSet<>();
        queue.offer(target);
        seen.add(target);

        while(!queue.isEmpty() && k > 0) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                if(current.left != null && !seen.contains(current.left)) {
                    queue.offer(current.left);
                    seen.add(current.left);
                }
                if(current.right != null && !seen.contains(current.right)) {
                    queue.offer(current.right);
                    seen.add(current.right);
                }
                if(parent.containsKey(current) && !seen.contains(parent.get(current))) {
                    queue.offer(parent.get(current));
                    seen.add(parent.get(current));
                }
            }
            k--;
        }

        List<Integer> ans = new ArrayList<>();

        while(!queue.isEmpty()) {
            ans.add(queue.poll().val);
        }
        return ans;
    }

    private Map<TreeNode, TreeNode> populateParent(TreeNode root) {
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if(current.left != null) {
                parent.put(current.left, current);
                queue.offer(current.left);
            }
            if(current.right != null) {
                parent.put(current.right, current);
                queue.offer(current.right);
            }
        }
        return parent;
    }
}