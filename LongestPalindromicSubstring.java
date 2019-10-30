// https://leetcode.com/problems/longest-palindromic-substring/submissions/

class Solution {
    String currentMax = "";

    public String longestPalindrome(String s) {
        int n = s.length();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                String current = s.substring(i, j);
                if (isPalindrome(current) && current.length() > currentMax.length())
                    currentMax = current;
            }
        }
        return currentMax;
    }

    public boolean isPalindrome(String s) {
        int i, j = s.length() - 1;

        for (i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(j)) return false;
            j--;
        }

        return true;
    }

    public static void main(String... args) {
        Solution sol = new Solution();
        System.out.print(sol.longestPalindrome("civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth"));
    }
}
