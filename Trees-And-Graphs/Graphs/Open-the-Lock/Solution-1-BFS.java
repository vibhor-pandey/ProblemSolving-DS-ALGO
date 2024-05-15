import java.util.*;

/**
 * 48 / 48 test cases passed.
 * Status: Accepted
 * Runtime: 128 ms
 * Memory Usage: 49.8 MB
 *
 * Time Complexity: O(d) - Dead-ends length, rest all are constant (Slots - 4, Digits- 9)
 * Space Complexity: O(d)
 */

class LockState {
    String node;
    int steps;
    LockState(String n, int s) {
        node = n;
        steps = s;
    }
}

class Solution {

    Set<String> seen;

    public int openLock(String[] deadends, String target) {
        seen = new HashSet<>();

        for(String deadend : deadends) {
            if(deadend.equals("0000")) return -1;
            seen.add(deadend);
        }

        Queue<LockState> queue = new LinkedList<>();
        queue.add(new LockState("0000", 0));
        seen.add("0000");

        while(!queue.isEmpty()) {
            LockState current = queue.poll();
            int steps = current.steps;
            if(current.node.equals(target)) return steps;

            for(String neighbor : getNeighbor(current.node)) {
                if(!seen.contains(neighbor)) {
                    queue.offer(new LockState(neighbor, steps + 1));
                    seen.add(neighbor);
                }
            }
        }
        return -1;
    }

    private List<String> getNeighbor(String node) {
        char[] cArray = node.toCharArray();
        List<String> neighbors = new ArrayList<>();

        for(int i = 0; i < cArray.length; i++) {
            int val = Character.getNumericValue(cArray[i]);
            int prevVal = (val - 1 + 10) % 10;
            int nextVal = (val + 1) % 10;

            StringBuilder sbNext = new StringBuilder();
            StringBuilder sbPrev = new StringBuilder();

            for(int j = 0; j < node.length(); j++) {
                if(j == i) {
                    sbNext.append(nextVal);
                    sbPrev.append(prevVal);
                    continue;
                }
                sbPrev.append(cArray[j]);
                sbNext.append(cArray[j]);
            }
            neighbors.add(sbPrev.toString());
            neighbors.add(sbNext.toString());
        }
        return neighbors;
    }
}