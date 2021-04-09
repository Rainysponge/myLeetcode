package LC;

public class lc62 {
    public int uniquePaths(int m, int n) {
        int[][] a = new int[m][n];
        if(m<=0 || n<=0) return 0;
        for(int i=0;i<a.length;i++){
            a[i][0] = 1;
        }
        for(int i=0;i<a[0].length;i++){
            a[0][i] = 1;
        }

        for(int i=1;i<a.length;i++){
            for(int j=1;j<a[0].length;j++){
                a[i][j] = a[i-1][j] + a[i][j-1];
            }
        }

        return a[m-1][n-1];
    }
}
