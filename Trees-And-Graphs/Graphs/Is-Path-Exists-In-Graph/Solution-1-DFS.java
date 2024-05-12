import java.util.*;

/**
 * 33 / 33 test cases passed.
 * Status: Accepted
 * Runtime: 366 ms
 * Memory Usage: 174.9 MB
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
        // src = source;
        traverseDFS(source, destination);
        return seen[source] && seen[destination];
    }

    // int src = 0;
    private void traverseDFS(int source, int destination) {
        for(int neighbor : graph.get(source)) {
            // if(seen[src] && seen[destination]) return;
            if(!seen[neighbor]) {
                seen[neighbor] = true;
                traverseDFS(neighbor, destination);
            }
        }
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