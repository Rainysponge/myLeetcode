package LC;

import java.util.Scanner;

public class CFB0613 {
    public int Solution(){
        Scanner scanner = new Scanner(System.in);
        int n, m, k;
        n = scanner.nextInt();
        m = scanner.nextInt();
        k = scanner.nextInt();
        System.out.println(n +" "+m+" "+k);
        int end = n*m;
        int begin = 1;
        int mid = (end + begin) >> 1;
        while (begin < end){
            if(check(n, m, mid, k)){
                begin = mid+1;
            }else{
                end = mid;
            }
            mid = (begin + end) >> 1;
        }
        System.out.println(mid);
        return 0;
    }

    boolean check(int n, int m,int mid, int k){
        int row = 1;
        int t = 0;
        while(row <= n && row <= mid){
            if(row*m <= mid){
                t += m;
            }else{
                t += mid / row;
            }

            row++;
        }
        return k > t;

    }
}
