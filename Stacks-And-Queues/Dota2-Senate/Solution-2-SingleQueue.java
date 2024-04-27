import java.util.*;

/**
 * 82 / 82 test cases passed.
 * Status: Accepted
 * Runtime: 8 ms
 * Memory Usage: 44.5 MB
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

class Solution {

    /**
     1) Init Queue: Stores senator, to track each round
     2) Init dCount & rCount: To track number of senators of R/D for each round
     3) Init rPendingBan & dPendingBan: To track next opponents to be banned
     4) Populate Queue for 1st Round & update count
     5) While(rCount > 0 && dCount > 0):
     6) ---- if 'R' then
     7) -------- if rPendingBan > 0 then rPendingBan--, rCount--
     8) -------- else dPendingBan++, q.offer(c)
     9) ---- else
     10)-------- if dPendingBan > 0 then dPendingBan--, dCount--
     11)--------- else dPendingBan++, q.offer(c)
     12) if rCount > 0 then return 'Radiant' else 'Dire'
     */

    public String predictPartyVictory(String senate) {

        /**
         1) Init Queue: Stores senator, to track each round
         2) Init dCount & rCount: To track number of senators of R/D for each round
         3) Init rPendingBan & dPendingBan: To track next opponents to be banned
         */
        Queue<Character> q = new LinkedList<>();
        int rCount = 0;
        int dCount = 0;
        int rPendingBan = 0;
        int dPendingBan = 0;

        //Populate Queue for 1st Round & update count
        for(char c : senate.toCharArray()) {
            q.offer(c);
            if(c == 'R') rCount++;
            else dCount++;
        }

        while(rCount > 0 && dCount > 0) {
            char senator = q.poll();
            if(senator == 'R') {
                if(rPendingBan > 0) {
                    rPendingBan--;
                    rCount--;
                } else {
                    dPendingBan++;
                    q.offer(senator);
                }
            } else {
                if(dPendingBan > 0) {
                    dPendingBan--;
                    dCount--;
                } else {
                    rPendingBan++;
                    q.offer(senator);
                }
            }
        }

        return rCount > 0 ? "Radiant" : "Dire";
    }
}