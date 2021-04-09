package LC;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class lc1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hash_table = new HashMap<Integer, Integer>();
        for(int i=0;i<nums.length;i++){
            if(hash_table.containsKey(target - nums[i])){
                return new int[] {hash_table.get(target - nums[i]), i};


            }
            hash_table.put(nums[i], i);
//            System.out.println(hash_table.get());
        }
        return new int[0];
    }
}
