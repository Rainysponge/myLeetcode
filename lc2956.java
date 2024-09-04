import java.util.Arrays;
import java.util.HashMap;

public class lc2956 {
    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();

        for (int num: nums1){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int num: nums2){
            map2.put(num, map2.getOrDefault(num, 0) + 1);
        }

        int[] res = new int[2];
        Arrays.fill(res, 0);
        for (Integer key : map.keySet()) {

            if (map2.containsKey(key)){
                res[0] += map.get(key);
            }
        }

        for (Integer key : map2.keySet()) {

            if (map.containsKey(key)){
                res[1] += map2.get(key);
            }
        }
        return res;

    }
}
