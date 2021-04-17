package LC;
//给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
public class lc96 {
    public int numTrees(int n) {
        // 第一反应 递归
        // 题解 dp
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;

        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];


    }
}
