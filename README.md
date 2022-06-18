## 2139. 得到目标值的最少行动次数
> 难度：Medium \
> [原题链接](https://leetcode.cn/problems/minimum-moves-to-reach-target-score)

你正在玩一个整数游戏。从整数 1 开始，期望得到整数 `target` 。

在一次行动中，你可以做下述两种操作之一：

* 递增，将当前整数的值加 1（即， $x = x + 1$）。
* 加倍，使当前整数的值翻倍（即，$x = 2 * x$）。

在整个游戏过程中，你可以使用 递增 操作 任意 次数。但是只能使用 加倍 操作 至多 `maxDoubles` 次。

给你两个整数 `target` 和 `maxDoubles` ，返回从 1 开始得到 `target` 需要的最少行动次数。
