package LC;

import java.util.Arrays;
// import java.util.Collections;

public class lc453 {
    public int minMoves(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int min = Integer.MAX_VALUE / 2;
        for(int i: nums){
            if(min > i){
                min = i;
            }
        }
        return sum - nums.length * min;


    }
}
