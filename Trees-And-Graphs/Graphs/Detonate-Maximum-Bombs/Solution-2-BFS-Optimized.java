import java.util.*;

/**
 * 164 / 164 test cases passed.
 * Status: Accepted
 * Runtime: 94 ms
 * Memory Usage: 44.7 MB
 *
 * Time Complexity: O(n^3)
 * Space Complexity: O(n^2)
 */


class Solution {

    public int maximumDetonation(int[][] bombs) {
        if(bombs.length == 1) return 1;
        int ans = 0;
        Map<Integer, List<Integer>> graph = buildGraph(bombs);

        for(int i = 0; i < bombs.length; i++) {
            ans = Math.max(ans, traverseDFS(graph, bombs, i));
        }
        return ans;
    }

    private int traverseDFS(Map<Integer, List<Integer>> graph, int[][] bombs, int index) {
        Stack<Integer> stack = new Stack<>();
        boolean[] seen = new boolean[bombs.length];
        seen[index] = true;
        stack.push(index);
        int count = 0;
        while(!stack.isEmpty()) {
            int top = stack.pop();
            count += 1;
            for(int next : graph.get(top)) {
                if(!seen[next]) {
                    stack.push(next);
                    seen[next] = true;
                }
            }
        }
        return count;
    }

    private Map<Integer, List<Integer>> buildGraph(int[][] bombs) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int index = 0; index < bombs.length; index++) {
            int x1 = bombs[index][0];
            int y1 = bombs[index][1];
            long r = bombs[index][2];
            List<Integer> neighbors = new ArrayList<>();
            for(int i = index + 1; i < bombs.length; i++) {
                long dx = x1 - bombs[i][0];
                long dy = y1 - bombs[i][1];
                long d = (dx * dx) + (dy * dy);

                if(d <= (r * r)) {
                    neighbors.add(i);
                }
            }

            for(int i = index - 1; i >= 0; i--) {
                long dx = x1 - bombs[i][0];
                long dy = y1 - bombs[i][1];
                long d = (dx * dx) + (dy * dy);

                if(d <= (r * r)) {
                    neighbors.add(i);
                }
            }
            graph.put(index, neighbors);
        }

        return graph;
    }
}