import java.util.*;

/**
 * 56 / 56 test cases passed.
 * Status: Accepted
 * Runtime: 6 ms
 * Memory Usage: 54.7 MB
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

class Solution {
    public boolean canReach(int[] arr, int start) {
        if(arr.length == 0 && start >= arr.length) return false;

        boolean[] seen = new boolean[arr.length];
        Queue<Integer> stack = new LinkedList<>();
        stack.offer(start);
        seen[start] = true;

        while(!stack.isEmpty()) {
            int top = stack.poll();
            if(arr[top] == 0) return true;
            for(int next : new int[] {(top + arr[top]), (top - arr[top])}) {
                if(isValid(next, arr) && !seen[next]) {
                    seen[next] = true;
                    stack.offer(next);
                }
            }
        }
        return false;
    }

    private boolean isValid(int i, int[] arr) {
        return 0 <= i && i < arr.length;
    }
}