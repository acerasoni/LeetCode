// https://leetcode.com/problems/longest-common-prefix/submissions/
// O(m * n) where m is the number of input strings and n is the length of the shortest

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) return "";
        int result = 0;
        char current;
        int minL = Integer.MAX_VALUE;
        
        for(String s : strs) {
            if(s.length() < minL) minL = s.length();
        }
        
       OUTER: for(int i = 0; i < minL; i++) {
            current = strs[0].charAt(i);
            
            for(int x = 1; x < strs.length; x++) {
                if(strs[x].charAt(i) != current) break OUTER;
            }
           
        ++result;
        }
        return strs[0].substring(0, result);
    }
}
