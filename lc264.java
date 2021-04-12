package LC;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

//给你一个整数 n ，请你找出并返回第 n 个 丑数 。
public class lc264 {
    public int nthUglyNumber(int n) {
        //最小堆 有直接可用的数据结构确实方便， 但不知道笔试有没有
//        int[] factors = {2, 3, 5};
//        Set<Long> seen = new HashSet<Long>();
//        PriorityQueue<Long> heap = new PriorityQueue<Long>();
//        seen.add(1L);
//        heap.offer(1L);
//        int ugly = 0;
//        for(int i=0; i<n; i++){
//            long cur = heap.poll();
//            ugly = (int)cur;
//            for(int each:factors){
//                long tmp = each * cur;
//                if(seen.add(tmp)){
//                    heap.add(tmp);
//                }
//            }
//        }
//        return ugly;

        int[] dp = new int[n+1];
        dp[1] = 1;
        int ptr2 = 1, ptr3 = 1, ptr5 = 1;
        for(int i=2;i<=n;i++){
            int num2 = dp[ptr2] * 2, num3 = dp[ptr3] * 3, num5 = dp[ptr5] * 5;
            dp[i] = Math.min(num2, Math.min(num3, num5));
            if(num2==dp[i]){
                ptr2++;
            }
            if(num3==dp[i]){
                ptr3++;
            }
            if(num5==dp[i]){
                ptr5++;
            }
        }
        for(int each:dp){
            System.out.printf("%d\t",each);
        }
        return dp[n];


    }

}
