public class d16_969_pancake_sorting {
    public List<Integer> pancakeSort(int[] A) {

        List<Integer> res = new ArrayList();

        for (int i = A.length - 1; i >= 0; i--) {
            int maxIdx = findMaxIndex(A, i);
            flip(A, maxIdx);
            flip(A, i);
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
