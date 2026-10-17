class Solution {
    public int minSwaps(int[] nums) {
        int ans = 0;
        int n = nums.length;
        ArrayList<int[]> temp = new ArrayList<>();
        for(int i = 0 ; i < nums.length ; i++){
            int[] t = {i,nums[i]};
            temp.add(t);
        }
        Collections.sort(temp,(a,b) -> {
            int v1 = a[1];
            int v2 = b[1];
            int s1 = 0;
            int s2 = 0;
            while(v1 > 0){
                int rem = v1 % 10;
                v1 /= 10;
                s1 += rem;
            }
            while(v2 > 0){
                int rem = v2 % 10;
                v2 /= 10;
                s2 += rem;
            }
            if(s1 == s2){
                return Integer.compare(a[1],b[1]);
            }
            return Integer.compare(s1,s2);
        });
        for(int i = 0 ; i < n ; i++){
            int[] t = temp.get(i);
            nums[t[0]] = i;
        }
        int i = 0;
        while(i < n){
            if(nums[i] == i){
                i++;
            }else{
                ans++;
                int val = nums[i];
                int v1 = nums[val];
                nums[i] = v1;
                nums[val] = val;
            }
        }
        return ans;
    }
}