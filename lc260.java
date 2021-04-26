package LC;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class lc260 {
    //给定一个整数数组 nums，其中恰好有两个元素只出现一次，
    // 其余所有元素均出现两次。 找出只出现一次的那两个元素。
    // 你可以按 任意顺序 返回答案。
    public int[] singleNumber(int[] nums) {
        // 啥也不管 hash 先ac了再说 0.08 0.07
        Map<Integer, Integer> hashTable = new HashMap<>();
        for(int each: nums){
            hashTable.put(each, hashTable.getOrDefault(each, 0) + 1);
        }

        List<Integer> res = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry :hashTable.entrySet()) {
            int val = entry.getValue();
            if(val==1){
                res.add(entry.getKey());
            }
        }

        return res.stream().mapToInt(Integer::valueOf).toArray();

        // Sort O(nlogn)

        // bits 太难了。。








    }
}
