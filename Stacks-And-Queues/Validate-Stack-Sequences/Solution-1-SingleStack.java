import java.util.Stack;

/**
 * 152 / 152 test cases passed.
 * Status: Accepted
 * Runtime: 2 ms
 * Memory Usage: 43.5 MB
 *
 * <p>
 * Stack.length -> n;
 * <p>
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

class SolutionSingleStack {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        stack.push(pushed[0]);
        int left = 1;
        int right = 0;
        while(left < pushed.length || right < popped.length) {
            while(left < pushed.length &&
                    !stack.isEmpty() &&
                    stack.peek() != popped[right])
            {
                stack.push(pushed[left]);
                left += 1;
            }
            while(right < popped.length &&
                    !stack.isEmpty() &&
                    stack.peek() == popped[right])
            {
                stack.pop();
                right += 1;
            }

            if(!stack.isEmpty() && left == pushed.length && stack.peek() != popped[right]
                    || right == popped.length && left < pushed.length) {
                break;
            }
            if(stack.isEmpty() && left < pushed.length) {
                stack.push(pushed[left]);
                left += 1;
            }
        }
        return stack.isEmpty();
    }
}