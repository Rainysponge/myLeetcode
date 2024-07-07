import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc3101 {
    public long countAlternatingSubarrays(int[] nums) {
        int res = 1;
        int cur = 0;
        int n = nums.length;
        for(int i=1; i<n; i++){
            if(nums[i] == nums[i-1]){
                cur = i-1;
                res++;
            }else{
                res += i - cur + 1;
            }
        }
        return res;
    }
}
