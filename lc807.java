import java.util.Arrays;

public class lc807 {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int n = grid.length;

        int res = 0;
        int[] rowMax = new int[n];
        int[] colMax = new int[n];

        Arrays.fill(rowMax, -1);
        Arrays.fill(colMax, -1);

        for (int i=0; i<n; i++){
            rowMax[i] = getMaxValue(grid[i]);
            int[] colData = new int[n];
            for (int j=0; j<n; j++){
                colData[j] = grid[j][i];
            }
            colMax[i] = getMaxValue(colData);
        }
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                if (grid[i][j] == rowMax[i] || grid[i][j] == colMax[j]){
                    continue;
                }
                int tmp = Math.min(rowMax[i], colMax[j]);
                res += tmp - grid[i][j];
            }
        }

        return res;
    }

    public static int getMaxValue(int[] arr) {
        int max = arr[0];
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }
}
