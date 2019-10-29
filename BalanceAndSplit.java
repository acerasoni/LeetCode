/* Solution to the following question:
 A string s a sequence characters 'L' and 'R' is defined as balanced ONLY if there are the same number of Ls and Rs.
 Balance the input string by removing as many Ls or Rs as required. 
 Return the number of permutations of the resulting string which are balanced.
*/

import java.util.ArrayList;

class Solution {
    boolean[] visited;
    StringBuilder sb = new StringBuilder();
    String or;
    ArrayList<String> validStrings = new ArrayList<>();

    public int balancedStringSplit(String s) {
        visited = new boolean[s.length()];
        or = s;
        permute();

        return validStrings.size();
    }

    public void permute() {
        if(isValid(sb)) {
            if(!has(sb.toString()))
                validStrings.add(sb.toString());
            else System.out.println(sb.toString());
        }

        if(sb.length() == or.length()) return;

        for(int i = 0; i < or.length(); i++) {
            if(visited[i]) continue;
            visited[i] = true;
            sb.append(or.charAt(i));
            permute();
            sb.deleteCharAt(sb.length() - 1);
            visited[i] = false;
        }
    }

    public boolean isValid(StringBuilder sb) {
        int L = 0, R = 0;
        String s = sb.toString();

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'L') L++;
            else R++;
        }

        return L==R;
    }

    public boolean has(String s) {

        OUTER: for(int i = 0; i < validStrings.size(); i++) {
            if(validStrings.get(i).length() != s.length()) continue;
            for(int n = 0; n < validStrings.get(i).length(); n++) {
                if (validStrings.get(i).charAt(n) != s.charAt(n)) continue OUTER;
            }
            return true;
        }
        return false;
    }

    public static void main(String... args) {
        Solution sol = new Solution();
        System.out.println(sol.balancedStringSplit("RLRRLL"));
    }
}
