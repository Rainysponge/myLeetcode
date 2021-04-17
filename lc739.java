package LC;
//请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，
// 至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用0 来代替。
//
//例如，给定一个列表temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，
// 你的输出应该是[1, 1, 4, 2, 1, 1, 0, 0]。

import java.util.Deque;
import java.util.LinkedList;

public class lc739 {
    public int[] dailyTemperatures(int[] T) {
        // 单调栈 单调小
        //73, 74, 75, 71, 69, 72, 76, 73
        Deque<Integer> stack = new LinkedList<>();

        int N = T.length;
        int[] res = new int[N];
        for(int i=0; i<N; i++){

            while(!stack.isEmpty() && T[i] > T[stack.peek()]){
                int index = stack.pop();
                res[index] += i-index;

            }

//            for(int each: res){
//                System.out.print(each + " ");
//            }
//            System.out.println("");

            stack.push(i);
        }

        return res;



    }
}
