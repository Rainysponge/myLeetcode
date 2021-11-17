package LC;

import java.util.*;

public class SummaryRanges {
    List<Integer> list = new ArrayList<>();
    Set<Integer> set = new HashSet<>();

    public SummaryRanges() {

    }

    public void addNum(int val) {
        if(set.contains(val)){
            return;
        }
        list.add(val);
        set.add(val);
        list.sort((o1, o2) -> o2 - o1);
    }

    public int[][] getIntervals() {
        List<int[]> res = new ArrayList<>();
        int N = list.size();
        int pre = list.get(0);
        int after = list.get(0);

        if(list.size() == 1){
            return new int[][]{{pre, after}};
        }

        for(int i = 1; i<N; i++){
            if(after == list.get(i) - 1){
                after++;

            }else{
                int[] tmp = new int[]{pre, after};
                res.add(tmp);
                pre = list.get(i);
                after = pre;

            }
            if(i == N - 1){
                int[] tmp = new int[]{pre, after};
                res.add(tmp);
            }
        }
        int[][] resT = new int[res.size()][2];
        for(int i=0; i<res.size(); i++){
            resT[i][0] = res.get(i)[0];
            resT[i][1] = res.get(i)[1];
        }
        return resT;
//        return (int[][]) res.toArray();
    }
}
