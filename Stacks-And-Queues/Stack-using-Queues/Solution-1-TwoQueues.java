import java.util.*;

/**
 * 18 / 18 test cases passed.
 * Status: Accepted
 * Runtime: 0 ms
 * Memory Usage: 41 MB
 *
 * Time Complexity -
 *
 * -> push(): O(n)
 * -> pop(): O(1)
 * -> top(): O(1)
 * -> empty(): O(1)
 *
 * Space Complexity: O(n)
 */

class MyStack {

    private final Queue<Integer> queue1;
    private final Queue<Integer> queue2;

    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int x) {
        if(queue1.isEmpty()) {
            queue1.offer(x);
            while(!queue2.isEmpty()) {
                queue1.offer(queue2.poll());
            }
        } else if(queue2.isEmpty()) {
            queue2.offer(x);
            while(!queue1.isEmpty()) {
                queue2.offer(queue1.poll());
            }
        }
    }

    public int pop() {
        if(queue1.isEmpty()) return queue2.poll();
        else return queue1.poll();
    }

    public int top() {
        if(queue1.isEmpty()) return queue2.peek();
        else return queue1.peek();
    }

    public boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */