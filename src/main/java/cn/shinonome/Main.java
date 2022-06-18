package cn.shinonome;


/**
 * @Description 2139. 得到目标值的最少行动次数
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
        int count = 0;
        while (target != 1 && maxDoubles > 0) {
            if (target % 2 == 0) {  // 不难发现原数越大，乘二的收益越大，采用贪心的方法
                target >>= 1;
                ++count;
            } else {
                target = (target - 1) >> 1;
                count += 2;
            }
            --maxDoubles;
        }
        // maxDoubles全部耗尽之后，只能采用加一的方式，需要target-1次
        // target = 1时，也成立
        return count + target - 1;
    }
}