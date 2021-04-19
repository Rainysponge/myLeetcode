package LC;
// 给你一个数组 nums和一个值 val，你需要 原地 移除所有数值等于val的元素，并返回移除后数组的新长度。
//
// 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
//
// 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
// 0 <= nums.length <= 100
// 0 <= nums[i] <= 50
// 0 <= val <= 100
public class lc27 {
    public int removeElement(int[] nums, int val) {
        // 双指针 无序
        int N = nums.length;
        int head = 0, tail = N - 1;
        if(N==0) return 0;

        while(head<tail){
            if(nums[head]!=val){
                head++;
            }else{
                while(head<tail){
                    if(nums[tail]==val){
                        tail--;
                    }
                }
                nums[head] = nums[tail];
                tail--;
            }


        }
        if(nums[head]==val) return head;
        return head+1;



    }
}
