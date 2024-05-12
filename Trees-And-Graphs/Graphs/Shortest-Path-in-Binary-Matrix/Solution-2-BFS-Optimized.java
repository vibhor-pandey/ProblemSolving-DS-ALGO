import java.util.*;

/**
 * 90 / 90 test cases passed.
 * Status: Accepted
 * Runtime: 14 ms
 * Memory Usage: 45.7 MB
 *
 * Time Complexity: O(m.n)
 * Space Complexity: O(m.n)
 */


class Node {
    int row;
    int col;

    Node(int r, int c) {
        this.row = r;
        this.col = c;
    }
}

class Solution {
    int[][] directions;

    public int shortestPathBinaryMatrix(int[][] grid) {
        //1) Shortest Path : Source(0, 0) -> Destination(n-1, n-1)
        //2) Can Traverse on grid[i][j] == 0
        //3) Neighbors: 8 directions (including corners)
        if(grid[0][0] == 1) return -1;

        int m = grid.length;
        int n = grid[0].length;

        if(m == 1 && n == 1) return 1;

        directions = getDirections();

        return traverseBFS(grid);

    }

    private int traverseBFS(int[][] grid) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0, 0));
        grid[0][0] = 1;

        while(!queue.isEmpty()) {
            Node next = queue.poll();
            for(int[] direction : directions) {
                int nextR = next.row + direction[0];
                int nextC = next.col + direction[1];

                if(isValid(nextR, nextC, grid)) {
                    grid[nextR][nextC] = grid[next.row][next.col] + 1;
                    queue.offer(new Node(nextR, nextC));

                    if(nextR == (grid.length - 1) && nextC == (grid[0].length - 1)) {
                        return grid[next.row][next.col] + 1;
                    }
                }
            }
        }
        return  -1;
    }

    private boolean isValid(int r, int c, int[][] grid) {
        return 0 <= r && r < grid.length && 0 <= c && c < grid[0].length && grid[r][c] == 0;
    }

    private int[][] getDirections() {
        return new int[][] {{1,0}, {1,1}, {0,1}, {-1,1}, {-1,0}, {1,-1}, {0, -1}, {-1,-1}};
    }
}