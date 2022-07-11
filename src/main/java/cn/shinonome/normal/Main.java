package cn.shinonome.normal;

/**
 * @Description
 * @Author chris
 * @Date 2022/7/11, 15:04
 */
public class Main {
    public static void main(String[] args) {

    }
}

class MagicDictionary {

    String[] dic;

    public MagicDictionary() {
    }

    public void buildDict(String[] dictionary) {
        dic = dictionary;
    }

    public boolean search(String searchWord) {
        int len = searchWord.length();
        for (String word : dic) {
            if (word.length() != len) {
                continue;
            }
            int diff = 0;
            for (int i = 0; i < len; i++) {
                if (word.charAt(i) != searchWord.charAt(i)) {
                    ++diff;
                }
            }
            if (diff == 1) {
                return true;
            }
        }
        return false;
    }
}
