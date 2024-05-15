import java.util.*;

/**
 * 62 / 62 test cases passed.
 * Status: Accepted
 * Runtime: 206 ms
 * Memory Usage: 59.5 MB
 *
 * Time Complexity: O(n lgn)
 * Space Complexity: O(n)
 */

class Solution {
    public int halveArray(int[] nums) {
        PriorityQueue<Double> max = new PriorityQueue<>(Comparator.reverseOrder());
        double sum = 0;
        for(double num : nums) {
            sum += num;
            max.add((double) num);
        }

        int ans = 0;
        double target = sum / 2;
        while(target > 0) {
            ans++;
            double topHalf = max.remove() / 2;
            target -= topHalf;
            max.add(topHalf);
        }
        return ans;
    }
}