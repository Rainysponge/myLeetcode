package LC;

import java.util.LinkedList;
import java.util.PriorityQueue;

public class lc1354 {
    public boolean isPossible(int[] target) {
        long sum = 0;
        PriorityQueue<Long> queue = new PriorityQueue<Long>((o1, o2) -> o2.compareTo(o1));
        for (int i: target) {
            sum += i;
            queue.offer((long)i);
        }
        long k;
        while (!queue.isEmpty() && queue.peek() != 1L) {
            k = queue.poll();
            sum -= k;
            k -= sum;
            sum += k;
            if (k < 1) {
                return false;
            }
            queue.offer(k);
        }
        return true;
    }
}
