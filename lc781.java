package LC;

import java.util.HashMap;
import java.util.Map;

public class lc781 {
    public int numRabbits(int[] answers) {
        int res = 0;
        Map<Integer, Integer> dic = new HashMap<Integer, Integer>();
        for(int i:answers){
            dic.put(i, dic.getOrDefault(i, 0)+1);
        }

        for (Map.Entry<Integer, Integer> entry : dic.entrySet()){
            int a = entry.getKey(), b = entry.getValue();
            res += (a + b) / (a + 1) * (1 + a);
//            res += entry.getKey()/ entry.getValue();
        }


        System.out.println(res);

        return res;
    }
}
