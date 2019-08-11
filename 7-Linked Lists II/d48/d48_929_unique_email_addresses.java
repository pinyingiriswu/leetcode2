public class d48_929_unique_email_addresses {
    /** Time: O(n)
     * Space: O(n) */
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < emails.length; i++) {
            int atIdx = emails[i].indexOf("@");
            String local = emails[i].substring(0, atIdx);
            String domain = emails[i].substring(atIdx);
            if (local.contains("+")) {
                local = local.substring(0, local.indexOf("+"));
            }
            local = local.replaceAll("\\.", ""); //use "\\." for escape character, replaceAll can only be used for string arguments, not char arguments
            set.add(local + domain);
        }

        return set.size();
    }
}
