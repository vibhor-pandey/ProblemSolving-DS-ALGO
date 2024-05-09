import java.util.*;


/**
 * 49 / 49 test cases passed.
 * Status: Accepted
 * Runtime: 11 ms
 * Memory Usage: 56.3 MB
 *
 * Time Complexity: O(M X N)
 * Space Complexity: O(min(M, N))
 */

class Solution {

    //1) Add all the 1s in the Queue<int[row][col]>
    //2) For Each 1s in Queue:
    //3) Traverse for all the direction
    //3) If 1 then add in the Queue<int[row][col]>
    //4) Mark int[row][col] visited

    private static final int[][] DIRECTIONS = new int[][]{
            new int[] {0, 1},
            new int[] {1, 0},
            new int[] {0, -1},
            new int[] {-1, 0}
    };

    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int num = 0;
        for(int gr = 0; gr < grid.length; gr++) {
            for(int gc = 0; gc < grid[0].length; gc++) {
                if(grid[gr][gc] == '0' || grid[gr][gc] == 'X') {
                    continue;
                }
                Queue<int[]> q = new LinkedList<>();
                q.add(new int[] {gr, gc});
                grid[gr][gc] = 'X';
                while(!q.isEmpty()) {
                    // printQ(q);
                    int[] cell = q.remove();
                    int row = cell[0];
                    int col = cell[1];
                    if(row - 1 >= 0 && grid[row - 1][col] == '1') {
                        q.add(new int[] {row - 1, col});
                        grid[row - 1][col] = 'X';
                    }
                    if(col - 1 >= 0 && grid[row][col - 1] == '1') {
                        q.add(new int[] {row, col - 1});
                        grid[row][col - 1] = 'X';
                    }
                    if(row + 1 < rows && grid[row + 1][col] == '1') {
                        q.add(new int[] {row + 1, col});
                        grid[row + 1][col] = 'X';
                    }
                    if(col + 1 < cols && grid[row][col + 1] == '1') {
                        q.add(new int[] {row, col + 1});
                        grid[row][col + 1] = 'X';
                    }
                }
                // print(grid);
                num++;
            }
        }
        return num;
    }

    public void print(char[][] grid) {
        for(int gr = 0; gr < grid.length; gr++) {
            for(int gc = 0; gc < grid[0].length; gc++) {
                System.out.print(grid[gr][gc] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void printQ(Queue<int[]> q) {
        for(int[] rc : q) {
            System.out.print("{" + rc[0] + "," + rc[1] + "}, ");
        }
        System.out.println();
    }
}