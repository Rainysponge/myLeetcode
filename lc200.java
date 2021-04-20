package LC;

import java.util.Deque;
import java.util.List;

public class lc200 {
    int[][] move = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public int numIslands(char[][] grid) {
        int m = grid.length;
        if(m==0 || grid[0].length==0) return 0;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];
        int res = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]=='0' || visited[i][j]) continue;
                dfs(grid, visited, i, j);
                res++;
            }
        }


        return res;

    }

    private void dfs(char[][] grid, boolean[][] visited, int i, int j){
        int m = grid.length;
        int n = grid[0].length;
        if(i<0 || i>=m || j<0 || j>=n) return;
        if(grid[i][j]=='0' || visited[i][j]) return;
        visited[i][j] = true;
        for(int k=0; k<4; k++){
            dfs(grid, visited, i+move[k][0], j+move[k][1]);
        }


    }
}
