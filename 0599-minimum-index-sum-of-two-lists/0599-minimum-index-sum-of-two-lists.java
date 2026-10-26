class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }

        List<String> res = new ArrayList<>();
        int minSum = Integer.MAX_VALUE;

        for(int j = 0; j < list2.length; j++) {
            if(map.containsKey(list2[j])) {
                int sum = map.get(list2[j]) + j;

                if(sum < minSum) {
                    res.clear();
                    res.add(list2[j]);
                    minSum = sum;
                } else if(sum == minSum) {
                    res.add(list2[j]);
                }
            }
        }

        return res.toArray(new String[0]);
    }
}