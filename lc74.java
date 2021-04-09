package LC;

public class lc74 {

    public boolean searchMatrix(int[][] matrix, int target) {
        int row = binarySearchFirstColumn(matrix, target);

        return binarySearchRow(matrix[row], target);
    }

    public int binarySearchFirstColumn(int[][] matrix, int target) {
        // int row = 0;
//        找到最后一个不大于目标值的元素，然后在该元素所在行中二分查找目标值是否存在。
        int low = 0, high = matrix.length - 1;

        while(low<high){
            int mid = (low + high + 1) / 2;
            if(matrix[mid][0] <= target){
                low = mid;
//                System.out.println(2);
            }else{
                high = mid - 1;
//                System.out.println(3);
            }

        }
        return low;

    }
    public boolean binarySearchRow(int[] row, int target){
        int low = 0, high = row.length - 1;
        while(low<high){
            int mid = (low + high + 1) / 2;

            if(row[mid] == target){
                return true;
            }else if(row[mid] > target){
                high = mid - 1;
                System.out.println(4);
            }else{
                low = mid;
                System.out.println(5);
            }

        }
        return false;
    }
}
