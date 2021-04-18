package LC;
//给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
//
//不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。

public class lc26 {
    public int removeDuplicates(int[] nums) {
        int pre = 0; // 指向无重复数组队尾
//        int curVal = 0;
        int l = nums.length;
        if(l<=1){
            return l;
        }

        // 双指针
        int cur = pre + 1;
        // 指向被对比的元素

        for(int i=1; i<l; i++){
            if(nums[i] != nums[pre]){
                nums[pre+1] = nums[i];  // 替换
                pre++;
            }
        }
        return pre+1;




    }
}
