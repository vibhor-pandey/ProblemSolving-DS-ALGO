import java.util.*;

/**
 * 18 / 18 test cases passed.
 * Status: Accepted
 * Runtime: 0 ms
 * Memory Usage: 40.8 MB
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

    public MyStack() {
        queue1 = new LinkedList<>();
    }

    public void push(int x) {

        if(queue1.isEmpty()) queue1.offer(x);
        else {
            queue1.offer(-1);
            queue1.offer(x);
            while(queue1.peek() != -1) {
                queue1.offer(queue1.poll());
            }
            queue1.poll();
        }
    }

    public int pop() {
        return queue1.poll();
    }

    public int top() {
        return queue1.peek();
    }

    public boolean empty() {
        return queue1.isEmpty();
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