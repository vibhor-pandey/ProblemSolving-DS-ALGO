import java.util.Stack;

/**
 * 65 / 65 test cases passed.
 * Status: Accepted
 * Runtime: 31 ms
 * Memory Usage: 45.1 MB
 * <p>
 * Stack.length -> n;
 * <p>
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

class Solution {
    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for(char c : s.toCharArray()) {
            if(c == '*') {
                sb.deleteCharAt(sb.length() - 1);
                continue;
            }
            sb.append(c);
        }
        return sb.toString();
    }
}