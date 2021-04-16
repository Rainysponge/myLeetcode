package LC;
// 有一个 m x n 的二元网格，其中 1 表示砖块，0 表示空白。砖块 稳定（不会掉落）的前提是：
//
// 一块砖直接连接到网格的顶部，或者至少有一块相邻（4个方向之一）砖块稳定不会掉落时给你一个
// 数组 hits ，这是需要依次消除砖块的位置。每当消除hits[i] = (rowi, coli) 位置上的
// 砖块时，对应位置的砖块（若存在）会消失，然后其他的砖块可能因为这一消除操作而掉落。一旦
// 砖块掉落，它会立即从网格中消失（即，它不会落在其他稳定的砖块上）。
//
//  返回一个数组 result ，其中 result[i] 表示第 i 次消除操作对应掉落的砖块数目。
//
//  注意，消除可能指向是没有砖块的空白位置，如果发生这种情况，则没有砖块掉落。
public class lc803 {
    int rows;
    int cols;
    public static final int[][] DIRECTIONS = {{1, 0}, {0, 1}, {-1, 0},{0, -1}};
    public int[] hitBricks(int[][] grid, int[][] hits) {
        this.rows = grid.length;
        this.cols = grid[0].length;

        // 复制，并击碎hits，倒序完成
        int[][] copy = new int[rows][cols];
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                copy[i][j] = grid[i][j];
            }
        }
//        击碎hits
        for(int[] hit:hits){
            copy[hit[0]][hit[1]] = 0;
        }
        // 建图 把砖块和砖块的连接关系输入并查集，
        // size 表示二维网格的大小，也表示虚拟的「屋顶」在并查集中的编号
        int size = rows * cols;
        UnionFind unionFind = new UnionFind(size+1);
        // 将下标为 0 的这一行的砖块与「屋顶」相连
        // 即屋顶上的所有砖块都属于一个并查集
        for(int i=0; i<cols; i++){
            if(copy[0][i]==1){
                unionFind.union(i, size);
            }
        }
        // 其余网格，如果是砖块向上、向左看一下，如果也是砖块，在并查集中进行合并
        // 只和上和左边的砖块比较
        for(int i=1; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(copy[i][j] == 1){
                    if(copy[i-1][j]==1){
                        unionFind.union(getIndex(i-1, j), getIndex(i, j));
                        // 前并后
                    }
                    if(j > 0 && copy[i][j-1]==1){
                        unionFind.union(getIndex(i, j-1), getIndex(i, j));
                        // 前并后
                    }
                }
            }
        }


        int hitsLen = hits.length;
        int[] res = new int[hitsLen];
        for(int i=hitsLen - 1; i>=0; i--){
            int x = hits[i][0];
            int y = hits[i][1];
            // 这里是grid，不是copy，copy中此处必定是0
            if(grid[x][y] == 0){
                continue;
            }
            int origin = unionFind.getSize(size);
            if (x==0){
                unionFind.union(y, size);
            }

            for(int[] direction: DIRECTIONS){
                int newX = x + direction[0];  // int x = hits[i][0];

                int newY = y + direction[1];  // int y = hits[i][1];
                if(inArea(newX, newY) && copy[newX][newY]==1){
                    unionFind.union(getIndex(x, y), getIndex(newX, newY));
                }
            }

            int current = unionFind.getSize(size);
            res[i] = Math.max(0, current-origin-1);
            copy[x][y] = 1;


        }
       return res;

    }

    private boolean inArea(int x, int y){
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }

    private int getIndex(int x, int y){
        // 并查集需要一维数组，该方法将二维数据转为一维矩阵
        return x * cols + y;
    }


    private class UnionFind{
        private int[] parent;
        private int[] size;
        public UnionFind(int n){
            // Init size表示连通图所含元素大小
            parent = new int[n];
            size = new int[n];
            for(int i=0; i<n; i++){
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int find(int x){
            // 递归寻找父节点，同时进行 <路径压缩：减小树高>
            if(x!=parent[x]){
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int x, int y){
            int rootX = find(x);
            int rootY = find(y);
            if(rootX == rootY){
                return;
            }
            // 将X并到Y上
            parent[rootX] = rootY;
            // 维护数组size
            size[rootY] += size[rootX];
        }

        public int getSize(int x){
            int root = find(x);
            return size[root];
        }
    }
}



