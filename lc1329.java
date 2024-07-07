import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class lc1329 {
    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        boolean[][] used = new boolean[m][n];
        for(boolean[] row: used){
            Arrays.fill(row, false);
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(used[i][j]){
                    continue;
                }
                int tmp_i = i;
                int tmp_j = j;
                ArrayList<Integer> tmpList = new ArrayList<>();
                while(tmp_i<m && tmp_j<n){
                    used[tmp_i][tmp_j] = true;
                    tmpList.add(mat[tmp_i][tmp_j]);
                    tmp_i++;
                    tmp_j++;
                }
                Collections.sort(tmpList);
                tmp_i = i;
                tmp_j = j;
                int cur = 0;
                while(tmp_i<m && tmp_j<n){
                    mat[tmp_i][tmp_j] = tmpList.get(cur);
                    cur++;
                    tmp_i++;
                    tmp_j++;
                }

            }
        }

        return mat;



    }
}