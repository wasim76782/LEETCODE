class Solution {
    public String toLowerCase(String s) {
        String x = "";
        for(int i=0;i<s.length();i++){
           if(s.charAt(i)>='A' && s.charAt(i)<='Z'){
             int temp = s.charAt(i);
             temp = temp+32;
             x= x + (char)temp;
           }
           else{
            x=x+s.charAt(i);
           }
           
        }
        return x;

        
    }
}