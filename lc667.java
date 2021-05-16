package LC;

public class lc667 {
    public int[] constructArray(int n, int k) {
        int[] res = new int[n];

        // 第 1 步：构造等差数列，把 1 到 n - k - 1 赋值结果数组的前面
        for (int i = 0; i < n - k - 1; i++) {
            res[i] = i + 1;
        }

        // 第 2 步：构造交错数列，下标从 n - k - 1 开始，数值从 n - k 开始
        // 控制交错的变量
        int j = 0;

        int left = n - k;
        int right = n;
        for (int i = n - k - 1; i < n; i++) {
            if (j % 2 == 0) {
                res[i] = left;
                left++;
            } else {
                res[i] = right;
                right--;
            }
            j++;
        }
        return res;

    }
}
