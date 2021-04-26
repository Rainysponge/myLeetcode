package LC;
//给你一个下标从 0 开始的整数数组 nums和一个整数 k。
//
//一开始你在下标0处。每一步，你最多可以往前跳k步，但你不能跳出数组的边界。也就是说，你可以从下标 i 跳到 [i + 1， min(n - 1, i + k)] 包含 两个端点的任意位置。
//
//你的目标是到达数组最后一个位置（下标为 n - 1），你的 得分为经过的所有数字之和。
//
//请你返回你能得到的 最大得分。

import java.util.PriorityQueue;
import java.util.Queue;

public class lc1696 {
    public int maxResult(int[] nums, int k) {
        int len = nums.length;
        Queue<int[]> queue = new PriorityQueue<>((o1, o2) -> o2[0] - o1[0]);
        queue.offer(new int[]{nums[0], 0});
        int res = nums[0];
        for (int i = 1; i < len; i++) {
            while (i - queue.peek()[1] > k){
                queue.poll();
            }
            res = queue.peek()[0] + nums[i];
            queue.offer(new int[]{res, i});
        }
        return res;


    }
}
