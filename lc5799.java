package LC;

public class lc5799 {
    // Problem C - 最美子字符串的数目
    // 方法一：状态压缩+前缀异或和
    //好的状态为0和所有2^i  ---妙
    public long wonderfulSubstrings(String word) {
        long res = 0;
        int mask = 0;
        long[] freq = new long[1<<10];  // 先前出现的所有的就情况
        // 实际有用的就是 1<<i for i in range(10)
        // 记录当某一个字母出现奇数次时的次数
        // eg : freq[1] 就是记录先前当a出现奇数次的组合数
        freq[0] = 1;
        for(char c : word.toCharArray()){
            int index = c - 'a';
            mask ^= (1 << index);
            res += freq[mask];  // 当前缀奇偶情况与此时一致
            for(int i=0; i<10; i++){
                res += freq[mask^(1<<i)];
            }
            freq[mask]++;
        }

        return res;


    }
}
