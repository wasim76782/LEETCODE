class Solution {
    public int minOperations(String s) {
         char[] cs = s.toCharArray();
        int n = cs.length;
        boolean isSorted = true;
        char mn = cs[0];
        char mx = cs[0];
        
        for (int i = 1; i < n; ++i) {
            if (cs[i] < cs[i - 1]) {
                isSorted = false;
            }
            if (cs[i] < mn) mn = cs[i];
            if (cs[i] > mx) mx = cs[i];
        }
        
        if (isSorted) {
            return 0;
        }
        if (n == 2) {
            return -1;
        }
        if (cs[0] == mn || cs[n - 1] == mx) {
            return 1;
        }
        for (int i = 1; i < n - 1; ++i) {
            if (cs[i] == mn || cs[i] == mx) {
                return 2;
            }
        }
        return 3;
    }
}