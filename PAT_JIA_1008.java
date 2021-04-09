package LC;

import java.util.Scanner;

public class PAT_JIA_1008 {
    public void solution(){
        // 读数据
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

//        }


        int floor_now = 0;
        int res = 0;
        for(int i=0;i<N;i++){
            int floor = in.nextInt();
            if((floor-floor_now)>0){
                res += 6 * (floor-floor_now) + 5;
//                System.out.println(res);
            }else{
                res += 4 * (floor_now-floor) + 5;
//                System.out.println(res);
            }
            floor_now = floor;
        }
//        if(floor_now)
        System.out.print(res);


    }
}
