package LC;
import java.util.*;


public class lc90 {
    List<Integer> t = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for(int mask=0; mask<(1<<n);mask++){
            t.clear();
            boolean flag = true;
            for(int i=0;i<n;i++){
//                if ((mask & (1 << i)) != 0) {
//                    if (i > 0 && (mask >> (i - 1) & 1) == 0 && nums[i] == nums[i - 1]) {
//                        flag = false;
//                        break;
//                    }
//                    t.add(nums[i]);
//                }

                if((mask & (1<<i)) !=0){
                    if(i>0 && (mask>>(i-1)&1)==0 && nums[i]==nums[i-1]){
                        flag = false;
                        break;
                    }
                    t.add(nums[i]);
                }
                if(flag){
                    ans.add(new ArrayList<Integer>(t));
                }


            }
        }
        return ans;

    }
}
