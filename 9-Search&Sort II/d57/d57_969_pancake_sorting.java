public class d57_969_pancake_sorting {
    /** Time: O(n^2)
     * Space: O(1)*/

    //1. Find the largest element, flip it to the start(0), then flip it to the end(A.length - 1)
    //2. Find the second largest element, flip it to the start(0), then flip it to the end(A.length - 2);
    //and so on.
    public List<Integer> pancakeSort(int[] A) {

        List<Integer> res = new ArrayList();

        for (int i = A.length - 1; i >= 0; i--) { // O(n)
            int maxIdx = findMaxIndex(A, i); // O(n)
            flip(A, maxIdx); // O(n)
            flip(A, i); // O(n)
            res.add(maxIdx + 1);
            res.add(i + 1);
        }
        return res;
    }

    private int findMaxIndex(int A[], int end) {
        int maxIdx = -1;
        int maxVal = Integer.MIN_VALUE;

        for (int i = 0; i <= end; i++) {
            if (A[i] > maxVal) {
                maxVal = A[i];
                maxIdx = i;
            }
        }

        return maxIdx;
    }

    private void flip(int[] A, int idx) {
        int start = 0;
        int end = idx;

        while (start < end) {
            int temp = A[start];
            A[start] = A[end];
            A[end] = temp;
            start++;
            end--;
        }
    }
}
