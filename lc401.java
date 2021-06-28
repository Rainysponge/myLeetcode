package LC;

import java.util.ArrayList;
import java.util.List;

public class lc401 {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> res = new ArrayList<>();
        for(int i=0; i<12; i++){
            for(int j=0; j<60; j++){
                if(Integer.bitCount(i) + Integer.bitCount(j) == turnedOn){
                    String hour;
                    String minute;
                    hour = String.valueOf(i);
                    if(j < 10){
                        minute = '0' + String.valueOf(j);
                    }else{
                        minute = String.valueOf(j);
                    }

                    res.add(hour + ':'+ minute);
                }
            }
        }
        return res;
    }
}
