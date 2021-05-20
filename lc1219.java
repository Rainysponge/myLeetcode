package LC;

public class lc1219 {
    int res = 0;
    int[][] move = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    public int getMaximumGold(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] != 0)
                    dfs(grid, visited, i, j, 0);
            }
        }
        return res;


    }

    void dfs(int[][] grid, boolean[][] visited, int row, int col, int earn){
        if(row<0 || row>=grid.length || col<0 || col>=grid[0].length || grid[row][col] == 0) {
            return;
        }
        int tmp = grid[row][col];
        //visited[row][col] = true;
        grid[row][col] = 0;
        earn += tmp;
        res = Math.max(earn, res);


        for(int i=0; i<4; i++){
            dfs(grid, visited, row+move[i][0], col+move[i][1], earn);
        }

        // 回溯
        grid[row][col] = tmp;


    }

}
