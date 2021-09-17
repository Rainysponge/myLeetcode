package LC;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class lc36 {
    public boolean isValidSudoku(char[][] board) {
        // 需要3个map， 最复杂的点在于将坐标转换为所在格子
        // 一个有效的数独（部分已被填充）不一定是可解的

        Map<Integer, Set<Integer>> rowMap = new HashMap<>();
        Map<Integer, Set<Integer>> colMap = new HashMap<>();
        Map<Integer, Set<Integer>> blockMap = new HashMap<>();

//        for(int i=0; i<9; i++){
//            Set<Integer> rowSet = new HashSet<>();
//            Set<Integer> colSet = new HashSet<>();
//            Set<Integer> blockSet = new HashSet<>();
//
//            rowMap.put(i, rowSet);
//            colMap.put(i, colSet);
//            blockMap.put(i, blockSet);
//        }


        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(board[i][j] == '.'){
                    continue;
                }

                int num = board[i][j] - '0';

                // row
                Set<Integer> rowSet = rowMap.getOrDefault(i, new HashSet<>());
                if(rowSet.contains(num)) {
                    System.out.println("rowSet: " + i + " repeat: " + num);
                    return false;
                }
                rowSet.add(num);
                rowMap.put(i, rowSet);

                // col
                Set<Integer> colSet = colMap.getOrDefault(j, new HashSet<>());
                if(colSet.contains(num)){
                    System.out.println("colSet: " + i + " repeat: " + num);
                    return false;
                }
                colSet.add(num);
                colMap.put(j, colSet);

                // block
                int blockNum = (i/3) * 3 + j / 3;
                Set<Integer> blockSet = colMap.getOrDefault(blockNum, new HashSet<>());
                if(blockSet.contains(num)){
                    System.out.println("blockSet: " + i + " repeat: " + num);
                    return false;
                }
                blockSet.add(num);
                blockMap.put(blockNum, colSet);




            }
        }
        return true;

    }
}
