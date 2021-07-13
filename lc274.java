package LC;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class lc274 {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);

        int i = 0;
        while (i<citations.length && citations[citations.length-1-i] > i){
            i++;
        }

        return i;
//        for(int i=0; i<N; i++)
    }


}



