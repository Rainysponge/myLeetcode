import java.util.ArrayList;
import java.util.Arrays;

public class lc3011 {
    public boolean canSortArray(int[] nums) {
        int n = nums.length;
        int tmp_num = ones_number(nums[0]);
        ArrayList<int[]> subNumList = new ArrayList<>();
        int cur = 0;
        for (int i=1; i<n; i++){
            if (tmp_num != ones_number(nums[i])){
                subNumList.add(new int[] {cur, i-1});
                tmp_num = ones_number(nums[i]);
                cur = i;
            }
        }
        subNumList.add(new int[] {cur, n-1});
        int count = subNumList.size();
        int[] maxNum = new int[count];
        int[] minNum = new int[count];
        Arrays.fill(maxNum, -1);
        Arrays.fill(minNum, 1024);

        for (int i = 0; i < count; i++) {
            int[] subNumIndex = subNumList.get(i);
            if (subNumIndex[0] == subNumIndex[1]){
                maxNum[i] = nums[subNumIndex[0]];
                minNum[i] = nums[subNumIndex[0]];
                continue;
            }
            for (int j=subNumIndex[0]; j<=subNumIndex[1]; j++){
                if (maxNum[i] < nums[j]){
                    maxNum[i] = nums[j];
                }
                if (minNum[i] > nums[j]){
                    minNum[i] = nums[j];
                }

            }
        }
        for (int i = 0; i < maxNum.length-1; i++){
            if(maxNum[i] > minNum[i+1]){
                return false;
            }
        }
        return true;

    }

    int ones_number(int num){
        int res = 0;
        while (num > 0){
            if (num % 2 == 1){
                res++;
            }
            num = num >> 1;
        }

        return res;
    }
}
