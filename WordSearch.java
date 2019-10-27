/*
DFS Backtracking algorithm for LeetCode problem Word Search.
https://leetcode.com/problems/word-search/submissions/
Runtime: 26 ms, faster than 13.01% of Java online submissions for Word Search.
Memory Usage: 39.8 MB, less than 56.12% of Java online submissions for Word Search.
*/

class Solution {
    Boolean result = false;
    int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    boolean[][] visited;

    public boolean exist(char[][] grid, String target) {
        if (grid == null || grid.length == 0) return false;

        Stack<Character> stack = new Stack<>();
        int letters = 0;
        int col = 0, row = 0;
        visited = new boolean[grid.length][grid[0].length];

        for (int i = target.length() - 1; i >= 0; i--) {
            stack.push(target.charAt(i));
            letters++;
        }

        OUTER:
        for (int m = 0; m < grid.length; m++) {
            for (int n = 0; n < grid[0].length; n++) {
                char charAt = grid[m][n];

                if (stack.peek() == charAt) {
                    char tmp = stack.pop();
                    visited[m][n] = true;
                    letters--;
                    navigate(stack, grid, m, n, letters);
                    if (result) break OUTER;
                    stack.push(tmp);
                    visited[m][n] = false;
                    letters++;
                }
            }

        }
        return result;
    }

    private void navigate(Stack<Character> stack, char[][] grid, int m, int n, int letters) {
        if (letters == 0) {
            result = true;
            return;
        }
        boolean[] dirCheck = {true, true, true, true};
        if (m == 0) dirCheck[2] = false;
        if (m == grid.length - 1) dirCheck[0] = false;
        if (n == 0) dirCheck[3] = false;
        if (n == grid[0].length - 1) dirCheck[1] = false;


        for (int i = 0; i < 4; i++) {
            if (!dirCheck[i]) continue;
            int newM = m + dirs[i][0];
            int newN = n + dirs[i][1];
            if (visited[newM][newN]) continue;
            char charAt = grid[newM][newN];


            if (stack.peek() == charAt) {
                char tmp = stack.pop();
                visited[m][n] = true;
                letters--;
                navigate(stack, grid, newM, newN, letters);
                if (result) return;
                stack.push(tmp);
                visited[m][n] = false;
                letters++;
            }
        }
    }
}
