import java.util.*;

/**
 * 90 / 90 test cases passed.
 * Status: Accepted
 * Runtime: 6 ms
 * Memory Usage: 44.7 MB
 *
 * Time Complexity: O(n + e)
 * Space Complexity: O(n + e)
 */


class State {
    int node;
    int steps;
    boolean isBlue;

    State(int n, int s, boolean b) {
        node = n;
        steps = s;
        isBlue = b;
    }
}

class Solution {

    private Map<Integer, List<Integer>> bGraph;
    private Map<Integer, List<Integer>> rGraph;

    private boolean[][] seen;
    private int[] ans;

    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        buildGraph(n, redEdges, blueEdges);

        ans = new int[n];
        Arrays.fill(ans, Integer.MAX_VALUE);
        seen = new boolean[n][2];
        traverseBFS(0);

        for(int i = 0; i < n; i++) {
            if(ans[i] == Integer.MAX_VALUE) ans[i] = -1;
        }

        return ans;
    }


    private void traverseBFS(int src) {
        Queue<State> queue = new LinkedList<>();

        if(bGraph.containsKey(0)) {
            queue.add(new State(0, 0, true));
            seen[0][0] = true;
        }
        if(rGraph.containsKey(0)) {
            queue.add(new State(0, 0, false));
            seen[0][1] = true;
        }


        while(!queue.isEmpty()) {
            State current = queue.poll();
            int steps = current.steps;
            int node = current.node;
            ans[node] = Math.min(ans[node], steps);

            if(current.isBlue) {
                for(int next : rGraph.get(node)) {
                    if(!seen[next][0]) {
                        seen[next][0] = true;
                        queue.offer(new State(next, steps + 1, false));
                    }
                }
            } else {
                for(int next : bGraph.get(node)) {
                    if(!seen[next][1]) {
                        seen[next][1] = true;
                        queue.offer(new State(next, steps + 1, true));
                    }
                }
            }
        }
    }

    private void buildGraph(int n, int[][] redEdges, int[][] blueEdges) {
        bGraph = new HashMap<>();
        rGraph = new HashMap<>();

        for(int i = 0; i < n; i++) {
            bGraph.put(i, new ArrayList<>());
            rGraph.put(i, new ArrayList<>());
        }

        for(int[] edge : redEdges) {
            rGraph.get(edge[0]).add(edge[1]);
        }

        for(int[] edge : blueEdges) {
            bGraph.get(edge[0]).add(edge[1]);
        }
    }
}