public class d59_911_online_election {

    class TopVotedCandidate {
        TreeMap<Integer, Integer> winner;

        public TopVotedCandidate(int[] persons, int[] times) {
            winner = new TreeMap<>();
            int leadPerson = persons[0];
            int maxVotes = 0;
            int[] votes = new int[persons.length];

            for (int i = 0; i < persons.length; i++) {
                votes[persons[i]]++;
                if (votes[persons[i]] >= maxVotes) {
                    leadPerson = persons[i];
                    maxVotes = votes[persons[i]];
                }
                winner.put(times[i], leadPerson);
            }
        }

        public int q(int t) {
            return winner.get(winner.floorKey(t));
        }
    }

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */
}
