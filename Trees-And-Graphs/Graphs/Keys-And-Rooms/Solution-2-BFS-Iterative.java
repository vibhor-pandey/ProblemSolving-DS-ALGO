import java.util.*;

/**
 * 68 / 68 test cases passed.
 * Status: Accepted
 * Runtime: 2 ms
 * Memory Usage: 44.3 MB
 *
 * Time Complexity: O(n)
 * Space Complexity: (n)
 */


class Solution {

    Set<Integer> seen;

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        seen = new HashSet<>();
        // Nodes: 0 -> n - 1
        // All Nodes LOCKED except 0
        // I/P: List of Rooms, where rooms[i] represents Set<Room-Key>
        // O/P: t/f

        /**
         * 1) Build Graph : I/P List
         * 2) TraverseDFS(0)
         * 3) Check if All Nodes are Seen then return True
         * 4) Else False
         */
        seen.add(0);
        traverseBFS(rooms);
        return seen.size() == rooms.size();
    }

    private void traverseBFS(List<List<Integer>> rooms) {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(0);
        while(!queue.isEmpty()) {
            int current = queue.poll();
            for(int key : rooms.get(current)) {
                if(!seen.contains(key)) {
                    queue.offer(key);
                    seen.add(key);
                }
            }
        }
    }
}