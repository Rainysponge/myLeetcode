import java.util.ArrayList;
import java.util.List;

public class lc3033 {
    public int[][] modifiedMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i=0; i<n; i++){
            int _max = -1;  // 记录最大值
            List<Integer> index_list = new ArrayList<>(); // 记录-1行索引
            for (int j=0; j<m; j++){
                if (matrix[j][i] == -1){
                    index_list.add(j);
                }
                if(_max < matrix[j][i]){
                    _max = matrix[j][i];
                }
            }
            for (int row : index_list){
                matrix[row][i] = _max;
            }
        }
        return matrix;
    }
}
