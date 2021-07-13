package LC;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class lc451 {
    Map<Character, Integer> map = new HashMap<>();
    char[] s1;
    int N;
    public String frequencySort(String s) {
        s1 = s.toCharArray();
        N = s1.length;
        int Max = -1;
//        int Min = Integer.MAX_VALUE / 2;
        for(char c: s1){
            int t = map.getOrDefault(c, 0) + 1;
            map.put(c, t);
            Max = Math.max(Max, t);
//            Min = Math.min(Min, t);
        }

        PriorityQueue<Character> heap = new PriorityQueue<Character>(N, new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return map.get(o1) - map.get(o2);
            }
        });

        for(Map.Entry<Character, Integer> entry: map.entrySet()){
            char c = entry.getKey();
            heap.add(c);
        }

        StringBuffer res = new StringBuffer();

        while (!heap.isEmpty()){
            char c = heap.poll();
            int l = map.get(c);
            for(int i=0; i<l; i++){
                res.append(c);
            }
        }

        return res.toString();

//        StringBuffer[] buckets = new StringBuffer[Max+1];
//        for(int i=0; i<=Max; i++){
//            // 初始化
//            buckets[i] = new StringBuffer();
//        }
//
//
//        for(char c: s1){
//            int index = map.get(c);
//            buckets[index].append(c);
//        }
//
//        StringBuffer res = new StringBuffer();
//
//        for(int i=Max; i>=1; i--){
//            int l = buckets[i].length();
//            for(int j=0; j<l; j++){
//                for(int k=0; k<i; k++){
//                    res.append(buckets[i].charAt(j));
//                }
//            }
//        }
//
//        return res.toString();

    }




}
