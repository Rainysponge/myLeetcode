package LC;

public class lc915 {
    public int partitionDisjoint(int[] A) {
        int N = A.length;
        int[] leftMax = new int[N];
        int[] rightMin = new int[N];
        int t = A[0];
        leftMax[0] = A[0];
        for(int i=0; i<N; i++){
            leftMax[i] = Math.max(t, A[i]);
            t = leftMax[i];
        }

        t = A[N-1];
        for(int i=N-1; i>=0; i--){
            rightMin[i] = Math.min(t, A[i]);
            t = rightMin[i];
        }


        for(int each: leftMax){
            System.out.print(each + " ");
        }
        System.out.println("");
        for(int each: rightMin){
            System.out.print(each + " ");
        }
        System.out.println("");

        int i = 1;
        for(; i<N; i++){
            if(leftMax[i-1]<=rightMin[i]){
                return i;
            }
        }

        return 0;

    }

}
