public class lc2024 {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        return Math.max(helper(answerKey, k, 'T'), helper(answerKey, k, 'F'));
    }

    int helper(String answerKey, int k, char key){
        int left=0;
        int res = 0;
        int sum = 0;
        for (int right=0; right < answerKey.length(); right++){
            if (answerKey.charAt(right) != key){
                sum++;
            }
            while (sum > k){
                if (answerKey.charAt(left) != key){
                    sum--;
                }
                left++;
            }
            res = Math.max(res, right - left + 1);
        }

        return res;
    }
}
