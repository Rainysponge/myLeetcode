import java.util.*;

public class lc2766 {
    public List<Integer> relocateMarbles(int[] nums, int[] moveFrom, int[] moveTo) {
        List<Integer> res = new ArrayList<>();

        Map<Integer, Boolean> pos_map = new HashMap<>();

        for (int num : nums) {
            pos_map.put(num, true);
        }

        for (int i = 0; i < moveFrom.length; i++) {
            pos_map.remove(moveFrom[i]);
            pos_map.put(moveTo[i], true);
        }



        for (Map.Entry<Integer, Boolean> entry : pos_map.entrySet()) {
            res.add(entry.getKey());
        }
        Collections.sort(res);

        return res;
    }
}
