package LC;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class lc212 {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            String str = words[i];
            if (exist(board, str)) {
                ans.add(str);
            }
        }
        return ans;
    }

    public boolean exist(char[][] board, String word) {
        int[] dics = new int[128];
        char[] wordc = word.toCharArray();
        char head = wordc[0];
        Deque<Integer[]> heads = new LinkedList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dics[board[i][j]]++;
                if (board[i][j] == head) {
                    heads.add(new Integer[] { i, j });
                }
            }
        }
        for (int i = 0; i < wordc.length; i++) {
            if (--dics[wordc[i]] < 0) {
                return false;
            }
        }
        while (!heads.isEmpty()) {
            Integer[] pos = heads.poll();
            boolean has = exist(pos[0], pos[1], board, wordc, 0);
            if (has)
                return true;
        }
        return false;
    }

    private boolean exist(Integer x, Integer y, char[][] board, char[] wordc, int i) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length)
            return false;
        // 以 x,y为起点，在board，上有以i为起点 wordc后续的字符串吗？
        // 这里有一个加速
        if (board[x][y] != wordc[i]) {
            return false;
        }
        if (i == wordc.length - 1) {
            return true;
        }
        char temp = board[x][y];
        board[x][y] = '!';
        if (exist(x + 1, y, board, wordc, i + 1)) {
            board[x][y] = temp;
            return true;
        }
        if (exist(x - 1, y, board, wordc, i + 1)) {
            board[x][y] = temp;
            return true;
        }
        if (exist(x, y + 1, board, wordc, i + 1)) {
            board[x][y] = temp;
            return true;
        }
        if (exist(x, y - 1, board, wordc, i + 1)) {
            board[x][y] = temp;
            return true;
        }
        board[x][y] = temp;
        return false;
    }


}
