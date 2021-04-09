package LC;

public class lc1006 {
//    通常，正整数 n 的阶乘是所有小于或等于 n 的正整数的乘积。
//    例如，factorial(10) = 10 * 9 * 8 * 7 * 6 * 5 * 4 * 3 * 2 * 1。
//    相反，我们设计了一个笨阶乘 clumsy：在整数的递减序列中，
//    我们以一个固定顺序的操作符序列来依次替换原有的乘法操作符：乘法(*)，除法(/)，加法(+)和减法(-)。
//    例如，clumsy(10) = 10 * 9 / 8 + 7 - 6 * 5 / 4 + 3 - 2 * 1。
//    然而，这些运算仍然使用通常的算术运算顺序：我们在任何加、减步骤之前执行所有的乘法和除法步骤，
//    并且按从左到右处理乘法和除法步骤。
//    另外，我们使用的除法是地板除法（floor division），
//    所以 10 * 9 / 8 等于 11。这保证结果是一个整数。
//    实现上面定义的笨函数：给定一个整数 N，它返回 N 的笨阶乘。

    int clumsy(int N) {
        // 生成string
        if(N==1){
            return 1;
        }
        if(N==2){
            return 2;
        }
        if(N==3){
            return 6;
        }
        String[] calculates = new String[]{"*", "/", "+", "-"};
        int turns = N / 4;
        int res = 0;
        for(int i=0;i<turns;i++){
            int tmp = (N - 4*i) * (N - 1 - 4*i) / (N - 2 - 4*i) ;
            if(i==0){
                res += tmp + (N - 3);
            }else {
                res -= tmp - (N - 3 - 4*i);
//                System.out.println(tmp);
            }

        }
//        System.out.println(res);
        int remains = N - turns * 4;
        switch (remains){
            case 1: res -= (N - 4*turns);break;
            case 2: res -= (N - 4*turns)* (N - 1 - 4*turns);break;
            case 3: res -= (N - 4*turns)* (N - 1 - 4*turns) / (N - 2 - 4*turns);break;
            default:break;
        }

        return res;




    }
}
