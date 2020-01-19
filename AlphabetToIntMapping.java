// https://leetcode.com/problems/decrypt-string-from-alphabet-to-integer-mapping/submissions/

Solution {
    public String freqAlphabets(String s) {
        StringBuilder hashBuilder = new StringBuilder();
        StringBuilder result = new StringBuilder();
        int hash = 0;
        
        for(int i = s.length() - 1; i >= 0; i--) {
            if(hash > 0) {  
                hashBuilder.append(s.charAt(i));
                if(hash == 1) {
                  int ascii = Integer.parseInt(hashBuilder.reverse().toString());
                  int tmp = 96 + ascii;
                  char c = (char) tmp;
                  result.append(c);
                  hashBuilder = new StringBuilder();
                }
                hash--;
            } else {
                if(s.charAt(i) == '#') {
                    hash = 2;
                } else {
                    String c = Character.toString(s.charAt(i));
                    int append = 96 + Integer.parseInt(c);
                    result.append(Character.toString((char) append));
                }
            }
        }
        
        return result.reverse().toString();
    }
}
