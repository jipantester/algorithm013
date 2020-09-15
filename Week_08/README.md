

# 17 位运算

## 17.1.知识点

[如何从十进制转换为二进制](https://zh.wikihow.com/从十进制转换为二进制)


**位运算符**

|含义|运算符|实例|
|--|--|--|
|左移|<<|0011=>0110|
|右移|>>|0110=>0011|
![avatar](位运算符.jpg)

**XOR - 异或**

异或：相同为 0，不同为 1。也可用“不进位加法”来理解。
异或操作的一些特点：
+ x ^ 0 = x 
  + x为1，与0不同，返回1；x为0，与0相同，返回0；因此 X ^ 0 = x
+ x ^ 1s = ~x // 注意 1s = ~0
  + x ^ (~0) = ~0，当x=1，1 ^ 1 = 0(~1)，当x=0时，0 ^ 1 = 1(~0)
+ x ^ (~x) = 1s
  + x ^ (~x) = ~0，当x=1时，1 ^ (~1) = 1(~0)，当x=0时，0 ^ (~0) = 1(~0)
+ x ^ x = 0
  + 异或的定义，相同为0
+ c = a ^ b => a ^ c = b, b ^ c = a // 交换两个数
+ a ^ b ^ c = a ^ (b ^ c) = (a ^ b) ^ c // associative

**指定位置的位运算**
1. 将 x 最右边的 n 位清零：x & (~0 << n)
   1. (~0 << n) 先将int型的0按位取反得到1，然后将全1左移 n 位，这样右n位为全0，
   2. 再与 x，就是将 x 最右边的 n 位清零了
2. 获取 x 的第 n 位值（0 或者 1）： (x >> n) & 1
   1. int型的 x 右移 n 位，
3. 获取 x 的第 n 位的幂值：x & (1 << n)
4. 仅将第 n 位置为 1：x | (1 << n)
5. 仅将第 n 位置为 0：x & (~ (1 << n))
6. 将 x 最高位至第 n 位（含）清零：x & ((1 << n) - 1)

**实战位运算要点**
+ 判断奇偶：
x % 2 == 1 —> (x & 1) == 1
x % 2 == 0 —> (x & 1) == 0
+ x >> 1 —> x / 2. 
即： x = x / 2; —> x = x >> 1;
mid = (left + right) / 2; —> mid = (left + right) >> 1;
+ X = X & (X-1) 清零最低位的 1
+ X & -X => 得到最低位的 1
+ X & ~X => 0

[N 皇后位运算代码示例](https://shimo.im/docs/YzWa5ZZrZPYWahK2/read)

## 17.2.实战题目

### 17.2.1.leedcode题目：[191. 位1的个数](https://leetcode-cn.com/problems/number-of-1-bits/)


### 17.2.2.leedcode题目：[231. 2的幂](https://leetcode-cn.com/problems/power-of-two/)


### 17.2.3.leedcode题目：[190. 颠倒二进制位](https://leetcode-cn.com/problems/reverse-bits/)


### 17.2.4.leedcode题目：[51. N 皇后](https://leetcode-cn.com/problems/n-queens/description/)


### 17.2.5.leedcode题目：[52. N皇后 II](https://leetcode-cn.com/problems/n-queens-ii/description/)


### 17.2.6.leedcode题目：[338. 比特位计数](https://leetcode-cn.com/problems/counting-bits/description/)




# 18.布隆过滤器和LRU缓存

## 18.1.布隆过滤器的实现及应用

[布隆过滤器的原理和实现](https://www.cnblogs.com/cpselvis/p/6265825.html)
[使用布隆过滤器解决缓存击穿、垃圾邮件识别、集合判重](https://blog.csdn.net/tianyaleixiaowu/article/details/74721877)
[布隆过滤器 Python 代码示例](https://shimo.im/docs/UITYMj1eK88JCJTH)
[布隆过滤器 Python 实现示例](https://www.geeksforgeeks.org/bloom-filters-introduction-and-python-implementation/)
[高性能布隆过滤器 Python 实现示例](https://github.com/jhgg/pybloof)
[布隆过滤器 Java 实现示例 1](https://github.com/lovasoa/bloomfilter/blob/master/src/main/java/BloomFilter.java)
[布隆过滤器 Java 实现示例 2](https://github.com/Baqend/Orestes-Bloomfilter)



## 18.2.LRU Cache的实现、应用和题解

[Understanding the Meltdown exploit](https://www.sqlpassion.at/archive/2018/01/06/understanding-the-meltdown-exploit-in-my-own-simple-words/)
[替换算法总揽](https://en.wikipedia.org/wiki/Cache_replacement_policies)
[LRU Cache Python 代码示例](https://shimo.im/docs/CoyPAyXooGcDuLQo)


## 18.3.实战题目

### 18.3.1.leedcode题目：[146. LRU缓存机制](https://leetcode-cn.com/problems/lru-cache/#/)

# 19.排序算法

## 19.1.
[十大经典排序算法](https://www.cnblogs.com/onepixel/p/7674659.html)
[快速排序代码示例](https://shimo.im/docs/TX9bDbSC7C0CR5XO)
[归并排序代码示例](https://shimo.im/docs/sDXxjjiKf3gLVVAU)
[堆排序代码示例](https://shimo.im/docs/M2xfacKvwzAykhz6)

### 19.1.1.课后作业
用自己熟悉的编程语言，手写各种初级排序代码，提交到学习总结中。


## 19.2.

[十大经典排序算法](https://www.cnblogs.com/onepixel/p/7674659.html)
[9 种经典排序算法可视化动画](https://www.bilibili.com/video/av25136272)
[6 分钟看完 15 种排序算法动画展示](https://www.bilibili.com/video/av63851336)




## 19.3.实战题目 
数组的相对排序（谷歌在半年内面试中考过）
有效的字母异位词（Facebook、亚马逊、谷歌在半年内面试中考过）
力扣排行榜（Bloomberg 在半年内面试中考过）
合并区间（Facebook、字节跳动、亚马逊在半年内面试中常考）
翻转对（字节跳动在半年内面试中考过）

### 19.3.1.leedcode题目：[1122. 数组的相对排序](https://leetcode-cn.com/problems/relative-sort-array/)
### 19.3.2.leedcode题目：[242. 有效的字母异位词](https://leetcode-cn.com/problems/valid-anagram/)
### 19.3.3.leedcode题目：[](https://leetcode-cn.com/problems/design-a-leaderboard/)
### 19.3.4.leedcode题目：[56. 合并区间](https://leetcode-cn.com/problems/merge-intervals/)
### 19.3.5.leedcode题目：[56. 合并区间](https://leetcode-cn.com/problems/reverse-pairs/)

