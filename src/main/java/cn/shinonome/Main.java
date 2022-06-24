package cn.shinonome;

import java.util.*;

/**
 * @Description 515. 在每个树行中找最大值
 * @Author chris
 * @Date 2022/6/19, 00:33
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.largestValues(null));
    }
}

class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Deque<TreeNode> dq = new ArrayDeque<>();
        TreeNode last = root;
        int max = Integer.MIN_VALUE;
        dq.offer(root);
        while (!dq.isEmpty()) {
            TreeNode cur = dq.getFirst();
            max = Math.max(max, cur.val);
            if (cur.left != null) {
                dq.offer(cur.left);
            }
            if (cur.right != null) {
                dq.offer(cur.right);
            }
            if (cur == last) {
                last = dq.getLast();
                ans.add(max);
                max = Integer.MIN_VALUE;
            }
            dq.poll();
        }
        return ans;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}