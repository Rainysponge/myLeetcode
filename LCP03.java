package LC;

public class LCP03 {
    public boolean robot(String command, int[][] obstacles, int x, int y) {
        int[][] board = new int[x+1][y+1];
        for (int[] obstacle : obstacles) {
            if (obstacle[0] <= x && obstacle[1] <= y) {
                board[obstacle[0]][obstacle[1]] = 1; // 1:obstacles
            }
        }
        int[][] commandList = new int[command.length()][2];
        for(int i=0;i<command.length();i++){
            if(command.charAt(i) == 'U'){
                commandList[i][1] = 1;
            }else{
                commandList[i][0] = 1;
            }
        }
        int index = 0;
        int a = 0, b = 0;
        while (true){
            if(a>x || b>y || board[a][b]==1) return false;
            if(a==x&&b==y) return true;
            System.out.printf("%d\t%d\n", a, b);
            a += commandList[index][0];

            b += commandList[index][1];

            index = (index+1) % command.length();
        }





    }
}
