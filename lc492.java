package LC;

public class lc492 {
    public int[] constructRectangle(int area) {
        int[] res = new int[2];

        for(int i=(int)Math.sqrt(area); i<=area; i++){
            if(area % i == 0){
                res[0] = Math.max(area / i, i);
                res[1] = area / res[0];
                break;
            }
        }
        return res;
    }
}
