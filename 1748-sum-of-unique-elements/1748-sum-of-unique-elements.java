class Solution {
    public int sumOfUnique(int[] nums) {
        int[] freq = new int[101];
        int sum = 0;
        for(int num:nums){

            freq[num]++;

        }
        for(int i = 0; i<freq.length;i++){
            if(freq[i]==1){
                sum += i;
            }
        } 
        return sum;  

         

    }
}