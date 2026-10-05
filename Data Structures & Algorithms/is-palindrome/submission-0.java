class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        s = s.replaceAll("[^a-zA-Z0-9]", "");

        int l = 0;
        int r = s.length() - 1;

        while (l < r) {
            char cl = s.charAt(l);
            char cr = s.charAt(r);

            if (cl != cr) {
                return false;
            }
            l++;
            r--;
        }
        return true;

    }
}
