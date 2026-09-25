class Solution {
    public String[] findWords(String[] words) {
        ArrayList<String> result = new ArrayList<>();
        String a = "qwertyuiopQWERTYUIOP";
        String b = "asdfghjklASDFGHJKL";
        String c = "zxcvbnmZXCVBNM";  

        for(String word:words){
            boolean ina = false, inb = false, inc = false;

            for(char ch: word.toCharArray()){
                if(found(a, ch))
                    ina = true;
                if(found(b, ch))
                    inb = true;
                if(found(c, ch))
                    inc = true;
            }

            if((ina && inb) || (ina && inc) || (inb && inc))
                continue;
            result.add(word);
        }
        return result.toArray(new String[0]);
    }

    public boolean found(String s,char ch){
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==ch)return true;
        }
        return false;
    }
}