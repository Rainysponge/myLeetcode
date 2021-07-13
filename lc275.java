package LC;

public class lc275 {
    public int hIndex(int[] citations) {
        int res = 0;
        for(int i=citations.length-1; i>=0; i--){
            if(citations[i] > res) res++;
            else break;
        }


        return res;
    }
}
