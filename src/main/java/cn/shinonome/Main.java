package cn.shinonome;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description TODO
 * @Author chris
 * @Date 2022/6/19, 00:33
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.shiftGrid(new int[]{
                new int[]{1, 2, 3},
                new int[]{1, 2, 3}}, 2);

    }
}

class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        k %= (m * n);
        int shift = k / n;
        k %= n;
        List<List<Integer>> ans = new ArrayList<>(m);
        ans.forEach(e -> e = new ArrayList<>(n));
        System.out.println(ans);
        return ans;
    }
}
