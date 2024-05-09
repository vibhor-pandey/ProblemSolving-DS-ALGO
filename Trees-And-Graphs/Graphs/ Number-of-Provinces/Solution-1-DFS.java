import java.util.*;

/**
 * 114 / 114 test cases passed.
 * Status: Accepted
 * Runtime: 5 ms
 * Memory Usage: 47 MB
 *
 * Time Complexity: O(n^2)
 * Space Complexity: O(n + e)
 */

class Solution {

    private Map<Integer, List<Integer>> graph;
    private boolean[] seen;

    public int findCircleNum(int[][] isConnected) {
        graph = buildGraph(isConnected);
        seen = new boolean[isConnected.length];

        int ans = 0;

        //Traverse for each node
        for(int i = 0; i < isConnected.length; i++) {
            if(!seen[i]) {
                ans++;
                seen[i] = true;
                traverseDFS(i);
            }
        }

        return ans;
    }

    private void traverseDFS(int node) {
        for(int neighbour : graph.get(node)) {
            if(!seen[neighbour]) {
                seen[neighbour] = true;
                traverseDFS(neighbour);
            }
        }
    }

    private Map<Integer, List<Integer>> buildGraph(int[][] isConnected) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int len = isConnected.length;

        for(int i = 0; i < len; i++) {
            if(!graph.containsKey(i)) {
                graph.put(i, new ArrayList<>());
            }
            for(int j = i + 1; j < len; j++) {
                if(!graph.containsKey(j)) {
                    graph.put(j, new ArrayList<>());
                }
                if(isConnected[i][j] == 1) {
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }

        return graph;
    }
}