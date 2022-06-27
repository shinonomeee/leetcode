package cn.shinonome;


import java.util.HashMap;
import java.util.Map;

/**
 * @Description 12. 整数转罗马数字
 * @Author chris
 * @Date 2022/6/19, 00:33
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.intToRoman(999));

    }
}

class Solution {

    private static final Map<Integer, String> map = new HashMap<Integer, String>() {{
        put(1, "I");
        put(5, "V");
        put(10, "X");
        put(50, "L");
        put(100, "C");
        put(500, "D");
        put(1000, "M");
    }};
    public String intToRoman(int num) {
        StringBuilder ans = new StringBuilder();
        for (int i = 1000; i > 0; i /= 10) {
            int tmp = num / i;
            num -= tmp * i;
            if (tmp == 9) {
                ans.append(map.get(i)).append(map.get(i * 10));
            } else if (tmp == 4) {
                ans.append(map.get(i)).append(map.get(i * 5));
            } else {
                if (tmp >= 5) {
                    ans.append(map.get(i * 5));
                    tmp -= 5;
                }
                String express = map.get(i);
                for (int j = 0; j < tmp; j++) {
                    ans.append(express);
                }
            }
        }
        return ans.toString();
    }
}