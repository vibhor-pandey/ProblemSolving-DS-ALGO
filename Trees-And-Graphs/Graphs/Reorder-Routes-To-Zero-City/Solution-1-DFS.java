import java.util.*;

/**
 * 76 / 76 test cases passed.
 * Status: Accepted
 * Runtime: 101 ms
 * Memory Usage: 95.3 MB
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */


class Solution {

    private Map<Integer, List<Integer>> graph;
    private Map<Integer, Set<Integer>> directedGraph;
    private boolean[] seen;
    private int ans;


    public int minReorder(int n, int[][] connections) {
        //1) Build undirected graph out of it
        graph = new HashMap<>();
        directedGraph = new HashMap<>();
        buildGraph(n, connections);
        seen = new boolean[n];
        seen[0] = true;
        //2) Traverse DFS from source 0
        //3) Check if there is exiting connection exists while traversing DFS
        traverseDFS(0);


        return ans;
    }

    private void traverseDFS(int source) {
        for(int neighbour : graph.get(source)) {
            if(!seen[neighbour]) {
                seen[neighbour] = true;

                if(directedGraph.get(source).contains(neighbour)) {
                    ans++;
                }
                traverseDFS(neighbour);
            }
        }
    }

    private void buildGraph(int n, int[][] connections) {
        for(int i = 0; i < n; i++) {
            directedGraph.put(i, new HashSet<>());
            graph.put(i, new ArrayList<>());
        }

        for(int[] connection : connections) {
            graph.get(connection[0]).add(connection[1]);
            graph.get(connection[1]).add(connection[0]);
            directedGraph.get(connection[0]).add(connection[1]);
        }
    }
}