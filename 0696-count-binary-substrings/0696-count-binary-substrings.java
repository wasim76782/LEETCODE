class Solution {
    public int countBinarySubstrings(String s) {
        int res = 0, prev = 0, str = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) str++;
            else {
                prev = str;
                str = 1;
            }
            if (str <= prev) res++;
        }
        return res;
    }
}