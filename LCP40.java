import java.util.Arrays;
import java.util.Comparator;

public class LCP40 {
    public int maxmiumScore(int[] cards, int cnt) {
        Arrays.sort(cards);

        int ans = 0;
        int tmp = 0;
        int odd = -1, even = -1;
        int end = cards.length - cnt;
        for (int i = cards.length - 1; i >= end; i--) {
            tmp += cards[i];
            if ((cards[i] & 1) != 0) {
                odd = cards[i];
            } else {
                even = cards[i];
            }
        }

        if ((tmp & 1) == 0) {
            return tmp;
        }

        for (int i = cards.length - cnt - 1; i >= 0; i--) {
            if ((cards[i] & 1) != 0) {
                if (even != -1) {
                    ans = Math.max(ans, tmp - even + cards[i]);
                    break;
                }
            }
        }

        for (int i = cards.length - cnt - 1; i >= 0; i--) {
            if ((cards[i] & 1) == 0) {
                if (odd != -1) {
                    ans = Math.max(ans, tmp - odd + cards[i]);
                    break;
                }
            }
        }

        return ans;

    }
}
