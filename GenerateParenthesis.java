// https://leetcode.com/problems/generate-parentheses/solution/
// Backtracking algorithm to generate all valid parenthesis given a number of parenthesis n

import java.util.*;

class Sol {

    boolean[] visited;
    StringBuffer sb = new StringBuffer();
    Set<String> result = new HashSet<>();
    String pair = "()";
    String original;
    int n;

    public List<String> generateParenthesis(int n) {
        StringBuffer chars = new StringBuffer();
        for(int i = 0; i < n; i++) chars.append(pair);
        visited = new boolean[n*2];
        original = chars.toString();
        this.n = n;
        permute(0, 0);

        return new ArrayList(result);
    }

    public void permute(int opening, int closed) {
        if(sb.length() == original.length()) {
            if(isValid(sb.toString())) result.add(sb.toString());
            return;
        }

        for(int i = 0; i < original.length(); i++) {
            if(visited[i]) continue;

            visited[i] = true;
            sb.append(original.charAt(i));
            if(opening < n && original.charAt(i) == '(') permute(opening+1, closed);
            else if(closed < opening && original.charAt(i) == ')') permute(opening, closed+1);

            visited[i] = false;
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(int i =0; i < s.length(); i++) {
            if(stack.isEmpty()) {
                stack.push(s.charAt(i)); continue;
            }

            if(stack.peek() == '(' && s.charAt(i) == ')') stack.pop();
            else stack.push(s.charAt(i));
        }

        return stack.isEmpty();
    }

    public static void main(String... args) {
        Sol main = new Sol();
        long time = System.currentTimeMillis();
        List<String> list = main.generateParenthesis(5);
        for(String s : list) System.out.println(s);
        System.out.println(list.size());
        System.out.println(System.currentTimeMillis() - time);
    }
}

