public class d20_1011_capacity_to_ship_packages_within_d_days {

    public int shipWithinDays(int[] weights, int D) {
        int sum = 0;
        for (int w: weights) {
            sum += w;
        }

        // minimum capacity set to average weight per day
        int start = sum / D;

        // maximum capacity set to total amount of weight
        int end = sum;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (check(weights, mid, D)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    private boolean check(int[] weights, int capacity, int D) {
        int n = weights.length;
        int daysNeeded = 1;
        int weightPerDay = 0;
        int i = 0;

        while (i < n) {
            if (weightPerDay + weights[i] > capacity) {
                if (daysNeeded == D) {
                    return false;
                } else {
                    daysNeeded++;
                    weightPerDay = 0;
                }
            } else {
                weightPerDay += weights[i];
                i++;
            }
        }
        return true;
    }
}
