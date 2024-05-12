import java.util.*;

/**
 * 728 / 728 test cases passed.
 * Status: Accepted
 * Runtime: 3 ms
 * Memory Usage: 44.6 MB
 *
 * Time Complexity: O(m X n)
 * Space Complexity: O(m X n)
 */

class Solution {

    int[][] directions = new int[][]{{0,1}, {1,0}, {0,-1}, {-1,0}};
    Set<String> seen;

    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        seen = new HashSet<>();
        int area = 0;
        for(int r = 0; r < m; r++) {
            for(int c = 0; c < n; c++) {
                // if(isValid(r, c, grid) && !seen.contains(getHash(r, c))) {
                if(isValid(r, c, grid) && grid[r][c] != -1) {
                    // seen.add(getHash(r, c));
                    grid[r][c] = -1;
                    int current = traverseDFS(grid, r, c) + 1;
                    area = Math.max(area, current);
                }
            }
        }
        return area;
    }

    private int traverseDFS(int[][] grid, int r, int c) {
        int area = 0;
        for(int[] direction : directions) {
            int nextR = r + direction[0];
            int nextC = c + direction[1];

            // if(isValid(nextR, nextC, grid) && !seen.contains(getHash(nextR, nextC))) {
            if(isValid(nextR, nextC, grid) && grid[nextR][nextC] != -1) {
                // seen.add(getHash(nextR, nextC));
                grid[nextR][nextC] = -1;
                area += traverseDFS(grid, nextR, nextC) + 1;
            }
        }
        return area;
    }

    private boolean isValid(int r, int c, int[][] grid) {
        return 0 <= r && r < grid.length && 0 <= c && c < grid[0].length && grid[r][c] == 1;
    }

    private String getHash(int r, int c) {
        return r + ":" + c;
    }
}