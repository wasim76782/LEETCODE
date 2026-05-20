class Solution {
    public int findComplement(int num) {
        int length = Integer.toBinaryString(num).length();
        int helper = (1<<length)-1;
        return helper^num;

    }
}