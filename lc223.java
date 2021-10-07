package LC;

public class lc223 {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int repeat = 0;
        int i = Math.min(bx2, ax2) - Math.max(bx1, ax1);
        int j = Math.min(ay2, by2) - Math.max(ay1, by1);
        if(i > 0 && j > 0){

            repeat = i * j;
        }

        //S_first_square = (D - B) * (C - A)
        //        S_second_square = (H - F) * (G - E)
        int a = (ay2 - ay1)  * (ax2 - ax1);
        int b = (by2 - by1)  * (bx2 - bx1);

        return  a + b - repeat;

    }
}
