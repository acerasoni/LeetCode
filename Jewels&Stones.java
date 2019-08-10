/*
Easy - https://leetcode.com/problems/jewels-and-stones/submissions/
Time complexity is O(n)
*/

class Solution {
    public int numJewelsInStones(String J, String S) {
        int result = 0;
        int jeCount = 0;
        Set<Character> chars = new HashSet<>();
        

        for(int x = 0; x < S.length(); x++) {
                if(chars.contains(S.charAt(x))) result++;
                else if(jeCount < J.length() && S.charAt(x) == J.charAt(jeCount)){
                    result++;
                    jeCount++;
                    chars.add(S.charAt(x));
                }
        }
        
        return result;
    }
}
