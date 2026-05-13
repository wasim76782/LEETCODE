class Solution {
    public int maxProfit(int[] prices) {
        int Buyprice=Integer.MAX_VALUE;
        int maxProfit=0;
        for(int i=0;i<prices.length;i++){
            if(Buyprice<prices[i]){
                int profit=prices[i]-Buyprice;
                maxProfit=Math.max(maxProfit,profit);
            }
            else{
                Buyprice=prices[i];
            }
        }
        return maxProfit;
    }
   
}