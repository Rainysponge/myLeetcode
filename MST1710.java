package LC;

public class MST1710 {
    public int majorityElement(int[] nums) {
        int N = nums.length;
        int counter = 1;
        // int res = -1;
        int cur = nums[0];
        for(int i=1; i<N; i++){
            if(counter == 0){
                cur = nums[i];
                counter++;
                continue;
            }

            if(nums[i] == cur){
                counter++;
            }else{
                counter--;

            }
        }

        if(counter<=0) return -1;
        counter = 0;
        for (int num : nums) {
            if (cur == num) {
                counter++;
            }
        }

        if(counter<=N/2) return -1;

        return cur;

    }
}
