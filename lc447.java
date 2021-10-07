package LC;

public class lc447 {
    public int totalHammingDistance(int[] nums) {
//        int m = nums.length;
//        String[] binNums = new String[m];
//        int res = 0;
//        int index = 0;
//        for(int num : nums){
//            StringBuilder sb = new StringBuilder();
//            for(int i=32; i>=0; i--){
//                double del = Math.pow(2, i);
//                if(num >= del){
//                    sb.append("1");
//                    num -= del;
//                }else{
//                    sb.append("0");
//                }
//            }
//            binNums[index++] = sb.toString();
//            System.out.println(sb.toString());
//        }
//
//        for(int i=0; i<m; i++){
//            for(int j=i+1; j<m; j++){
//
//                for(int k=0; k<33; k++){
//                    if(binNums[i].charAt(k) != binNums[j].charAt(k)){
////                        System.out.println(i + " "  + j + " " + k);
//                        res++;
//                    }
//                }
//
//
//            }
//        }
//
//
//        return res;
        int ans = 0, n = nums.length;
        for (int i = 0; i < 30; ++i) {
            int c = 0;
            for (int val : nums) {
                c += (val >> i) & 1;
            }
            ans += c * (n - c);
        }
        return ans;

    }
}
