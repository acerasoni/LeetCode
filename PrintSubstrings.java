// Print all substrings of a given input string

public class Solution {

    private static void substrings(String s) {
        for(int i = 0; i < s.length(); i++) {
            for(int j = i+1; j <= s.length(); j++) {
                System.out.println(s.substring(i, j));
            }
        }
    }
    public static void main(String... args){
        substrings("abcsasqwerfa");
    }
}
