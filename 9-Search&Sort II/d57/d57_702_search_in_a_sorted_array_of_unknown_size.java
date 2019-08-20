public class d57_702_search_in_a_sorted_array_of_unknown_size {
    /** Time: O(n)
     * Space: O(1)*/
    public int search(ArrayReader reader, int target) {
        int index = 1;
        while (reader.get(index - 1) < target) {
            index = index * 2;
        }

        int start = index / 2;
        int end = index - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (reader.get(mid) < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (reader.get(start) == target) {
            return start;
        }
        if (reader.get(end) == target) {
            return end;
        }
        return -1;
    }
}
