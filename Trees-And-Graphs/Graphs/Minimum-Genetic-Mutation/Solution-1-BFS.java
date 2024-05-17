import java.util.*;

/**
 * 18 / 18 test cases passed.
 * Status: Accepted
 * Runtime: 8 ms
 * Memory Usage: 42.3 MB
 *
 * Time Complexity: O(n + e)
 * Space Complexity: O(n)
 */

class State {
    String gene;
    int moves;

    State(String g, int m) {
        gene = g;
        moves = m;
    }
}

class Solution {
    Set<String> seen;
    public int minMutation(String startGene, String endGene, String[] bank) {
        seen = new HashSet<>();
        Queue<State> queue = new LinkedList<>();
        seen.add(startGene);
        queue.offer(new State(startGene, 0));

        while(!queue.isEmpty()) {
            State current = queue.poll();
            for(String next : getNextValidGenes(current.gene, bank)) {
                if(next.equals(endGene)) {
                    return current.moves + 1;
                }
                if(!seen.contains(next)) {
                    State nextState = new State(next, current.moves + 1);
                    queue.offer(nextState);
                    seen.add(next);
                }
            }
        }
        return -1;
    }

    private List<String> getNextValidGenes(String gene, String[] bank) {
        final char[] choices = new char[] {'A', 'C', 'G', 'T'};

        List<String> ans = new ArrayList<>();
        // System.out.println("- " + gene);
        for(int i = 0; i < gene.length(); i++) {
            char ch = gene.charAt(i);
            for(char choice : choices) {
                if(choice != ch) {
                    String s = gene.substring(0, i) + choice + gene.substring(i + 1);
                    // System.out.println("---- " + s);
                    if(validGene(s, bank)) ans.add(s);
                }
            }
        }
        // System.out.println(ans);
        return ans;
    }

    private boolean validGene(String gene, String[] bank) {
        for(String g : bank) {
            if(gene.equals(g) && !seen.contains(g)) return true;
        }
        return false;
    }
}