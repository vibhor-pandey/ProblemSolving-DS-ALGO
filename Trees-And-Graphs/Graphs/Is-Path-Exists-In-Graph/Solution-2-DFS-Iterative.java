import java.util.*;

/**
 * 33 / 33 test cases passed.
 * Status: Accepted
 * Runtime: 136 ms
 * Memory Usage: 153.6 MB
 *
 * Time Complexity: O(n + e)
 * Space Complexity: O(n)
 */


class Solution {

    Map<Integer, List<Integer>> graph;
    boolean[] seen;
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if(source == destination) return true;
        /**
         * 1) Build Graph
         * 2) Traverse DFS/BFS
         * 3) Return TRUE if Path Exists else FALSE
         */
        seen = new boolean[n];
        buildGraph(n, edges);
        return traverseDfsItr(source, destination);
    }

    private boolean traverseDfsItr(int source, int destination) {
        Stack<Integer> stack = new Stack<>();
        stack.push(source);
        seen[source] = true;

        while(!stack.isEmpty()) {
            int top = stack.pop();
            for(int neighbor : graph.get(top)) {
                if(!seen[neighbor]) {
                    if(neighbor == destination) {
                        return true;
                    }
                    seen[neighbor] = true;
                    stack.push(neighbor);
                }
            }
        }
        return false;
    }


    private void buildGraph(int n, int[][] edges) {
        graph = new HashMap<>();

        for(int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for(int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
    }
}