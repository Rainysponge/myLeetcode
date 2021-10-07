package LC;

import java.util.Arrays;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class lc954 {
    public boolean canReorderDoubled(int[] arr) {
//        arrays.sort(arr);
//        int N = arr.length;
//
//        Map<Integer, Integer> map = new HashMap<>();
//
//        for (int j : arr) {
//            map.put(j, map.getOrDefault(j, 0) + 1);
//        }
//
//
//        for(int i=0; i<N; i++){
//            // 取出当前最小值
//          if(map.get(arr[i]) > 0){
//              int a = arr[i];
//              if(map.containsKey(arr[i]*2) && map.get(arr[i]*2) > 0){
//                  // 配对
//                  map.put(arr[i], map.get(arr[i])-1);
//                  map.put(arr[i]*2, map.get(arr[i]*2)-1);
//              }else{
//                  return false;
//              }
//          }
//        }
//
//        return true;


        Map<Integer, Integer> count = new HashMap<>();
        for (int x: arr)
            count.put(x, count.getOrDefault(x, 0) + 1);

        // B = A as Integer[], sorted by absolute value
        Integer[] B = new Integer[arr.length];
        for (int i = 0; i < arr.length; ++i)
            B[i] = arr[i];
        Arrays.sort(B, Comparator.comparingInt(Math::abs));

        for (int x: B) {
            // If this can't be consumed, skip
            if (count.get(x) == 0) continue;
            // If this doesn't have a doubled partner, the answer is false
            if (count.getOrDefault(2*x, 0) <= 0) return false;

            // Write x, 2*x
            count.put(x, count.get(x) - 1);
            count.put(2*x, count.get(2*x) - 1);
        }

        // If we have written everything, the answer is true
        return true;

    }
}
