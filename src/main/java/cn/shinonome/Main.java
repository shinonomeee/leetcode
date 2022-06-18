package cn.shinonome;


/**
 * @Description TODO
 * @Author chris
 * @Date 2022/6/19, 00:33
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();


    }
}

class Solution {
    public int minMoves(int target, int maxDoubles) {
        return dfs(target, maxDoubles);
    }

    private int dfs(int target, int maxDoubles) {
        if (target == 1) {
            return 0;
        }
        if (maxDoubles == 0) {
            return target - 1;
        }
        if (target % 2 == 0) {
            return dfs(target >> 1, maxDoubles - 1) + 1;
        } else {
            return dfs((target - 1) >> 1, maxDoubles - 1) + 2;
        }
    }
}