package LC;

public class lc322 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        dp[0] = 0;

        for(int i=1; i<=amount; i++){
            //init
            dp[i] = Integer.MAX_VALUE;
        }
        for(int i=1; i<=amount; i++){
            for (int coin : coins) {
                if (i - coin >= 0 && dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i-coin] + 1);
                }
            }
        }
        for(int i=1; i<=amount; i++){
            System.out.print(dp[i] + "\t");
        }
        System.out.println("");
        if(dp[amount]!=Integer.MAX_VALUE) return dp[amount];
        else return -1;
    }
}
