package LC;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class lc1738 {
    public int kthLargestValue(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        //int[][] matrixSum = new int[m][n];
        List<Integer> res = new ArrayList<>();
        // matrixSum[0][0] = matrix[0][0];
        res.add(matrix[0][0]);
        for(int i=1; i<n; i++){
            matrix[0][i] = matrix[0][i] ^ matrix[0][i-1];
            res.add(matrix[0][i]);
        }
        for(int i=1; i<m; i++){
            matrix[i][0] = matrix[i-1][0] ^ matrix[i][0];
            res.add(matrix[i][0]);
        }

        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                matrix[i][j] = matrix[i][j] ^ matrix[i-1][j] ^ matrix[i-1][j-1] ^ matrix[i][j-1];
                res.add(matrix[i][j]);
            }
        }
//        Collections.sort(results, new Comparator<Integer>() {
//            public int compare(Integer num1, Integer num2) {
//                return num2 - num1;
//            }
//        });
        res.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        return res.get(k-1);
    }



}
