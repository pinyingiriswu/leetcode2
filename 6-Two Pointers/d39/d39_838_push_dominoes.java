public class d39_838_push_dominoes {
    /** Time: O(n^2)
     * Space: O(n) */
    public String pushDominoes(String dominoes) {
        char[] arr = dominoes.toCharArray();
        char left = '.'; // init left char
        int idx = -1; // left pointer
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '.') continue;
            char right = '.'; // init right char
            right = arr[i];
            if (left == '.' && right == 'L') {
                for (int j = idx + 1; j < i; j++) {
                    arr[j] = 'L';
                }
            } else if (left == 'R' && right == 'R') {
                for (int j = idx + 1; j < i; j++) {
                    arr[j] = 'R';
                }
            } else if (left == 'L' && right == 'L') {
                for (int j = idx + 1; j < i; j++) {
                    arr[j] = 'L';
                }
            } else if (left == 'R' && right == 'L') {
                for (int j = idx + 1, k = i - 1; j < k; j++, k--) {
                    arr[j] = 'R';
                    arr[k] = 'L';
                }
            }
            idx = i;
            left = right;
        }
        if (idx < arr.length - 1 && left == 'R') {
            for (int j = idx + 1; j < arr.length; j++) {
                arr[j] = 'R';
            }
        }
        return new String(arr);
    }
}
