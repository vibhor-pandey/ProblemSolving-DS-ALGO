import java.util.*;

/**
 * 68 / 68 test cases passed.
 * Status: Accepted
 * Runtime: 1 ms
 * Memory Usage: 44.1 MB
 *
 * Time Complexity: O(n) - All rooms are visited only once
 * Space Complexity: O(n) - Set to add visited room
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
        traverseDFS(rooms, 0);
        return seen.size() == rooms.size();
    }

    private void traverseDFS(List<List<Integer>> rooms, int source) {
        for(int neighbor : rooms.get(source)) {
            if(!seen.contains(neighbor)) {
                seen.add(neighbor);
                traverseDFS(rooms, neighbor);
            }
        }
    }
}