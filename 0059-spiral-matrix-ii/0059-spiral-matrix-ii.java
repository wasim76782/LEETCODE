class Solution {
    public int[][] generateMatrix(int n) {
        int[][] arr = new int[n][n];
        int left = 0;
        int right = n-1;
        int top = 0;
        int bottom = n-1;
        int currentElement = 1;

        while(left<=right && top<=bottom){
            for(int i=left;i<=right;i++){
                arr[top][i]=currentElement;
                currentElement++;

            }
            top++;

            for(int i=top;i<=bottom;i++){
                arr[i][right]= currentElement;
                currentElement++;
            }
            right--;

            for(int i=right;i>=left;i--){
                arr[bottom][i]=currentElement;
                currentElement++;
            }
            bottom--;

            for(int i=bottom;i>=top;i--){
                arr[i][left]=currentElement;
                currentElement++;
            }
            left++;
        }
        return arr;
    }
}