package LC;


public class lc75 {
    public void sortColors(int[] nums) {
        int right = -1, left = nums.length;
        int i = 0;
        while(i<left){
            if(nums[i]==1){
                i++;
            }else if(nums[i]==0){
                right++;
                swap(nums, right, i);
                i++;
            }else{
                left--;
                swap(nums, left, i);
            }
        }
    }
    public  void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
//        这里不考虑下标越界
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
