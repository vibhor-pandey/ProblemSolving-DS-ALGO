/**
 * 22 / 22 test cases passed.
 * Status: Accepted
 * Runtime: 0 ms
 * Memory Usage: 40.9 MB
 * <p>
 * Stack.length -> n;
 * <p>
 * Time Complexity:
 *  -> push(), pop() - amortized O(1) OR O(n)
 *  -> peek(), empty() - O(1)
 * Space Complexity: O(n) - Only one Stack at a time can store elements
 * */



class MyQueue {

    private final Stack<Integer> pushQ;
    private final Stack<Integer> popQ;
    private int peek;

    public MyQueue() {
        pushQ = new Stack<>();
        popQ = new Stack<>();
        peek = -1;
    }

    public void push(int x) {
        if(empty()) peek = x;
        transferElements(popQ, pushQ);
        pushQ.push(x);
    }

    public int pop() {
        if(popQ.isEmpty()) {
            transferElements(pushQ, popQ);
        }
        int top = popQ.pop();
        if(!popQ.isEmpty()) peek = popQ.peek();
        return top;
    }

    private void transferElements(Stack<Integer> from, Stack<Integer> to) {
        while(!from.isEmpty()) {
            to.push(from.pop());
        }
    }

    public int peek() {
        return peek;
    }

    public boolean empty() {
        return pushQ.size() == 0 && popQ.size() == 0;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */