package cn.shinonome;

import java.util.*;

/**
 * @Description TODO
 * @Author chris
 * @Date 2022/6/19, 00:33
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        boolean[] isVisited = new boolean[10];
        int ans = backtrack(num, isVisited, new ArrayDeque<>(), Integer.MAX_VALUE);
        System.out.println(ans);
    }
    private static int backtrack(int target, boolean[] isVisited, Deque<Integer> cur, int curMin) {
        if (target == 0) {
            int ans = 0;
            for (int digit : cur) {
                ans *= 10;
                ans += digit;
            }
            curMin = Math.min(ans / 10, curMin);
            return curMin;
        }
        if (target < 0) {
            return Integer.MAX_VALUE;
        }
        for (int i = 1; i <= 9; ++i) {
            if (isVisited[i]) {
                continue;
            }
            isVisited[i] = true;
            cur.addLast(i);
            backtrack(target - i, isVisited, cur, curMin);
            cur.pollLast();
            isVisited[i] = false;
        }
        return Integer.MAX_VALUE;
    }
}