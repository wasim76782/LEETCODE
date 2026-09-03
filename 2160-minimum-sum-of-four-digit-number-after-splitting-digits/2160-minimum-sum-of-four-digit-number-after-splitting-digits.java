class Solution {
    public int minimumSum(int num) {
             int arr[]=new int[4];
        int k=0;
        while(num>0){
            int last=num%10;
            arr[k]=last;
            k++;
            num=num/10;
        }

        Arrays.sort(arr);

        int n1=arr[0]*10+arr[3];
        int n2=arr[1]*10+arr[2];

        return n1+n2;
    }
}