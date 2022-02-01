class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> validEmails = new HashSet<String>();

        for(int i = 0; i < emails.length; i++){
            String[] parts = emails[i].split("@");
            String local = parts[0];
            String domain = parts[1];
            String[] valid = local.split("\\+");
            String part1 = valid[0];
            part1 = part1.replace(".", "");
            validEmails.add(part1 + "@" + parts[1]);
        }
        return validEmails.size();
    }
}
