class Solution {
    public boolean checkString(String s) {
        boolean x = false;
        for(char ch : s.toCharArray())
        {
            if(x && ch == 'a')
                return false;
            if(ch == 'b')
                x = true;
        }
        return true;
    }
}