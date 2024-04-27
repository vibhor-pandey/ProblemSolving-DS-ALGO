import java.util.*;

/**
 * 82 / 82 test cases passed.
 * Status: Accepted
 * Runtime: 13 ms
 * Memory Usage: 45.9 MB
 *
 * Time Complexity: O(n + n) == O(n)
 * Space Complexity: O(n)
 */

class Solution {

    /**
     1) Two Queues: rQ & dQ
     2) Populate both rQ & dQ with the index of 'R' & 'D' respectively
     3) While -> !rQ.empty() && !dQ.empty()
     4) ---- If (rQ.poll() > dQ.poll()) then dQ.offer(dPolled + n)
     5) ---- Else rQ.offer(rPolled + n)
     6) return 'R/D' by checking empty Q
     */

    public String predictPartyVictory(String senate) {
        //Two Queues: rQ & dQ
        Queue<Integer> rQ = new LinkedList<>();
        Queue<Integer> dQ = new LinkedList<>();

        //Populate both rQ & dQ with the index of 'R' & 'D' respectively
        for(int i = 0; i < senate.length(); i++) {
            if(senate.charAt(i) == 'R') {
                rQ.offer(i);
            } else {
                dQ.offer(i);
            }
        }

        while(!rQ.isEmpty() && !dQ.isEmpty()) {
            int r = rQ.poll();
            int d = dQ.poll();

            if(r > d) dQ.offer(d + senate.length());
            else rQ.offer(r + senate.length());
        }

        return rQ.isEmpty() ? "Dire" : "Radiant";
    }
}