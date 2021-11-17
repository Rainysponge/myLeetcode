package LC;

// import java.util.ArrayList;
// import java.util.HashMap;
// import java.util.List;
// import java.util.Map;

public class lc299 {
    public String getHint(String secret, String guess) {
//        Map<Character, List<Integer>> pMap = new HashMap<>();
//        Map<Character, Integer> cMap = new HashMap<>();
//        int N = secret.length();
//        for(int i=0; i<N; i++){
//            char c = secret.charAt(i);
//            cMap.put(c, cMap.getOrDefault(c, 0) + 1);
//            List<Integer> tmp = pMap.getOrDefault(c, new ArrayList<>());
//            tmp.add(i);
//            pMap.put(c, tmp);
//
//        }
//
//        int A = 0, B = 0;
//        for(int i=0; i<N; i++){
//            char c = guess.charAt(i);
//            if(cMap.containsKey(c) && cMap.get(c) > 0){
//                cMap.put(c, cMap.get(c)-1);
//                // B++
//                List<Integer> tmp = pMap.get(c);
//                if(tmp.contains(i)){
//                    A++;
//                }else {
//                    B++;
//                }
//
//
//            }
//        }
//
//        return A + "A" + B + "B";
        int bulls = 0;
        int[] cntS = new int[10];
        int[] cntG = new int[10];
        for (int i = 0; i < secret.length(); ++i) {
            if (secret.charAt(i) == guess.charAt(i)) {
                ++bulls;
            } else {
                ++cntS[secret.charAt(i) - '0'];
                ++cntG[guess.charAt(i) - '0'];
            }
        }
        int cows = 0;
        for (int i = 0; i < 10; ++i) {
            cows += Math.min(cntS[i], cntG[i]);
        }
        return Integer.toString(bulls) + "A" + Integer.toString(cows) + "B";


    }
}
