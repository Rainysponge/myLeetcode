package LC;

public class lc28 {
    public int strStr(String haystack, String needle) {
        // 关注当前不同的前面字符是否相同
        int hayLen = haystack.length();
        int needleLen = needle.length();
        if(needleLen==0) return 0;
        if(hayLen<needleLen) return -1;

        int[] KMPList = new int[needleLen];

        char[] h = haystack.toCharArray();
        char[] n = needle.toCharArray();

        KMP(KMPList, n);
//        for(int i=0; i<needleLen; i++){
//            System.out.print(KMPList[i] + " ");
//        }
//        System.out.println("");
        int indexH = 0, indexN = 0;

        while(indexH<hayLen){
            if(h[indexH]==n[indexN]){
                indexH++;
                indexN++;
            }else {
                while(indexN>0){
                    indexN = KMPList[indexN-1] + 1;
                    if(h[indexH]==n[indexN]){
                        indexH++;
                        indexN++;
                        break;
                    }
                }
                if(indexH>=hayLen) return -1;
                if(h[indexH]==n[indexN]){
                    indexH++;
                    indexN++;
                }else{
                    indexH++;
                }
            }
            if(indexN==needleLen) return indexH - needleLen;

        }
        return -1;

    }

    private void KMP(int[] KMPList, char[] n){
        KMPList[0] = -1;
        int L = n.length;
        boolean[] visited = new boolean[L];
        for(int i=1; i<L; i++){
            int t = KMPList[i-1] + 1;
            while(t>=0){
                if(n[t] == n[i]){
                    KMPList[i] = t;
                    visited[i] = true;
                    break;
                }else{
                    if(t == 0){
                        break;
                    }else{
                        t = KMPList[t-1] + 1;
                    }
                }
            }
            if(!visited[i]){
                KMPList[i] = -1;
                visited[i] = true;
            }

        }
    }

}
