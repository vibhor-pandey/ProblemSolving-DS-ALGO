import java.util.*;

/**
 * 74 / 74 test cases passed.
 * Status: Accepted
 * Runtime: 1 ms
 * Memory Usage: 40.8 MB
 *
 * Time Complexity: O(n lgn)
 * Space Complexity: O(n)
 */

class Solution {
    public int lastStoneWeight(int[] stones) {
        if(stones.length == 0) return 0;
        if(stones.length == 1) return stones[0];

        PriorityQueue<Integer> max = new PriorityQueue<>(Comparator.reverseOrder());

        for(int stone : stones) {
            max.add(stone);
        }

        while(max.size() > 1) {
            int first = max.remove();
            int second = max.remove();
            int result = first - second;
            if(result != 0) {
                max.add(result);
            }
        }
        return max.isEmpty() ? 0 : max.peek();
    }
}