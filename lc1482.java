package LC;

public class lc1482 {
    public int minDays(int[] bloomDay, int m, int k) {
        int N = bloomDay.length;
        if(k*m>N) return -1;
        int Max = -1, Min = Integer.MAX_VALUE;
        for(int each: bloomDay){
            if(each > Max){
                Max = each;
            }
            if(each < Min){
                Min = each;
            }
        }

        int mid = (Min + Max) / 2;
        while(Min < Max){
            if(check(bloomDay, m, k, mid)){
                Max = mid;
            }else{
                Min = mid + 1;
            }
            mid = (Min + Max) / 2;
        }


        return mid;

    }
    public boolean check(int[] bloomDay, int m, int k, int day){
        int N = bloomDay.length;
        boolean[] bloom = new boolean[N];
        for(int i=0; i<N; i++){
            if(bloomDay[i] <= day ){
                bloom[i] = true;
            }
        }
        int tmpK = 0, tmpM = 0;
        for(int i=0; i<N; i++){
            if(bloom[i]){
                tmpK++;
                if(tmpK==k){
                    // 达到连续
                    tmpK = 0;
                    tmpM++;
                }
            }else{
                tmpK = 0;
            }

        }
//        for(int i=0; i<N; i++){
//            System.out.print(bloom[i] + " ");
//        }
//        System.out.println(tmpM);
        return tmpM == m;
    }
}
