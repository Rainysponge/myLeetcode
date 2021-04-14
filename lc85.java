package LC;

public class lc85 {
//    给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积
    public int maximalRectangle(char[][] matrix) {


        if(matrix==null||matrix[0] == null){
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] width = new int[m][n];
        int[][] s = new int[m][n];
        int[][] lList = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(j==0) {
                    if(matrix[i][j]=='1'){
                        width[i][j] = 1;
                    }else{
                        width[i][j] = 0;
                    }
                }
                else{
                    if(matrix[i][j]=='1'){
                        width[i][j] = width[i][j-1] + 1;
                    }else{
                        width[i][j] = 0;
                    }

                }
            }
        }
        System.out.println("W");
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                System.out.printf("%d\t", width[i][j]);
            }
            System.out.println("");
        }

//        1	0	1	0	0
//        1	0	1	2	3
//        1	2	3	4	5
//        1	0	0	1	0
        int index = m-1;
        int res = 0;

        for(int j=n-1;j>=0;j--){
            int l = 1;
            int w = Integer.MAX_VALUE;
            for(int i=index;i>=0;i--){
                if(width[i][j]==0){
                    l = 1;
                    s[i][j] = 0;
                    lList[i][j] = l;
                    continue;
                }
                if(l>1){
//                        if(width[i][j]>w){
//                            if(width[i][j]>w*l){
//                                w
//                            }
//                        }
                        w = Math.min(width[i][j], w);

                }else{
                    w = width[i][j];
                }
                s[i][j] = w*l;
                lList[i][j] = l;
                res = Math.max(res, w*l);

                l++;
            }


        }
        System.out.println("S");
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                System.out.printf("%d\t",s[i][j]);
            }
            System.out.println("");
        }
        System.out.println("L:");
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                System.out.printf("%d\t",lList[i][j]);
            }
            System.out.println("");
        }


        return res;



    }
}
