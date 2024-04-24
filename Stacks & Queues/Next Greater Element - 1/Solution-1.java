import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

/**
 * Submission Detail
 * 16 / 16 test cases passed.
 * Status: Accepted
 * Runtime: 3 ms
 * Memory Usage: 44.5 MB
 * <p>
 * nums1.length -> m;
 * nums2.length -> n;
 * stack.length -> Max length i.e. n
 * nextGreater.length -> Max length i.e. n
 * ans.length -> Max length i.e. m
 * <p>
 * Time Complexity: O(m + n)
 * Space Complexity: O(m + n + m)
 */


class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        Map<Integer, Integer> nextGreater = new HashMap<>();


        for(int i = 0; i < nums2.length; i++) {
            while(!stack.isEmpty() && nums2[i] > nums2[stack.getLast()]) {
                int j = stack.removeLast();
                nextGreater.put(nums2[j], nums2[i]);
            }
            stack.addLast(i);
        }

        int[] ans = new int[nums1.length];
        for(int i = 0; i < nums1.length; i++) {
            ans[i] = nextGreater.getOrDefault(nums1[i], -1);
        }

        return ans;
    }
}