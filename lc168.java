package LC;

public class lc168 {
    public String convertToTitle(int columnNumber) {
        StringBuilder res = new StringBuilder();
        while (columnNumber>0){
            int t = columnNumber % 26;
            if(t == 0){
                res.insert(0, 'Z');
            }else{
                res.insert(0, (char)('A' + t));
            }
            columnNumber /= 26;
        }
        return res.toString();

    }
}
