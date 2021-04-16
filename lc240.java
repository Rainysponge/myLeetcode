package LC;

public class lc240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length, cols = matrix[0].length;
        int i = rows - 1, j = 0;
        while(i>=0 && j < cols){
            if(matrix[i][j]==target) return true;
            if(matrix[i][j] > target){
                i--;
            }else{
                j++;
            }
        }
        return false;



    }
}
