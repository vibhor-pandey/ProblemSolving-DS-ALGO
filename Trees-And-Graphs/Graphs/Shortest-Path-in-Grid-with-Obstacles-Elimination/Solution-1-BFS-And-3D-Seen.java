import java.util.*;

/**
 * 53 / 53 test cases passed.
 * Status: Accepted
 * Runtime: 24 ms
 * Memory Usage: 45.2 MB
 *
 * Time Complexity: O(m.n.k)
 * Space Complexity: O(m.n.k)
 */

class Cell {
    int row;
    int col;
    int remaining;
    int steps;
    Cell(int r, int c, int rem, int s) {
        row = r;
        col = c;
        remaining = rem;
        steps = s;
    }
}

class Solution {

    int[][] directions = new int[][] {{1,0}, {0,1}, {-1,0}, {0,-1}};

    boolean[][][] seen;


    public int shortestPath(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        if(m == 1 && n == 1) return 0;
        seen = new boolean[m][n][k + 1];

        return traversBFS(grid, k);
    }

    int ans = Integer.MAX_VALUE;
    private int traversBFS(int[][] grid, int k) {
        Queue<Cell> queue = new LinkedList<>();
        queue.offer(new Cell(0, 0, k, 0));
        seen[0][0][k] = true;

        while(!queue.isEmpty()) {
            Cell current = queue.poll();
            for(int[] direction : directions) {
                int nextR = current.row + direction[0];
                int nextC = current.col + direction[1];
                int rem = current.remaining;
                int steps = current.steps;
                if(nextR == (grid.length - 1) && nextC == (grid[0].length - 1)) {
                    return steps + 1;
                }

                if(isValid(nextR, nextC, grid) && !seen[nextR][nextC][rem]) {
                    int nextRem = rem;

                    if(grid[nextR][nextC] == 1) {
                        if(nextRem > 0 && !seen[nextR][nextC][rem - 1]) {
                            nextRem -= 1;
                        } else {
                            continue;
                        }
                    }
                    int nextSteps = steps + 1;
                    queue.offer(new Cell(nextR, nextC, nextRem, nextSteps));
                    seen[nextR][nextC][nextRem] = true;
                }
            }
        }
        return -1;
    }

    private boolean isValid(int r, int c, int[][] grid) {
        return 0 <= r && r < grid.length && 0 <= c && c < grid[0].length;
    }
}