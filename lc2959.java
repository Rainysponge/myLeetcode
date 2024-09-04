import java.util.Arrays;

public class lc2959 {
    public int numberOfSets(int n, int maxDistance, int[][] roads) {
        int res = 0;
        int[] opened = new int[n];
        int[][] d = new int[n][n];

        for (int mask = 0; mask < (1 << n); mask++){
            for (int i = 0; i < n; i++){
                opened[i] = mask & (1 << i);
            }
            for (int[] row : d){
                Arrays.fill(row, Integer.MAX_VALUE);
            }
            for (int[] road: roads){
                int i = road[0], j = road[1], r = road[2];
                if (opened[i] > 0 && opened[j] > 0){
                    d[i][j] = d[i][j] = Math.min(d[i][j], r);
                }
            }
            // Floyd-Warshall algorithm
            for (int k = 0; k < n; k++) {
                if (opened[k] > 0) {
                    for (int i = 0; i < n; i++) {
                        if (opened[i] > 0) {
                            for (int j = i + 1; j < n; j++) {
                                if (opened[j] > 0) {
                                    d[i][j] = d[j][i] = Math.min(d[i][j], d[i][k] + d[k][j]);
                                }
                            }
                        }
                    }
                }
            }

            // Validate
            int good = 1;
            for (int i = 0; i < n; i++) {
                if (opened[i] > 0) {
                    for (int j = i + 1; j < n; j++) {
                        if (opened[j] > 0) {
                            if (d[i][j] > maxDistance) {
                                good = 0;
                                break;
                            }
                        }
                    }
                    if (good == 0) {
                        break;
                    }
                }
            }
            res += good;

        }



        return res;
    }
}
