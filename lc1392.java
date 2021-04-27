package LC;

public class lc1392 {
    public String longestPrefix(String s) {
        // KMP
        int N = s.length();
        int[] KMP = new int[N];
        KMP[0] = -1;

        for(int i=1; i<N; i++){
            int index = KMP[i-1] + 1;
            boolean flag = false;
            while(index>0){
                if(s.charAt(i)==s.charAt(index)){
                    KMP[i] = index;
                    flag = true;
                    break;
                }else{
                    index = KMP[index-1] + 1;
                }

            }
            if(!flag){
                if(s.charAt(i)==s.charAt(0)){
                    KMP[i] = 0;
                }else{
                    KMP[i] = -1;
                }
            }

        }
//        for(int a: KMP){
//            System.out.print(a+" ");
//        }
//        System.out.print(s.substring(0, KMP[N-1] + 1));
        return s.substring(0, KMP[N-1] + 1);

    }
}
