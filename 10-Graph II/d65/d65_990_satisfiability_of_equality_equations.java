public class d65_990_satisfiability_of_equality_equations {
    /** Time: O(n^2)
     * Space: O(1)
     * */
    public boolean equationsPossible(String[] equations) {
        for (String s: equations) {
            if (s.charAt(1) == '!') {
                if (s.charAt(0) == s.charAt(3)) {
                    return false;
                }
            }

            if (s.charAt(1) == '=') {
                if (s.charAt(0) != s.charAt(3)) {
                    for (int i = 0; i < equations.length; i++) {
                        equations[i] = equations[i].replace(s.charAt(3), s.charAt(0));
                    }
                    return equationsPossible(equations);
                }
            }
        }
        return true;
    }
}
