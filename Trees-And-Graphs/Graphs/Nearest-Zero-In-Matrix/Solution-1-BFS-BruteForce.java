import java.util.*;

/**
 * Time Complexity: O(m^2 . n^2)
 * Space Complexity: O(m.n)
 */

class Solution {

    private int[][] directions = new int[][] {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    private Set<String> seen;

    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int[][] ans = new int[m][n];
        for(int r = 0; r < m; r++) {
            for(int c = 0; c < n; c++) {
                //traverse BFS
                ans[r][c] = traverseBFS(mat, r, c);
            }
        }


        return ans;
    }

    class Cell {
        int row;
        int col;

        Cell(int r, int c) {
            row = r;
            col = c;
        }

        boolean equals(int r, int c) {
            return row == r && col == c;
        }
    }

    private int traverseBFS(int[][] mat, int row, int col) {
        if(mat[row][col] == 0) return 0;
        seen = new HashSet<>();
        Queue<Cell> queue = new LinkedList<>();
        queue.add(new Cell(row, col));
        seen.add(row + ":" + col);

        int distance = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            distance++;
            for(int i = 0; i < size; i++) {
                Cell current = queue.poll();
                for(int[] dir : directions) {
                    int nextR = dir[0] + current.row;
                    int nextC = dir[1] + current.col;
                    if(isValid(mat, nextR, nextC) && mat[nextR][nextC] == 0) {
                        return distance;
                    }
                    if(!seen.contains(nextR + ":" + nextC)) {
                        seen.add(nextR + ":" + nextC);
                        queue.offer(new Cell(nextR, nextC));
                    }
                }
            }
        }
        return distance;
    }

    private boolean isValid(int[][] mat, int r, int c) {
        return 0 <= r && r < mat.length && 0 <= c && c < mat[0].length;
    }
}