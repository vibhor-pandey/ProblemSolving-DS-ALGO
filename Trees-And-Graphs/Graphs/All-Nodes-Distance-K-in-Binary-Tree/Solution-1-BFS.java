import java.util.*;
import common.*;

/**
 * 57 / 57 test cases passed.
 * Status: Accepted
 * Runtime: 16 ms
 * Memory Usage: 42.7 MB
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
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        // 1) Build Graph
        // 2) TraverseBFS(source, k)
        if(k == 0) return Arrays.asList(target.val);
        Map<TreeNode, List<TreeNode>> graph = buildGraph(root);
        return traverseBFS(graph, target, k);
    }

    class NodeState {
        TreeNode node;
        int depth;

        NodeState(TreeNode n, int d) {
            this.node = n;
            this.depth = d;
        }
    }

    private List<Integer> traverseBFS(Map<TreeNode, List<TreeNode>> graph, TreeNode target, int k) {
        Queue<NodeState> queue = new LinkedList<>();
        Set<TreeNode> seen = new HashSet<>();
        queue.offer(new NodeState(target, 0));
        seen.add(target);
        int depth = 0;

        List<Integer> ans = new ArrayList<>();
        while(!queue.isEmpty() && k > 0) {
            NodeState current = queue.poll();
            for(TreeNode next : graph.get(current.node)) {
                if(!seen.contains(next)) {
                    queue.offer(new NodeState(next, current.depth + 1));
                    seen.add(next);
                    if((current.depth + 1) == k) {
                        ans.add(next.val);
                    }
                }
            }
        }
        return ans;
    }

    private Map<TreeNode, List<TreeNode>> buildGraph(TreeNode root) {
        Map<TreeNode, List<TreeNode>> graph = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            TreeNode current = queue.poll();

            if(!graph.containsKey(current)) {
                graph.put(current, new ArrayList<>());
            }
            if(current.left != null) {
                queue.offer(current.left);
                if(!graph.containsKey(current.left)) {
                    graph.put(current.left, new ArrayList<>());
                }
                graph.get(current.left).add(current);
                graph.get(current).add(current.left);
            }
            if(current.right != null) {
                queue.offer(current.right);
                if(!graph.containsKey(current.right)) {
                    graph.put(current.right, new ArrayList<>());
                }
                graph.get(current.right).add(current);
                graph.get(current).add(current.right);
            }
        }
        return graph;
    }
}