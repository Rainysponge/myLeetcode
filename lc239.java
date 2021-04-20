package LC;

import java.util.Comparator;
import java.util.PriorityQueue;

public class lc239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // 最大堆  winLeft越过的数字如果是一个“最大值”，则从堆中删除，否则，暂时留在堆中

        int n = nums.length;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] pair1, int[] pair2) {
                return pair1[0] != pair2[0] ? pair2[0] - pair1[0] : pair2[1] - pair1[1];
            }
        });
        for (int i = 0; i < k; ++i) {
            pq.offer(new int[]{nums[i], i});
        }
        int[] ans = new int[n - k + 1];
        ans[0] = pq.peek()[0];
        for (int i = k; i < n; ++i) {
            pq.offer(new int[]{nums[i], i});
            while (pq.peek()[1] <= i - k) {
                pq.poll();  // 删除所有下标在窗口外的的数(由于i++导致的和先前滞留在堆中的)
            }
            ans[i - k + 1] = pq.peek()[0];
        }
        return ans;



    }

    private int subMax(int[] nums, int l, int r){
        int res = -Integer.MAX_VALUE;
        for(int i=l; i<=r; i++){
            if(res<nums[i]) res = nums[i];
        }
        return res;
    }
}
