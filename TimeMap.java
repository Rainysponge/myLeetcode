package LC;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TimeMap {
    HashMap<String, List<String>> map;
    HashMap<String, List<Integer>> ListMap;
    public TimeMap() {
        map = new HashMap<>();
        ListMap = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if(map.containsKey(key)){
            map.get(key).add(value);
            ListMap.get(key).add(timestamp);  // 更新时间
        }else{
            List<String> vList = new ArrayList<>();
            vList.add(value);
            map.put(key, vList);
            List<Integer> list = new ArrayList<>();
            list.add(timestamp);
            ListMap.put(key, list);
        }
    }

    public String get(String key, int timestamp) {
        List<String> vList = map.get(key);
        List<Integer> tList = ListMap.get(key);
        if(!map.containsKey(key) || timestamp< tList.get(0)){
            return "";
        }


        int N = tList.size();
        int left = 0, right = N - 1;
        while(left < right){
            int mid = (left + right) / 2;
            if(tList.get(mid) == timestamp){
                left = mid;
                break;
            }else if(tList.get(mid) < timestamp){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        if(tList.get(left) > timestamp){
            left--;
        }

        return vList.get(left);



    }
}
