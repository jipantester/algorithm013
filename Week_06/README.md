学习笔记

- [13.动态规划](#13动态规划)
  - [13.1.知识点](#131知识点)
  - [13.2.实战题目](#132实战题目)
    - [13.2.1.leedcode题目：斐波拉契数列](#1321leedcode题目斐波拉契数列)
    - [13.2.2.leedcode题目：路径计数](#1322leedcode题目路径计数)
    - [13.2.3.leedcode题目：62.不同路径](#1323leedcode题目62不同路径)
    - [13.2.4.leedcode题目：63.不同路径 II](#1324leedcode题目63不同路径-ii)
    - [13.2.5.leedcode题目：1143.最长公共子序列](#1325leedcode题目1143最长公共子序列)
    - [13.2.6.leedcode题目：70.爬楼梯](#1326leedcode题目70爬楼梯)
    - [13.2.7.leedcode题目：120.三角形最小路径和](#1327leedcode题目120三角形最小路径和)
    - [13.2.8.leedcode题目：53.最大子序和](#1328leedcode题目53最大子序和)
    - [13.2.9.leedcode题目：152.乘积最大子数组](#1329leedcode题目152乘积最大子数组)
    - [13.2.10.leedcode题目：322.零钱兑换](#13210leedcode题目322零钱兑换)
    - [13.2.11.leedcode题目：打家劫舍（字节跳动、谷歌、亚马逊在半年内面试中考过）](#13211leedcode题目打家劫舍字节跳动谷歌亚马逊在半年内面试中考过)
    - [13.2.12.leedcode题目：打家劫舍 II （字节跳动在半年内面试中考过）](#13212leedcode题目打家劫舍-ii-字节跳动在半年内面试中考过)
    - [13.2.13.leedcode题目：买卖股票的最佳时机（亚马逊、字节跳动、Facebook 在半年内面试中常考）](#13213leedcode题目买卖股票的最佳时机亚马逊字节跳动facebook-在半年内面试中常考)
    - [13.2.14.leedcode题目：买卖股票的最佳时机 II （亚马逊、字节跳动、微软在半年内面试中考过）](#13214leedcode题目买卖股票的最佳时机-ii-亚马逊字节跳动微软在半年内面试中考过)
    - [13.2.15.leedcode题目：买卖股票的最佳时机 III （字节跳动在半年内面试中考过）](#13215leedcode题目买卖股票的最佳时机-iii-字节跳动在半年内面试中考过)
    - [13.2.16.leedcode题目：最佳买卖股票时机含冷冻期（谷歌、亚马逊在半年内面试中考过）](#13216leedcode题目最佳买卖股票时机含冷冻期谷歌亚马逊在半年内面试中考过)
    - [13.2.17.leedcode题目：买卖股票的最佳时机 IV （谷歌、亚马逊、字节跳动在半年内面试中考过）](#13217leedcode题目买卖股票的最佳时机-iv-谷歌亚马逊字节跳动在半年内面试中考过)
    - [13.2.18.leedcode题目：买卖股票的最佳时机含手续费](#13218leedcode题目买卖股票的最佳时机含手续费)
    - [13.2.19.leedcode题目：一个方法团灭 6 道股票问题](#13219leedcode题目一个方法团灭-6-道股票问题)
- [高级 DP 实战题目](#高级-dp-实战题目)
  - [完全平方数（亚马逊、谷歌在半年内面试中考过）](#完全平方数亚马逊谷歌在半年内面试中考过)
  - [编辑距离 （重点）](#编辑距离-重点)
  - [跳跃游戏（亚马逊在半年内面试中考过）](#跳跃游戏亚马逊在半年内面试中考过)
  - [跳跃游戏 II （亚马逊、华为字节跳动在半年内面试中考过）](#跳跃游戏-ii-亚马逊华为字节跳动在半年内面试中考过)
  - [不同路径（Facebook、亚马逊、微软在半年内面试中考过）](#不同路径facebook亚马逊微软在半年内面试中考过)
  - [不同路径 II （谷歌、美团、微软在半年内面试中考过）](#不同路径-ii-谷歌美团微软在半年内面试中考过)
  - [不同路径 III （谷歌在半年内面试中考过）](#不同路径-iii-谷歌在半年内面试中考过)
  - [零钱兑换（亚马逊在半年内面试中常考）](#零钱兑换亚马逊在半年内面试中常考)
  - [零钱兑换 II （亚马逊、字节跳动在半年内面试中考过）](#零钱兑换-ii-亚马逊字节跳动在半年内面试中考过)


# 13.动态规划

## 13.1.知识点

**分治 + 回溯 + 递归 + 动态规划**

**[递归模板](https://shimo.im/docs/EICAr9lRPUIPHxsH)**
```java
public void recur(int level, int param){
    //递归终止条件
    if (level > MAX_LEVEL){
        return;
    }

    //执行当前程序
    process(level, param);

    //向下执行
    recur(level:level+1, newParam);

    //清除当层的缓存
}
```

**[分治模板](https://shimo.im/docs/zvlDqLLMFvcAF79A)**
```java
public int divide_conquer(Problem problem,){
    if (problem == NULL){
        int res = process_last_result();
        return res;
    }

    subProblems = split_problem(problem);

    res0 = divide_conquer(subProblem[0]);
    res1 = divide_conquer(subProblem[1]);

    result = problem_result(res0,res1);
    return result;
}
```

**重点**

+ 找到最近最简方法，将其拆解成可重复解决的问题
+ 数学归纳法
+ 本质：寻找重复性 --> 计算机指令集

**动态规划（Dynamic Programming）**

+ 1、[wiki定义](https://en.wikipedia.org/wiki/Dynamic_programming)
+ 2、“Simplifying a complicated problem by breaking it down into simpler sub-problems”  (in a recursive manner)
+ 3、Divide & Conquer + Optimal substructure（分治 + 最优子结构）

**关键点**

+ 动态规划 和 递归 或者 分治 没有根本上的区别（关键看有无最优子结构）
+ **共性：找到重复子问题**
+ 差异性：最优子结构、中途可以**淘汰**次优解

[MIT 动态规划课程最短路径算法](https://www.bilibili.com/video/av53233912?from=search&seid=2847395688604491997)

## 13.2.实战题目

### 13.2.1.leedcode题目：[斐波拉契数列]()
写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项。斐波那契数列的定义如下：
```java
F(0) = 0,   F(1) = 1
F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
```
斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。

答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
```java
示例 1：
输入：n = 2
输出：1

示例 2：
输入：n = 5
输出：5
```
**题解**
**第一种解法：递归**
显然递归的时间复杂度有些高
```java
public int fib(int n){
    if(n <= 1) return n;
    return fib(n-1)+fib(n-2);
}
```
**第二种解法：记忆化递归法**
在递归的基础上，新建一个长度为n的数组，用于在递归是存储<kbd>f(0)</kbd>至<kbd>f(n)</kbd>数字值，重复遇到的某数字则直接从数组取用，避免了重复递归计算
缺点：记忆化存储需要使用O(N)的额外空间
```java
class Solution {
    public int fib(int n) {
        int con = 1000000007;
        if(n <= 1) return n;
        int[] a = new int[n+1];
        a[0] = 0;
        a[1] = 1;
        for(int i = 2; i < n+1; i++){
            a[i] = (a[i-1] % con) + (a[i-2] % con); 
        }
        return a[n] % con;
    }
}
```
**第三种解法：动态规划**
以斐波那契数列性质<kbd>f(n+1)=f(n)+f(n-1)</kbd>为转移方程
解析：
+ 状态定义：设<kbd>dp</kbd>为一维数组，其中<kbd>dp[i]</kbd>的值代表斐波那契数列第i个数字
+ 转移方程：<kbd>dp[i+1]=dp[i]+dp[i-1]</kbd>，即对应数列定义<kbd>f(n+1)=f(n)+f(n-1)</kbd>
+ 初始状态：<kbd>dp[0]=0</kbd>,<kbd>dp[1]=1</kbd>，即初始化前两个数字；
+ 返回值：<kdb>dp[n]</kbd>，即斐波那契数列的第n个数字。
复杂度分析：时间复杂度为O(N)，计算<kbd>f(n)</kbd>需要循环n次。空间复杂度为O(1)
```java
class Solution{
    public int fib(int n){
        int a = 0, b = 1, sum ;
        for (int i = 0; i < n; i++){
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }
}
```


### 13.2.2.leedcode题目：[路径计数]()

### 13.2.3.leedcode题目：[62.不同路径](https://leetcode-cn.com/problems/unique-paths/)


### 13.2.4.leedcode题目：[63.不同路径 II](https://leetcode-cn.com/problems/unique-paths-ii/)


### 13.2.5.leedcode题目：[1143.最长公共子序列](https://leetcode-cn.com/problems/longest-common-subsequence/)



### 13.2.6.leedcode题目：[70.爬楼梯](https://leetcode-cn.com/problems/climbing-stairs/description/)



### 13.2.7.leedcode题目：[120.三角形最小路径和](https://leetcode-cn.com/problems/triangle/description/)


**[三角形最小路径和高票回答](https://leetcode.com/problems/triangle/discuss/38735/Python-easy-to-understand-solutions-(top-down-bottom-up))**


### 13.2.8.leedcode题目：[53.最大子序和](https://leetcode-cn.com/problems/maximum-subarray/)


### 13.2.9.leedcode题目：[152.乘积最大子数组](https://leetcode-cn.com/problems/maximum-product-subarray/description/)


### 13.2.10.leedcode题目：[322.零钱兑换](https://leetcode-cn.com/problems/coin-change/description/)


### 13.2.11.leedcode题目：[打家劫舍（字节跳动、谷歌、亚马逊在半年内面试中考过）](https://leetcode-cn.com/problems/house-robber/)


### 13.2.12.leedcode题目：[打家劫舍 II （字节跳动在半年内面试中考过）](https://leetcode-cn.com/problems/house-robber-ii/description/)


### 13.2.13.leedcode题目：[买卖股票的最佳时机（亚马逊、字节跳动、Facebook 在半年内面试中常考）](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/#/description)


### 13.2.14.leedcode题目：[买卖股票的最佳时机 II （亚马逊、字节跳动、微软在半年内面试中考过）](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/)


### 13.2.15.leedcode题目：[买卖股票的最佳时机 III （字节跳动在半年内面试中考过）](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/)


### 13.2.16.leedcode题目：[最佳买卖股票时机含冷冻期（谷歌、亚马逊在半年内面试中考过）](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/)


### 13.2.17.leedcode题目：[买卖股票的最佳时机 IV （谷歌、亚马逊、字节跳动在半年内面试中考过）](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/)


### 13.2.18.leedcode题目：[买卖股票的最佳时机含手续费](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/)


### 13.2.19.leedcode题目：[一个方法团灭 6 道股票问题](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/solution/yi-ge-fang-fa-tuan-mie-6-dao-gu-piao-wen-ti-by-l-3/)



# 高级 DP 实战题目
## [完全平方数（亚马逊、谷歌在半年内面试中考过）](https://leetcode-cn.com/problems/perfect-squares/)
## [编辑距离 （重点）](https://leetcode-cn.com/problems/edit-distance/)
## [跳跃游戏（亚马逊在半年内面试中考过）](https://leetcode-cn.com/problems/jump-game/)
## [跳跃游戏 II （亚马逊、华为字节跳动在半年内面试中考过）](https://leetcode-cn.com/problems/jump-game-ii/)
## [不同路径（Facebook、亚马逊、微软在半年内面试中考过）](https://leetcode-cn.com/problems/unique-paths/)
## [不同路径 II （谷歌、美团、微软在半年内面试中考过）](https://leetcode-cn.com/problems/unique-paths-ii/)
## [不同路径 III （谷歌在半年内面试中考过）](https://leetcode-cn.com/problems/unique-paths-iii/)
## [零钱兑换（亚马逊在半年内面试中常考）](https://leetcode-cn.com/problems/coin-change/)
## [零钱兑换 II （亚马逊、字节跳动在半年内面试中考过）](https://leetcode-cn.com/problems/coin-change-2/)