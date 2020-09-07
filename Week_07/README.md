
# 14.字典树和并查集

## 14.1.知识点

**1、字典树的数据结构**

基本结构：字典树，即trie树，又称单词查找树或键树，是一种树形结构。典型应用是用于统计和排序大量的字符串（但又不仅限于字符串），所以经常被搜索引擎系统用于文本词频统计。
优点是：最大限度地减少无谓的字符串比较，查询效率比哈希表高。

**基本性质**
+ 1、节点本身不存在完整单词
+ 2、从根节点到某一个节点，路径上经过的字符连接起来，为该节点对应的字符串
+ 3、每个节点的所有子节点路径代表的字符都不相同
  
**核心思想**
+ Trie树的核心思想是空间换时间
+ 利用字符串的公共前缀来降低查询时间的开销以达到提高效率的目的

[Trie树代码模板](https://shimo.im/docs/DP53Y6rOwN8MTCQH/read)

[并查集代码模板](https://shimo.im/docs/VtcxL0kyp04OBHak/read)

## 14.2.实战题目

### 14.2.1.leedcode题目：[102.二叉树的层序遍历](https://leetcode-cn.com/problems/binary-tree-level-order-traversal/)

### 14.2.2.leedcode题目：[208.实现 Trie (前缀树)](https://leetcode-cn.com/problems/implement-trie-prefix-tree/)
实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
```java
示例:

Trie trie = new Trie();

trie.insert("apple");
trie.search("apple");   // 返回 true
trie.search("app");     // 返回 false
trie.startsWith("app"); // 返回 true
trie.insert("app");   
trie.search("app");     // 返回 true

说明:
你可以假设所有的输入都是由小写字母 a-z 构成的。
保证所有输入均为非空字符串。
```
**题解**


### 14.2.3.leedcode题目：[212.单词搜索 II](https://leetcode-cn.com/problems/word-search-ii/)


### 14.2.4.课后作业
分析单词搜索 2 用 Tire 树方式实现的时间复杂度，请同学们提交在学习总结中。

### 14.2.5.leedcode题目：[547.朋友圈](https://leetcode-cn.com/problems/friend-circles/)


### 14.2.6.leedcode题目：[200.岛屿数量](https://leetcode-cn.com/problems/number-of-islands/)


### 14.2.7.leedcode题目：[130.被围绕的区域](https://leetcode-cn.com/problems/surrounded-regions/)

# 15.高级搜索

## 15.1.知识点

[DFS代码模板](https://shimo.im/docs/UdY2UUKtliYXmk8t/read)
[BFS代码模板](https://shimo.im/docs/ZBghMEZWix0Lc2jQ/read)
[AlphaZero Explained](https://nikcheerla.github.io/deeplearningschool/2018/01/01/AlphaZero-Explained/)
[棋类复杂度](https://en.wikipedia.org/wiki/Game_complexity)
[A*代码模板](https://shimo.im/docs/8CzMlrcvbWwFXA8r/read)
[相似度测量方法](https://dataaspirant.com/five-most-popular-similarity-measures-implementation-in-python/)
[8 puzzles解法比较](https://zxi.mytechroad.com/blog/searching/8-puzzles-bidirectional-astar-vs-bidirectional-bfs/)



## 15.2.实战题目

### 15.2.1.leedcode题目：[70.爬楼梯](https://leetcode-cn.com/problems/climbing-stairs/)


### 15.2.2.leedcode题目：[22.括号生成](https://leetcode-cn.com/problems/generate-parentheses/)


### 15.2.3.leedcode题目：[51.N 皇后](https://leetcode-cn.com/problems/n-queens/)

### 15.2.4.leedcode题目：[36.有效的数独](https://leetcode-cn.com/problems/valid-sudoku/description/)


### 15.2.5.leedcode题目：[127.单词接龙](https://leetcode-cn.com/problems/word-ladder/)


### 15.2.6.leedcode题目：[433.最小基因变化](https://leetcode-cn.com/problems/minimum-genetic-mutation/)


### 15.2.7.课后作业
总结双向 BFS 代码模版，请同学们提交在学习总结中。

### 15.2.8.leedcode题目：[1091.二进制矩阵中的最短路径](https://leetcode.com/problems/shortest-path-in-binary-matrix/discuss/313347/A*-search-in-Python)


### 15.2.9.leedcode题目：[773.滑动谜题](https://leetcode-cn.com/problems/sliding-puzzle/)


### 15.2.9.leedcode题目：[37.解数独](https://leetcode-cn.com/problems/sudoku-solver/)


# 16.红黑树和AVL树

## 16.1.知识点

[维基百科：平衡树](https://en.wikipedia.org/wiki/Self-balancing_binary_search_tree)
