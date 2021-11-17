package LC;

public class lc38 {
    public String countAndSay(int n) {

        String res = "1";
        while(n-- > 1){
            StringBuilder sb = new StringBuilder();

            char[] s1 = res.toCharArray();
            char pre = s1[0];
            int count = 1;
            for(int i=1; i<s1.length; i++){
                if(pre != s1[i]){
                    sb.append(count);
                    sb.append(pre);
                    count = 1;
                    pre = s1[i];

//                    System.out.println(sb.toString());
                }else{
                    count++;
                }
            }

            sb.append(count);
            sb.append(pre);
            res = sb.toString();
        }
        return res;

    }
}
