public class lc1769 {
    public int[] minOperations(String boxes) {
        int N = boxes.length();
        int[] res = new int[N];
        int countOne = 0, countStep = 0;
        for(int i=0; i<N; i++){
            if (boxes.charAt(i) == '1'){
                countOne++;
                countStep += i;
            }
        }
        res[0] = countStep;
        int left = 0, right = countOne;
        for(int i=1; i<N ;i++){
            if (boxes.charAt(i-1) == '1'){
                left++;
                right--;
            }
            res[i] = res[i-1] - right + left;
        }
        return res;
    }
}
