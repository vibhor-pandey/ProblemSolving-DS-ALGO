import java.util.*;

/**
 * 90 / 90 test cases passed.
 * Status: Accepted
 * Runtime: 20 ms
 * Memory Usage: 45.2 MB
 *
 * Time Complexity: O(m.n)
 * Space Complexity: O(m.n)
 */


class Node {
    int row;
    int col;
    int steps;

    Node(int r, int c, int steps) {
        this.row = r;
        this.col = c;
        this.steps = steps;
    }

    public String toString() {
        return "(" + row + ", " + col + "): " + steps;
    }
}

class Solution {

    boolean[][] seen;
    int[][] directions;

    public int shortestPathBinaryMatrix(int[][] grid) {
        //1) Shortest Path : Source(0, 0) -> Destination(n-1, n-1)
        //2) Can Traverse on grid[i][j] == 0
        //3) Neighbors: 8 directions (including corners)
        if(grid[0][0] == 1) return -1;

        int m = grid.length;
        int n = grid[0].length;

        if(m == 1 && n == 1) return 1;

        seen = new boolean[m][n];
        directions = getDirections();

        return traverseBFS(grid);

    }

    private int traverseBFS(int[][] grid) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0, 0, 1));
        seen[0][0] = true;

        // int ans = 0;

        int nextR = -1;
        int nextC = -1;
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            for(int[] direction : directions) {
                nextR = node.row + direction[0];
                nextC = node.col + direction[1];

                if(isValid(nextR, nextC, grid) && !seen[nextR][nextC]) {
                    Node next = new Node(nextR, nextC, node.steps + 1);

                    seen[nextR][nextC] = true;
                    queue.offer(next);
                    if(nextR == (grid.length - 1) && nextC == (grid[0].length - 1)) {
                        return node.steps + 1;
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