package LC;

public class lc1518 {
    public int numWaterBottles(int numBottles, int numExchange) {
        if(numBottles< numExchange) return numBottles;
        int res = 0;
        while (numBottles>=numExchange){
            int t = numBottles / numExchange;
            res += t*numExchange;
            numBottles += t - t*numExchange;
        }

        return res + numBottles;

    }
}
