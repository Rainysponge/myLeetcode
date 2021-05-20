package LC;

import java.util.*;

public class lc692 {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> dic = new HashMap<>();
        Map<String, Integer> indexDic = new HashMap<>();
        int index = 0;
        for(String each: words){
            dic.put(each, dic.getOrDefault(each, 0) + 1);
            if(!indexDic.containsKey(each)){
                indexDic.put(each, index++);
            }
        }
        List<String> res = new ArrayList<>();
        for(Map.Entry entry:dic.entrySet()){
            res.add((String) entry.getKey());
        }
        res.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(dic.get(o2) - dic.get(o1)!=0){
                    return dic.get(o2) - dic.get(o1);
                }else{
                    return o1.compareTo(o2);
                }
            }
        });

        res = res.subList(0, k);

        return res;
    }
}
