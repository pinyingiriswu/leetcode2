public class d49_468_validate_ip_address {
    /** Time: O(n^2)
     * Space: O(n) */
    public String validIPAddress(String IP) {
        if (IP == null || IP.length() == 0) return "Neither";
        String[] groups = IP.split("\\.", -1);
        if (groups.length == 4) {
            return checkIPv4(groups);
        }

        groups = IP.split("\\:", -1);
        if (groups.length == 8) {
            return checkIPv6(groups);
        }

        return "Neither";
    }

    private String checkIPv4(String[] groups) {
        if (groups == null || groups.length == 0) return "Neither";
        for (int i = 0; i < groups.length; i++) {
            String group = groups[i];
            if (group == null || group.length() == 0 || group.length() >= 4) return "Neither";
            for (int j = 0; j < group.length(); j++) {
                char c = group.charAt(j);
                if (!Character.isDigit(c)) return "Neither";
                if (j == 0 && c == '0' && group.length() > 1) return "Neither";
            }

            if (Integer.valueOf(group) < 0 || Integer.valueOf(group) > 255) return "Neither";
        }
        return "IPv4";
    }

    private String checkIPv6(String[] groups) {
        if (groups == null || groups.length == 0) return "Neither";
        for (int i = 0; i < groups.length; i++) {
            String group = groups[i];
            if (group == null || group.length() == 0 || group.length() > 4) return "Neither";
            group = group.toLowerCase();
            for (int j = 0; j < group.length(); j++) {
                char c = group.charAt(j);
                if (!Character.isDigit(c) && (c < 'a' || c > 'f')) return "Neither";
            }
        }
        return "IPv6";
    }
}
