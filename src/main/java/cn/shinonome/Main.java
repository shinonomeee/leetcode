package cn.shinonome;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @Description 508. 出现次数最多的子树元素和
 * @Author chris
 * @Date 2022/6/19, 00:33
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();


    }
}

class Solution {
    private final Map<Integer, Integer> feq = new HashMap<>();
    private int maxFeq = Integer.MIN_VALUE;

    public int[] findFrequentTreeSum(TreeNode root) {
        dfs(root);
        Stack<Integer> st = new Stack<>();
        for (Map.Entry<Integer, Integer> entry : feq.entrySet()) {
            int key = entry.getKey();
            int keyFeq = entry.getValue();
            if (keyFeq == maxFeq) {
                st.push(key);
            }
        }
        int[] ans = new int[st.size()];
        int i = 0;
        while (!st.isEmpty()) {
            ans[i++] = st.pop();
        }
        return ans;
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        int sum = getSum(node);
        int leftFeq = feq.getOrDefault(sum, 0) + 1;
        feq.put(sum, leftFeq);
        maxFeq = Math.max(maxFeq, leftFeq);
        dfs(node.left);
        dfs(node.right);
    }

    private int getSum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return node.val + getSum(node.left) + getSum(node.right);
    }
}

// Definition for a binary tree node.
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