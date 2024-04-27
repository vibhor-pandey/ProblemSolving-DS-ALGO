import java.util.*;

/**
 * 31 / 31 test cases passed.
 * Status: Accepted
 * Runtime: 4 ms
 * Memory Usage: 44.4 MB
 *
 * Time Complexity -
 *  -> push() : O(1);
 *  -> pop(): O(1)
 *  -> top(): O(1)
 *  -> getMin(): O(1)
 *
 *  Space Complexity - O(n + m)
 */

class MinStack {

    private final Stack<Integer> stack;
    private final Stack<Integer> min;

    public MinStack() {
        stack = new Stack<>();
        min = new Stack<>();
    }

    public void push(int val) {
        if(min.isEmpty() || min.peek() >= val) {
            min.push(val);
        }
        stack.push(val);
        // System.out.println("PSH["+val+"]");
        // System.out.println("STK : " + stack);
        // System.out.println("MIN : " + min);
        // System.out.println("--------------");
    }

    public void pop() {
        if(stack.peek().equals(min.peek())) {
            min.pop();
        }
        stack.pop();
        // System.out.println("POP[]");
        // System.out.println("STK : " + stack);
        // System.out.println("MIN : " + min);
        // System.out.println("--------------");
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */