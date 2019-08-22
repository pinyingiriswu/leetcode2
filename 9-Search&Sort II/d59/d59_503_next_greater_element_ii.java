public class d59_503_next_greater_element_ii {
    /** Time: O(n)
     * Space: O(n)*/
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < 2 * n; i++) {
            int temp = nums[i % n];
            while(!st.isEmpty() && nums[st.peek()] < temp) {
                res[st.pop()] = temp;
            }
            if (i < n) st.push(i);
        }
        return res;
    }
}
