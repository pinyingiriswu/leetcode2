public class d69_996_number_of_squareful_arrays {
    /** Time: O(n!)
     * Space: O(n)
     * */
    int res = 0;
    public int numSquarefulPerms(int[] A) {
        List<Integer> list = new ArrayList<>();
        for (int num: A) {
            list.add(num);
        }
        helper(list, -1);
        return res;
    }

    public void helper(List<Integer> list, int last) {
        if (list.size() == 0) {
            res++;
            return;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < list.size(); i++) {
            int tmp = list.get(i);
            if (!set.contains(tmp) && (last == -1 || isSquareful(last + tmp))) {
                int lastNum = tmp;
                list.remove(i);
                helper(list, lastNum);
                list.add(i, tmp); // backtrack, add it back
            }
            set.add(tmp);
        }
    }

    private boolean isSquareful(double num) {
        double sqrtNum = Math.sqrt(num);
        return Math.floor(sqrtNum) == sqrtNum;
    }
}
