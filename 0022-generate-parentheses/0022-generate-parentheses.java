class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        generate(result, 0, 0, "", n);
        return result;
    }
    
    public void generate(List<String> result, int open, int close, String s, int n) {
        if (s.length() == n * 2) {
            result.add(s);
            return;
        }
        
        if (open < n) {
            generate(result, open + 1, close, s + "(", n);
        }
        
        if (close < open) {
            generate(result, open, close + 1, s + ")", n);
        }
    }
}