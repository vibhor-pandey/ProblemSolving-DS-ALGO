import java.util.*;

/**
 * 66 / 66 test cases passed.
 * Status: Accepted
 * Runtime: 11 ms
 * Memory Usage: 82.9 MB
 *
 * Time Complexity: O(e) - Number of Edges
 * Space Complexity: O(n)
 */

class Solution {

    Set<Integer> toSee = new HashSet<>();



    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        // Directed Acyclic Graph
        // Nodes: 0 - (n -1)
        // I/P: List<Edges>: edges[i] = [from, to]
        // O/P: Set<Vertices>: Minimum to traverse all nodes

        /**
         * 1) Build In-Degree: int[]
         * 2) Return Nodes with 0 in-degree
         */

        int[] inDegree = getInDegree(n, edges);
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            if(inDegree[i] == 0) {
                ans.add(i);
            }
        }
        return ans;
    }

    private int[] getInDegree(int n, List<List<Integer>> edges) {
        int[] inDegree  = new int[n];
        for(List<Integer> edge : edges) {
            inDegree[edge.get(1)] += 1;
        }
        return inDegree;
    }
}