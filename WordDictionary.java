package LC;

// import java.util.Arrays;
// import java.util.Deque;
// import java.util.LinkedList;

//public class WordDictionary {
//
//    class Node{
//        // 表示字母 记录字母的个数和下一个
//        int val = 0;
//        Node[] next;
//        public Node(){
//            next = new Node[26];
//        }
//    }
//
//    Node root;
//
//    public WordDictionary() {
//        root = new Node();
//    }
//
//    public void addWord(String word) {
//        Node tmp = root;
//        for(char c: word.toCharArray()){
//            int index = c - 'a';
//            if (tmp.next[index] == null){
//                tmp.next[index] = new Node();
//                tmp.next[index].val = 1;
//            }else{
//                tmp.next[index].val++;
//            }
//            tmp = tmp.next[index];
//        }
//    }
//
//    public boolean search(String word) {
//        int cur = -1; // 要搜索成功 必须所有Node的val一致
//        Node tmp = root;
//        Deque<Node> queue = new LinkedList<>();
//
//        for(char c: word.toCharArray()){
//            if(c != '.'){
//                int index = c - 'a';
//                if(tmp.next[index].val == 0){
//                    return false;
//                }else{
//                    if(cur < 0){
//                        cur = tmp.next[index].val;
//                    }else{
//                        if(cur != tmp.next[index].val){
//                            return false;
//                        }
//                    }
//                    tmp = tmp.next[index];
//                }
//            }else{
//                for(int i=0; i<26; i++){
//                    if(tmp.next[i].val != 0){
//                        queue.add(tmp.next[i]);
//                    }
//                }
//            }
//        }
//    }
//}

public class WordDictionary {
    private Trie root;

    public WordDictionary() {
        root = new Trie();
    }

    public void addWord(String word) {
        root.insert(word);
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int index, Trie node) {
        if (index == word.length()) {
            return node.isEnd();
        }
        char ch = word.charAt(index);
        if (Character.isLetter(ch)) {
            int childIndex = ch - 'a';
            Trie child = node.getChildren()[childIndex];
            if (child != null && dfs(word, index + 1, child)) {
                return true;
            }
        } else {
            for (int i = 0; i < 26; i++) {
                Trie child = node.getChildren()[i];
                if (child != null && dfs(word, index + 1, child)) {
                    return true;
                }
            }
        }
        return false;
    }
}

class Trie {
    private Trie[] children;
    private boolean isEnd;

    public Trie() {
        children = new Trie[26];
        isEnd = false;
    }

    public void insert(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            if (node.children[index] == null) {
                node.children[index] = new Trie();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }

    public Trie[] getChildren() {
        return children;
    }

    public boolean isEnd() {
        return isEnd;
    }
}


