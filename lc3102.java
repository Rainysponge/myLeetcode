import java.util.TreeMap;

public class lc3102 {
    public int minimumDistance(int[][] points) {
        TreeMap<Integer, Integer> sx = new TreeMap<>();
        TreeMap<Integer, Integer> sy = new TreeMap<>();
        for (int[] p: points){
            sx.put(p[0] - p[1], sx.getOrDefault(p[0] - p[1], 0) + 1);
            sy.put(p[0] + p[1], sy.getOrDefault(p[0] + p[1], 0) + 1);
        }
        int res = Integer.MAX_VALUE;
        for (int[] p : points){
            sx.put(p[0] - p[1], sx.get(p[0]-p[1]) - 1);
            if (sx.get(p[0] - p[1]) == 0){
                sx.remove(p[0] - p[1]);
            }
            sy.put(p[0] + p[1], sy.get(p[0] + p[1]) - 1);
            if (sy.get(p[0] + p[1]) == 0){
                sy.remove(p[0] + p[1]);
            }
            res = Math.min(res, Math.max(sx.lastKey() - sx.firstKey(), sy.lastKey() - sy.firstKey()));
            sx.put(p[0] - p[1], sx.getOrDefault(p[0]-p[1], 0) + 1);
            sy.put(p[0] + p[1], sy.getOrDefault(p[0] + p[1], 0) + 1);
        }
        return res;
    }
}
