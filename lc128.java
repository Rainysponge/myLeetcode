package LC;

import java.util.HashSet;
import java.util.Set;

public class lc128 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> hashTable = new HashSet<Integer>();
        for(int num:nums){
            hashTable.add(num); // 去重
        }
        int res = 0;
        for(int i=0; i<nums.length; i++){
            if(!hashTable.contains(nums[i]-1)){
                int curLong = 1;
                int curNum = nums[1];
                while(hashTable.contains(curNum+1)){
                    curNum++;
                    curLong++;
                }
                res = Math.max(res, curLong);
            }

        }
        return res;

    }
}
