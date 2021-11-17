package LC;

public class lc273 {
    String[] singles = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    String[] teens = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    String[] thousands = {"", "Thousand", "Million", "Billion"};

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 3, unit = 1000000000; i >= 0; i--, unit /= 1000) {
            int curNum = num / unit;
            if (curNum != 0) {
                num -= curNum * unit;
                StringBuffer curr = new StringBuffer();
                recursion(curr, curNum);
                curr.append(thousands[i]).append(" ");
                sb.append(curr);
            }
        }
        return sb.toString().trim();

    }

    void recursion(StringBuffer curr, int curNum){


        if(curNum < 10){
            curr.append(singles[curNum]).append(" ");
        }else if(curNum < 20){
            curr.append(teens[curNum - 10]).append(" ");
        }else if(curNum < 100){
            curr.append(tens[curNum / 10]).append(" ");
            recursion(curr, curNum % 10);
        }else {
            curr.append(singles[curNum / 100]).append(" Hundred ");
            recursion(curr, curNum % 100);
        }



    }




}
