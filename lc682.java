import java.util.Stack;
import java.util.regex.Pattern;

public class lc682 {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        for (String operation : operations) {
            if (operation.charAt(0) == '+' && operation.length() == 1) {
                int tmp1 = stack.pop();
                int tmp2 = stack.pop();
                int tmp3 = tmp1 + tmp2;
                stack.push(tmp2);
                stack.push(tmp1);
                stack.push(tmp3);
            } else if (operation.charAt(0) == 'C') {
                stack.pop();
            } else if (operation.charAt(0) == 'D') {
                int tmp = stack.peek();
                tmp *= 2;
                stack.push(tmp);
            } else {
                stack.push(Integer.valueOf(operation));

            }
        }
        int res = 0;
        while(!stack.isEmpty()){
            res += stack.pop();
        }
        return res;
    }

}
