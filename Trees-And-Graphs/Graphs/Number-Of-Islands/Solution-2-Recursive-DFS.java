/**
 * 49 / 49 test cases passed.
 * Status: Accepted
 * Runtime: 6 ms
 * Memory Usage: 48.8 MB
 *
 * Time Complexity: O(M X N)
 *  Space Complexity: O(min(M, N))
 */

class Solution {

    boolean[][] seen;

    int[][] directions = new int[][]{{0,1}, {1,0}, {0,-1}, {-1,0}};

    int m = 0;
    int n = 0;

    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        seen = new boolean[m][n];
        int ans = 0;

        for(int row = 0; row < m; row++) {
            for(int col = 0; col < n; col++) {
                if(grid[row][col] == '1' && !seen[row][col]) {
                    ans++;
                    seen[row][col] = true;
                    traverse(grid, row, col);
                }
            }
        }
        return ans;
    }

    private boolean isValid(char[][] grid, int row, int col) {
        return 0 <= row && row < m && 0 <= col && col < n && grid[row][col] == '1';
    }

    private void traverse(char[][] grid, int r, int c) {
        for(int[] direction : directions) {
            int nextRow = r + direction[0];
            int nextCol = c + direction[1];

            if(isValid(grid, nextRow, nextCol) && !seen[nextRow][nextCol]) {
                seen[nextRow][nextCol] = true;
                traverse(grid, nextRow, nextCol);
            }
        }
    }
}