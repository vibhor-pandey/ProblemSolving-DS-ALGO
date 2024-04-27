import java.util.Stack;

/**
 * 275 / 275 test cases passed.
 * Status: Accepted
 * Runtime: 9 ms
 * Memory Usage: 45 MB
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */


class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < asteroids.length; i++) {
            boolean flag = true;
            while(!stack.isEmpty()
                    && isColliding(stack.peek(), asteroids[i])) {
                if(Math.abs(asteroids[i]) > Math.abs(stack.peek())) {
                    stack.pop();
                    continue;
                } else if(Math.abs(asteroids[i]) == Math.abs(stack.peek())) {
                    stack.pop();
                }
                flag = false;
                break;
            }

            if(flag) stack.push(asteroids[i]);
        }

        return stack.stream().mapToInt(Integer::intValue).toArray();
    }

    private boolean isColliding(int a, int b) {
        return (a > 0 && b < 0);
    }
}