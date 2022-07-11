package cn.shinonome.trie;

/**
 * @Description TODO
 * @Author chris
 * @Date 2022/6/19, 00:33
 */
public class Main {
    public static void main(String[] args) {
        MagicDictionary md = new MagicDictionary();
        md.buildDict(new String[]{"hello", "leetcode", "hallo"});
        System.out.println(md.search("hhllo"));
        System.out.println(md.search("hell"));

    }
}

/**
 * 字典树
 * @Author chris
 * @Date 2022/7/11, 14:59
 * @Name Trie
 */
class Trie {
    public boolean isFinished;
    public Trie[] child;

    Trie() {
        this.isFinished = false;
        this.child = new Trie[26];
    }

}

class MagicDictionary {
    private Trie root;

    public MagicDictionary() {
        root = new Trie();
    }

    /**
     * 构建字典树
     * @param dictionary 字典
     * @Author chris
     */
    public void buildDict(String[] dictionary) {
        Trie cur;
        int len, index, i;
        for (String str : dictionary) {
            len = str.length();
            cur = root;
            for (i = 0; i < len; i++) {
                index = str.charAt(i) - 'a';
                if (cur.child[index] == null) {
                    cur.child[index] = new Trie();
                }
                cur = cur.child[index];
            }
            cur.isFinished = true;
        }
    }

    public boolean search(String searchWord) {
        return dfs(searchWord, 0, root, false);
    }

    /**
     * dfs深搜
     * @param word 待搜索的字符串
     * @param begin 字符串的开始位置
     * @param node 当前结点，即从哪个结点开始
     * @param hasDiff 有没有差异，若有，则直接调用精确匹配
     * @return
     * @Author chris
     */
    private boolean dfs(String word, int begin, Trie node, boolean hasDiff) {
        if (begin == word.length()) {
            return hasDiff && node.isFinished;
        }
        if (hasDiff) {
            return accurateSearch(word, begin, node);
        }
        if (node == null) {
            return false;
        }
        int index = word.charAt(begin) - 'a';
        for (int i = 0; i < 26; i++) {
            if (i == index) {
                continue;
            }
            if (node.child[i] != null && dfs(word, begin + 1, node.child[i], true)) {
                return true;
            }
        }
        return dfs(word, begin + 1, node.child[index], false);
    }

    /**
     * 精准匹配
     * @param word
     * @param begin
     * @param node
     * @return
     * @Author chris
     */
    private boolean accurateSearch(String word, int begin, Trie node) {
        Trie cur = node;
        int index;
        for (int i = begin; i < word.length(); i++) {
            index = word.charAt(i) - 'a';
            if (cur.child[index] == null) {
                return false;
            }
            cur = cur.child[index];
        }
        return cur.isFinished;
    }
}
