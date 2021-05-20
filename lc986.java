package LC;

import java.util.ArrayList;
import java.util.List;

public class lc986 {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> res = new ArrayList<>();
        int i=0, j = 0;
        while(i < firstList.length && j < secondList.length){
            int low = Math.max(firstList[i][0], secondList[j][0]);
            int high = Math.min(secondList[j][1], firstList[i][1]);

            if(low <= high){
                res.add(new int[]{low, high});
            }
            if(firstList[i][1] < secondList[j][1]){
                i++;
            }else{
                j++;
            }

        }
        return res.toArray(new int[res.size()][]);

    }
}
