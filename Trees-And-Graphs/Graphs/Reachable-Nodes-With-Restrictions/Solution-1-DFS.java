import java.util.*;
import java.util.stream.Collectors;

/**
 * 62 / 62 test cases passed.
 * Status: Accepted
 * Runtime: 100 ms
 * Memory Usage: 111 MB
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

class Solution {

    Map<Integer, List<Integer>> graph;
    boolean[] seen;


    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        buildGraph(n, edges, restricted);
        seen = new boolean[n];
        seen[0] = true;
        traverseDFS(0);
        int ans = 0;
        for(boolean node : seen) {
            if(node) ans++;
        }
        return ans;
    }

    private void traverseDFS(int source) {
        for(int next : graph.get(source)) {
            if(!seen[next]) {
                seen[next] = true;
                traverseDFS(next);
            }
        }
    }

    private void buildGraph(int n, int[][] edges, int[] restricted) {
        Set<Integer> blocked = Arrays.stream(restricted).boxed().collect(Collectors.toSet());
        graph = new HashMap<>();
        for(int i = 0; i < n; i++) {
            if(!blocked.contains(i)) {
                graph.put(i, new ArrayList<>());
            }
        }

        for(int[] edge : edges) {
            if(!blocked.contains(edge[0]) && !blocked.contains(edge[1])) {
                graph.get(edge[0]).add(edge[1]);
                graph.get(edge[1]).add(edge[0]);
            }
        }
    }
}