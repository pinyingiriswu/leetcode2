public class d48_93_restore_ip_addresses {
    /** Time: O(n)
     * Space: O(n) */
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        helper(s, res, new StringBuilder(), 0);
        return res;
    }

    private void helper(String s, List<String> res, StringBuilder sb, int part) {
        // if already split into 4 sections
        if (part == 4) {
            if (s.length() == 0) { // done with dealing all characters in s
                sb.deleteCharAt(sb.length() - 1);
                res.add(sb.toString());
                // add '.' back for backtracking
                sb.append('.');
            }
            return;
        }

        int len = s.length();

        // try every possible length (1~3) of each IP section
        for (int i = 1; i <= 3 && i <= len; i++) {
            String tmp = s.substring(0, i);
            if (isValid(tmp)) {
                sb.append(tmp).append('.');
                helper(s.substring(i), res, sb, part + 1);
                //backtrack
                int sbSize = sb.length();
                sb.delete(sbSize - 1 - i, sbSize); //StringBuilder delete(int start, int end)
            }
        }
    }

    private boolean isValid(String s) {
        if (s.charAt(0) == '0') {
            return s.length() == 1;
        }
        return (Integer.valueOf(s) > 0 && Integer.valueOf(s) <= 255);
    }
}
