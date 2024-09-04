import java.util.Arrays;
import java.util.Collections;

public class lc2974 {
    public int[] numberGame(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] res = new int[n];
        for (int i=0; i<n; i+=2){
            res[i] = nums[i+1];
            res[i+1] = nums[i];
        }
        return res;
    }
}
