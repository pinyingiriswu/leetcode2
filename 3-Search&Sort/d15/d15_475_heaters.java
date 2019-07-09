public class d15_475_heaters {
    /**
     m: number of houses, n: number of heaters
     Time complexity: O(mlogn) + O(nlogn)
     */

    // Once we find out the radius to the closest heater for each house,
    // among the radiuses, we find the max value to be our minimum radius for each heater
    public int findRadius(int[] houses, int[] heaters) {

        if (houses == null || houses.length == 0) return 0;
        if (heaters == null || heaters.length == 0) return Integer.MAX_VALUE;

        Arrays.sort(heaters); // O(nlogn)

        int res = Integer.MIN_VALUE;

        for (int i = 0; i < houses.length; i++) { // O(m)
            int radius = findClosestHeater(heaters, houses[i]); // O(logn)
            res = Math.max(res, radius);
        }
        return res;
    }

    // Time complexity for finding the nearest heater: O(logn)
    public int findClosestHeater (int[] heaters, int housePos) {
        int start = 0;
        int end = heaters.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (heaters[mid] == housePos) return 0;
            else if (heaters[mid] < housePos) {
                start = mid;
            } else {
                end = mid;
            }
        }

        int dist1 = Math.abs(heaters[start] - housePos);
        int dist2 = Math.abs(heaters[end] - housePos);

        if (dist1 < dist2) {
            return dist1;
        } else {
            return dist2;
        }
    }
}
