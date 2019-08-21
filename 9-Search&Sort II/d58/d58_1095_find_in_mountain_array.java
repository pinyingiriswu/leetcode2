public class d58_1095_find_in_mountain_array {
    /** Time: O(nlogn)
     * Space: O(1)*/
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int start = 0;
        int end = mountainArr.length() - 1;
        int half = -1;

        // find the peak
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (mountainArr.get(mid) < mountainArr.get(mid - 1)) {
                end = mid;
            } else if (mountainArr.get(mid) > mountainArr.get(mid - 1)) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (mountainArr.get(start) > mountainArr.get(end)) {
            half = start;
        } else {
            half = end;
        }

        // search in the left
        start = 0;
        end = half;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (mountainArr.get(mid) == target) {
                return mid;
            } else if (mountainArr.get(mid) < target) { // note the difference!
                start = mid;
            } else {
                end = mid;
            }
        }

        if (mountainArr.get(start) == target) return start;
        if (mountainArr.get(end) == target) return end;

        // search in the right
        start = half;
        end = mountainArr.length() - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (mountainArr.get(mid) == target) {
                return mid;
            } else if (mountainArr.get(mid) > target) { // note the difference!
                start = mid;
            } else {
                end = mid;
            }
        }

        if (mountainArr.get(start) == target) return start;
        if (mountainArr.get(end) == target) return end;

        return -1;
    }
}
