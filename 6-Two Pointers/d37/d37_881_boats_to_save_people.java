public class d37_881_boats_to_save_people {
    /** Time: O(nlogn)
     * Space: O(1) */
    public int numRescueBoats(int[] people, int limit) {
        if (people.length == 0) return 0;
        Arrays.sort(people);
        int count = 0;
        int i = 0;
        int j = people.length - 1;
        while (i <= j) { // i == j, need to consider only one person left
            count++;
            if (people[i] + people[j] <= limit) {
                i++; //heavy person and light person share a boat
            }
            j--; //heavy person sits in his own boat
        }
        return count;
    }
}
