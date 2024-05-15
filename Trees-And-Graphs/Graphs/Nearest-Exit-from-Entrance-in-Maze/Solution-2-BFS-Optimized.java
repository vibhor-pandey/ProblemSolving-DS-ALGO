import java.util.*;

/**
 * 194 / 194 test cases passed.
 * Status: Accepted
 * Runtime: 9 ms
 * Memory Usage: 45.6 MB
 *
 * Time Complexity: O(m.n)
 * Space Complexity: O(m.n)
 */

class Cell {
    int row;
    int col;
    int steps;

    Cell(int r, int c, int s) {
        row = r;
        col = c;
        steps = s;
    }
}

class Solution {

    private int[][] directions = new int[][] {{1,0}, {0,1}, {-1,0}, {0,-1}};
    // private boolean[][] seen;


    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;

        Queue<Cell> queue = new LinkedList<>();
        // seen = new boolean[m][n];
        queue.offer(new Cell(entrance[0], entrance[1], 0));
        maze[entrance[0]][entrance[1]] = '+';

        while(!queue.isEmpty()) {
            Cell current = queue.poll();
            for(int[] direction : directions) {
                int nextR = direction[0] + current.row;
                int nextC = direction[1] + current.col;
                int steps = current.steps;

                if(isValid(nextR, nextC, maze) && isBorderCell(nextR, nextC, maze)) {
                    return steps + 1;
                }

                if(isValid(nextR, nextC, maze)) {
                    maze[nextR][nextC] = '+';
                    queue.offer(new Cell(nextR, nextC, steps + 1));
                }
            }
        }
        return -1;
    }

    private boolean isBorderCell(int r, int c, char[][] maze) {
        return (r == 0 || r == (maze.length - 1)) || (c == 0 || c == (maze[0].length - 1));
    }

    private boolean isValid(int r, int c, char[][] maze) {
        return 0 <= r && r < maze.length && 0 <= c && c < maze[0].length && maze[r][c] == '.';
    }
}