import java.util.*;

/**
 * 76 / 76 test cases passed.
 * Status: Accepted
 * Runtime: 138 ms
 * Memory Usage: 86.1 MB
 *
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */


class Solution {

    private Map<Integer, List<Integer>> graph;
    private Set<String> connects;
    private boolean[] seen;
    private int ans;


    public int minReorder(int n, int[][] connections) {
        //1) Build undirected graph out of it
        graph = new HashMap<>();
        connects = new HashSet<>();
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

                if(connects.contains(convertToString(source, neighbour))) {
                    ans++;
                }
                traverseDFS(neighbour);
            }
        }
    }

    private void buildGraph(int n, int[][] connections) {
        for(int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for(int[] connection : connections) {
            graph.get(connection[0]).add(connection[1]);
            graph.get(connection[1]).add(connection[0]);
            connects.add(convertToString(connection[0], connection[1]));
        }
    }

    private String convertToString(int source, int destination) {
        return source + ":" + destination;
    }
}