package LC;
import java.util.*;

public class lc218 {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        int N = buildings.length;
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b)->b[1]-a[1]);
        // 存入的是[buildings[i][1], buildings[i][2]]
        List<Integer> boundaries = new ArrayList<>();
        for(int[] building: buildings){
            boundaries.add(building[0]);
            boundaries.add(building[1]);
        }
        Collections.sort(boundaries);  // 边界


        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int index = 0;
        for(int boundary: boundaries){
            while(index < N && buildings[index][0] <= boundary){
                // 一次遍历，将左边界小于当前的坐标指针的building加入堆中
                heap.offer(new int[]{buildings[index][1], buildings[index][2]});
                index++;
                // 不回头
            }
            while(!heap.isEmpty() && heap.peek()[0] <= boundary){
                // 如果右边界已经小于或等于当前位置则在堆中删去该建筑

                heap.poll();
            }

            int max = heap.isEmpty() ? 0 : heap.peek()[1];
            if(res.size() == 0 || max != res.get(res.size()-1).get(1)){
                res.add(Arrays.asList(boundary, max));
            }
        }
        return res;

    }
}
