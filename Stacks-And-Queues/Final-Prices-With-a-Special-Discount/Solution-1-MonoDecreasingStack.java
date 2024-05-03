import java.util.*;

/**
 * 103 / 103 test cases passed.
 * Status: Accepted
 * Runtime: 4 ms
 * Memory Usage: 44 MB
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

class Solution {
    public int[] finalPrices(int[] prices) {
        //Monotonic Non-Increasing Stack
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[prices.length];

        for(int i = 0; i < prices.length; i++) {
            while(!stack.isEmpty() && prices[stack.peek()] >= prices[i]) {
                int top = stack.pop();
                ans[top] = prices[top] - prices[i];
            }
            stack.push(i);
        }

        while(!stack.isEmpty()) {
            ans[stack.peek()] = prices[stack.pop()];
        }
        return ans;
    }
}