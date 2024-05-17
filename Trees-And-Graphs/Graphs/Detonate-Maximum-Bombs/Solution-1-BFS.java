import java.util.*;

/**
 * 164 / 164 test cases passed.
 * Status: Accepted
 * Runtime: 220 ms
 * Memory Usage: 44.8 MB
 *
 * Time Complexity: O(n^3)
 * Space Complexity: O(n^2)
 */

class Solution {

    public int maximumDetonation(int[][] bombs) {
        if(bombs.length == 1) return 1;
        int ans = 0;
        for(int i = 0; i < bombs.length; i++) {
            ans = Math.max(ans, traverseDFS(bombs, i));
        }
        return ans;
    }

    private int traverseDFS(int[][] bombs, int index) {
        Stack<Integer> stack = new Stack<>();
        boolean[] seen = new boolean[bombs.length];
        seen[index] = true;
        stack.push(index);
        int count = 1;

        while(!stack.isEmpty()) {
            int top = stack.pop();
            for(int next : getNeighbors(bombs, top)) {
                if(!seen[next]) {
                    stack.push(next);
                    seen[next] = true;
                    count += 1;
                }
            }
        }
        return count;
    }

    private List<Integer> getNeighbors(int[][] bombs, int index) {
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

        return neighbors;
    }
}