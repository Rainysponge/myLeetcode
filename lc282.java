package LC;

import java.util.ArrayList;
import java.util.List;

public class lc282 {
    List<String> res = new ArrayList<>();

    int n;
    String num;
    int target;

    public List<String> addOperators(String num, int target) {
        this.n = num.length();
        this.num = num;
        this.target = target;
        StringBuffer expr = new StringBuffer();
        backtrack(expr, 0, 0, 0);
        return res;
    }

    void backtrack(StringBuffer expr, int index, long ans, long mul ){
        if(index == n){
            if(ans == target){
                res.add(expr.toString());

            }
            return;
        }
        int signIndex = expr.length();
        if (index > 0) {
            expr.append(0); // 占位，下面填充符号
        }
        long val = 0;
        for (int j = index; j < n && (j == index || num.charAt(index) != '0'); ++j) {
            val = val * 10 + num.charAt(j) - '0';
            expr.append(num.charAt(j));
            if (index == 0) { // 表达式开头不能添加符号
                backtrack(expr, j + 1, val, val);
            } else { // 枚举符号
                expr.setCharAt(signIndex, '+');
                backtrack(expr, j + 1, ans + val, val);
                expr.setCharAt(signIndex, '-');
                backtrack(expr, j + 1, ans - val, -val);
                expr.setCharAt(signIndex, '*');
                backtrack(expr, j + 1, ans - mul + mul * val, mul * val);
            }
        }
        expr.setLength(signIndex);



    }
}
