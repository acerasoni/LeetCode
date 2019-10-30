// Given a string, find the longest permutation that is also a palindrome

class Solution {
    boolean[] visited;
    StringBuilder sb = new StringBuilder();
    String currentMax = "";
    String or;
   
    public String longestPalindrome(String s) {
       visited = new boolean[s.length()];
       or = s;
       recur();
        return currentMax;
    } 
    
    public void recur() {
            if(isPalindrome(sb.toString())) {
                if(sb.length() > currentMax.length()) 
                    currentMax = sb.toString();     
        }
        
        for(int i = 0; i < or.length(); i++) {
            if(visited[i]) continue;
            visited[i] = true;
            sb.append(or.charAt(i));
            recur();
            visited[i] = false;
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    
    public boolean isPalindrome(String s) {
        System.out.println(s);
        int i, j = s.length() - 1;
        
        for(i = 0; i < s.length() / 2; i++) {
            if(s.charAt(i) != s.charAt(j)) return false;
            j--;
        }
        
        return true;
    }
}
