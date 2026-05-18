class Solution {
    public int distributeCandies(int[] candyType) {
        int n = candyType.length;
        HashSet<Integer> set = new HashSet<>();
        for(int num: candyType){
            set.add(num);

        }
        return Math.min(set.size(), n/2);

    }
}