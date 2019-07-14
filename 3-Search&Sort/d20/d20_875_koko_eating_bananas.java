public class d20_875_koko_eating_bananas {

    public int minEatingSpeed(int[] piles, int H) {
        if (piles == null || piles.length > H) return -1;
        int start = 1;
        int end = Integer.MAX_VALUE;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (check(piles, mid, H)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    private boolean check(int[] piles, int speed, int H) {
        int sum = 0;
        for (int p: piles) {
            if (p <= speed) {
                sum += 1;
            } else {
                sum += p / speed;
                if (p % speed != 0) {
                    sum += 1;
                }
            }
        }
        return sum <= H;
    }
}
