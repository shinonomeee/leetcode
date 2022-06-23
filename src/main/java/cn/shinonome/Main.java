package cn.shinonome;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description TODO
 * @Author chris
 * @Date 2022/6/19, 00:33
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findSubstring("12231223", new String[]{"12", "23"}));

    }
}

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<Integer>();
        int wordsNum = words.length, gap = words[0].length(), sLen = s.length();
        for (int i = 0; i < gap; i++) {
            if (i + wordsNum * gap > sLen) {
                break;
            }
            Map<String, Integer> differ = new HashMap<>();
            for (int j = 0; j < wordsNum; j++) {
                String word = s.substring(i + j * gap, i + (j + 1) * gap);
                differ.put(word, differ.getOrDefault(word, 0) + 1);
            }
            for (String word : words) {
                differ.put(word, differ.getOrDefault(word, 0) - 1);
                if (differ.get(word) == 0) {
                    differ.remove(word);
                }
            }
            for (int start = i; start < sLen - wordsNum * gap + 1; start += gap) {
                if (start != i) {
                    String word = s.substring(start + (wordsNum - 1) * gap, start + wordsNum * gap);
                    differ.put(word, differ.getOrDefault(word, 0) + 1);
                    if (differ.get(word) == 0) {
                        differ.remove(word);
                    }
                    word = s.substring(start - gap, start);
                    differ.put(word, differ.getOrDefault(word, 0) - 1);
                    if (differ.get(word) == 0) {
                        differ.remove(word);
                    }
                }
                if (differ.isEmpty()) {
                    ans.add(start);
                }
            }
        }
        return ans;
    }
}