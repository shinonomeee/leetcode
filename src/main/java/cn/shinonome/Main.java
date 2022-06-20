package cn.shinonome;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Description 945. 使数组唯一的最小增量
 * @Author chris
 * @Date 2022/6/19, 00:33
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.minIncrementForUnique(new int[]{3, 2, 1, 2, 1, 7}));
    }
}

class Solution {
    public int minIncrementForUnique(int[] nums) {
        int count = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] >= nums[i + 1]) {
                count += nums[i] - nums[i + 1] + 1;
                nums[i + 1] = nums[i] + 1;
            }
        }
        return count;
    }
}