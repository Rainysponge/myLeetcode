import java.util.Set;
import java.util.TreeSet;

public class lc1796 {
    public int secondHighest(String s) {
        Set<Integer> res = new TreeSet<>();
        int N = s.length();
        for(int i=0; i<N; i++){
            if(Character.isDigit(s.charAt(i))){
                res.add(s.charAt(i) - '0');
            }
        }
        if(res.size() < 2) return -1;
        else return (int) res.toArray()[res.size()-2];
    }
}
