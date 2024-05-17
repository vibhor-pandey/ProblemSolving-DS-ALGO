import java.util.*;

/**
 * 51 / 51 test cases passed.
 * Status: Accepted
 * Runtime: 571 ms
 * Memory Usage: 46.2 MB
 *
 * Time Complexity: O(n) - word list
 * Space Complexity: O(n)
 */

class State {
    String word;
    int moves;

    State(String w, int m) {
        word = w;
        moves = m;
    }
}

class Solution {

    Queue<State> queue;
    Set<String> seen;
    Set<String> words;

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        queue = new LinkedList<>();
        seen = new HashSet<>();
        words = new HashSet<>(wordList);

        queue.offer(new State(beginWord, 0));
        seen.add(beginWord);

        while(!queue.isEmpty()) {
            State current = queue.poll();
            if(current.word.equals(endWord)) {
                return current.moves + 1;
            }
            for(String next : getPossibleNeighbors(current.word)) {
                if(!seen.contains(next)) {
                    seen.add(next);
                    queue.offer(new State(next, current.moves + 1));
                }
            }
        }
        return 0;
    }

    private List<String> getPossibleNeighbors(String current) {
        List<String> neighbors = new ArrayList<>();
        for(String word : words) {
            if(canBeNeighbor(current, word)) {
                neighbors.add(word);
            }
        }
        for(String w : neighbors) {
            words.remove(w);
        }
        return neighbors;
    }

    private boolean canBeNeighbor(String current, String next) {
        int diff = 0;
        for(int i = 0; i < current.length(); i++) {
            if (current.charAt(i) != next.charAt(i)) {
                diff++;
            }
            if(diff > 1) return false;
        }
        return true;
    }
}