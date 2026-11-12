class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int sIncIndex=0,sDescIndex=0,max=1,incCounter=1,descCounter=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i-1]<nums[i]){
                incCounter++;
                descCounter=1;
            }
            else if(nums[i-1]>nums[i]){
                descCounter++;
                incCounter=1;
            }else{
                incCounter=1;
                descCounter=1;
            }
            max=Math.max(max,Math.max(incCounter,descCounter));
        }
        return max;
    }
}