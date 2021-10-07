package LC;

public class lc1535 {
    public int getWinner(int[] arr, int k) {

        int N = arr.length;
        int i = 0;
        while(i<N){

            int turn = 0;
            int count = i == 0 ? 0 : 1;
            if(count == k || count == N-1) return arr[i];
            int index = i;
            while(++turn < N){
                index = (i + turn) % N;

                if(arr[i] > arr[index]){
                    count++;
                    if(count == k || count == N-1){
                        return arr[i];
                    }
                }else{
                    break;
                }
            }
            i = index;
        }

        return -1;

    }
}
