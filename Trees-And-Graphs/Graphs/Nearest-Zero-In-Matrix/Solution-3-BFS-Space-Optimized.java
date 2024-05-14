import java.util.*;

/**
 * 50 / 50 test cases passed.
 * Status: Accepted
 * Runtime: 22 ms
 * Memory Usage: 46.6 MB
 *
 * Time Complexity: O(m.n)
 * Space Complexity: O(m.n)
 */

class State {
    int row;
    int col;
    int distance;

    State(int r, int c, int d) {
        row = r;
        col = c;
        distance = d;
    }
}

class Solution {

    private int[][] directions = new int[][] {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    private boolean[][] seen;
    private Queue<State> queue;
    // private int[][] ans;

    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        seen = new boolean[m][n];
        queue = new LinkedList<>();

        // ans = new int[m][n];
        for(int r = 0; r < m; r++) {
            for(int c = 0; c < n; c++) {
                //traverse BFS
                if(mat[r][c] == 0) {
                    queue.offer(new State(r, c, 1));
                    seen[r][c] = true;
                }
            }
        }

        traverseBFS(mat);
        return mat;
    }


    private void traverseBFS(int[][] mat) {
        while(!queue.isEmpty()) {
            State current = queue.poll();
            for(int[] dir : directions) {
                int nextR = dir[0] + current.row;
                int nextC = dir[1] + current.col;
                int dis = current.distance;
                if(isValid(mat, nextR, nextC) && !seen[nextR][nextC]) {
                    seen[nextR][nextC] = true;
                    queue.offer(new State(nextR, nextC, dis + 1));
                    mat[nextR][nextC] = dis;
                }
            }
        }
    }

    private boolean isValid(int[][] mat, int r, int c) {
        return 0 <= r && r < mat.length && 0 <= c && c < mat[0].length && mat[r][c] == 1;
    }
}