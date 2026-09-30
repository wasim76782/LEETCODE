class Solution {
    public int[] maxDepthAfterSplit(String seq) {
       int n=seq.length(),d=0,index=0;
        int[]ans=new int[n];
        for(char c:seq.toCharArray()){
            if(c=='('){
                d++;
                ans[index++]=(d%2==0)?0:1;
            }
            else{
                ans[index++]=d%2==0?0:1;
                d--;
            }
        }
        return ans; 
    }
}