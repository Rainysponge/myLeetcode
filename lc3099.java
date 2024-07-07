public class lc3099 {
    public int sumOfTheDigitsOfHarshadNumber(int x) {
        int _sum = 0;
        int tmp_x = x;
        while (tmp_x > 0){
            _sum += tmp_x % 10;
            tmp_x = tmp_x / 10;
        }

        if (x % _sum == 0){
            return _sum;
        }
        return -1;
    }
}
