public class d41_subarrays_with_k_different_integers {
    /** Time: O(n)
     * Space: O(n) */
    public int subarraysWithKDistinct(int[] A, int K) {
        int count = 0;
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        int left1 = 0; // count of subarray with at most k integers
        int left2 = 0; // count of subarray with at most k-1 integers
        // atMost(k) - atMost(k-1) = number of subarrays with exactly k distinct numbers

        for (int right = 0; right < A.length; right++) {
            int val = A[right];
            map1.put(val, map1.getOrDefault(val, 0) + 1); // (val, count)
            map2.put(val, map2.getOrDefault(val, 0) + 1);

            while (map1.size() > K) {
                int l1 = map1.getOrDefault(A[left1], 0);
                if (l1 - 1 <= 0) {
                    map1.remove(A[left1]);
                } else {
                    map1.put(A[left1], l1-1);
                }
                left1++;
            }

            while (map2.size() >= K) {
                int l2 = map2.getOrDefault(A[left2], 0);
                if (l2 - 1 <= 0) {
                    map2.remove(A[left2]);
                } else {
                    map2.put(A[left2], l2-1);
                }
                left2++;
            }
            count += left2 - left1;
        }
        return count;
    }
}
