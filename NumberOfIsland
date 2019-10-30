/* https://leetcode.com/problems/number-of-islands/submissions/
Runtime: 2 ms, faster than 45.09% of Java online submissions for Number of Islands.
Memory Usage: 40.7 MB, less than 98.60% of Java online submissions for Number of Islands.
*/

class Solution {
    int numIsland = 0;
    boolean[][] visited;
    
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        visited = new boolean[grid.length][grid[0].length];
        
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1' && !visited[i][j]) {
                    recur(grid, visited, i, j);
                    numIsland++;
                } 
            }
        }
        return numIsland;
    }
    
    public void recur(char[][] grid, boolean[][] visited, int i, int j) {
        if(grid[i][j] != '1' || visited[i][j]) return;
        
        visited[i][j] = true;
        if(i > 0) recur(grid, visited, i-1, j);
        if(i < grid.length-1) recur(grid, visited, i+1, j);
        if(j > 0) recur(grid, visited, i, j-1);
        if(j < grid[0].length-1) recur(grid, visited, i, j+1);
    }
}
