package cn.shinonome;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Map;
import java.util.Queue;

/**
 * @Description TODO
 * @Author chris
 * @Date 2022/6/19, 00:33
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.findOrder(3, new int[][]{{1, 0}, {1, 2}, {0, 1}})));
    }
}

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[][] matrix = new int[numCourses][numCourses]; // 邻接矩阵
        int[] penetrations = new int[numCourses];         // 每个顶点的入度
        Queue<Integer> q = new ArrayDeque<>();            // 工作队列
        int[] ans = new int[numCourses];
        int i = 0, index = 0;
        for (int[] arr : prerequisites) {
            if (arr[0] == arr[1]) {
                return new int[]{};
            }
            matrix[arr[1]][arr[0]] = 1;
            ++penetrations[arr[0]];
        }
        for (; i < numCourses; ++i) {
            if (penetrations[i] == 0) {
                q.offer(i);
            }
        }
        while (!q.isEmpty()) {
            int cur = q.poll();
            ans[index++] = cur;
            for (i = 0; i < numCourses; ++i) {
                if (matrix[cur][i] == 1 && --penetrations[i] == 0) {
                    q.offer(i);
                }
            }
        }
        if (index != numCourses) {
            return new int[]{};
        }
        return ans;
    }
}