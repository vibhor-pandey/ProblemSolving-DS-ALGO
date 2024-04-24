import java.util.Stack;
import java.util.HashMap;
import java.util.Map;

/**
 * 99 / 99 test cases passed.
 * Status: Accepted
 * Runtime: 39 ms
 * Memory Usage: 54.4 MB
 * <p>
 * Stack.length -> m;
 * Map.length -> n;
 * <p>
 * Time Complexity [next()]: O(1)
 * Space Complexity: O(n + m)
 */

class StockSpanner {

    private final Stack<Integer> stack;
    private final Map<Integer, Integer> spans;

    public StockSpanner() {
        stack = new Stack<>();
        spans = new HashMap<>();
    }

    public int next(int price) {
        int ans = 1;
        while(!stack.isEmpty() && stack.peek() <= price) {
            int oldPrice = stack.pop();
            ans = ans + spans.getOrDefault(oldPrice, 0);
        }
        stack.add(price);
        spans.put(price, ans);
        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */