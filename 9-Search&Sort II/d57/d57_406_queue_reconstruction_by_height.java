public class d57_406_queue_reconstruction_by_height {
    /** Time: O(nlogn)
     * Space: O(n)*/
    // start by adding tallest people first after sorting
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) {
                    return Integer.compare(a[1], b[1]); // sort k in ascending order
                } else {
                    return Integer.compare(b[0], a[0]); // sort h in descending order
                }
            }
        });

        List<int[]> res = new LinkedList<>();
        for(int[] p: people) {
            //list.add(index, element)
            res.add(p[1], p);
        }

        return res.toArray(people);
    }
}
