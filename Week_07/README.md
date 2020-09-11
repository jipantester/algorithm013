
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
要实现Trie树，需要先设计TrieNode结点，结点应具有以下字段：
+ 最多R个指向子结点的链接，其中每个链接对应字母表数据集中的一个字母，本文中假定R为26，小写拉丁字母的数量。
+ 布尔字段，以指定节点是对应键的结尾还是只是前缀。
```java
//定义Trie树的节点结构
class TrieNode {
    //R links to node children
    private TrieNode[] links;
    private final int R = 26;
    private boolean isEnd;

    public TrieNode(){
        links = new TrieNode[R];
    }

    public boolean containsKey(char ch){
        return links[ch-'a'] != null;
    }

    public TrieNode get(char ch){
        return links[ch - 'a'];
    }

    public void put(char ch, TrieNode node){
        links[ch - 'a'] = node;
    }

    public void setEnd(){
        isEnd = true;
    }

    public boolean isEnd(){
        return isEnd;
    }
}
```
Trie树中最常见的两个操作：键的插入和查找
**向Trie树中插入键**
通过搜索Trie树来插入一个键。从根开始搜索它对应于第一个键字符的链接。有两种情况：
+ 链接存在。沿着链接移动到树的下一个子层。算法继续搜索下一个键字符
+ 链接不存在。创建一个新的节点，并将它与父节点的链接相连，该链接与当前的键字符相匹配。
重复以上步骤，直到到达键的最后一个字符，然后将当前节点标记为结束节点，算法完成。
时间复杂度：O(m)，空间复杂度：O(m)
```java
class Trie{
    private TrieNode root;

    public Trie(){
        root = new TrieNode();
    }

    //Insert a word into the trie
    public void insert(String word){
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++){
            char currentChar = word.charAt(i);
            if (!node.containKey(currentChar)){
                node.put(currentChar, new TrieNode());
            } else {
                node = node.get(currentChar);
            }
        }
        node.setEnd();
    }
}
```
**在Trie树中查找键**
每个键在Trie中表示为从根到内部节点或叶的路径。用第一个键字符从根开始，检查当前节点中与键字符对应的链接。有两种情况：
+ 存在链接。移动到该链接后面路径中的下一个节点，并继续搜索下一个键字符。
+ 不存在链接。若已无键字符，且当前结点标记为isEnd，则返回true。否则有两种可能，均返回false：
  + 还有键字符剩余，但无法跟随Trie树的键路径，找不到键。
  + 没有键字符剩余，但当前结点没有标记为isEnd，也就是说，待查找键只是Trie树中另一个键的前缀。
时间复杂度：O(m)，空间复杂度O(1)
```java
class Trie{
    ...

    //search a prefix or whole key in trie and returns the node where search ends
    private TrieNode searchPrefix(String word){
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++){
            char currentChar = word.charAt(i);
            if (node.containKey(currentChar)){
                node = node.get(currentChar);
            } else {
                return null;
            }
        }
        return node;
    }

    // Returns if the word is in the trie.
    public boolean search(String word){
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd();
    }
}
```
**查找trie树中的键前缀**
该方法与在 Trie 树中搜索键时使用的方法非常相似。我们从根遍历 Trie 树，直到键前缀中没有字符，或者无法用当前的键字符继续 Trie 中的路径。与上面提到的“搜索键”算法唯一的区别是，到达键前缀的末尾时，总是返回 true。我们不需要考虑当前 Trie 节点是否用 “isend” 标记，因为我们搜索的是键的前缀，而不是整个键。
时间复杂度：O(m)，空间复杂度O(1)
```java
class Trie{
    ...

    //return if there is any word in the trie that starts with given prefix
    public boolean startsWith(String prefix){
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }
}
```

**并查集**
适用于组团配对问题（Group or not？）

**基本操作**
+ makeSet(s):建立一个新的并查集，其中包含s个单元素集合
+ unionSet(x,y)：把元素x和元素y所在的集合合并，要求x和y所在的几个不想交，如果相交则不合并。
+ find(x)：找到元素x所在的集合的代表，该操作也可以用于判断两个元素是否位于同一个集合，只要将它们各自的代表比较一下就可以了

```java
class UnionFind{
    private int count = 0;
    private int[] parent;
    public UnionFind(int n){
        count = n;
        parent = new int[n];
        for(int i = 0; i < n ; i++){
            parent[i] = i;
        }
    }

    public int find(int p){
        while (p != parent[p]){
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }
    public void union(int p, int q){
        int rootP = find(p);
        int rootQ = find(q);
        if(rootP == rootQ) return;
        parent[rootP] = rootQ;
        count--;
    }
}
```

### 14.2.3.leedcode题目：[212.单词搜索 II](https://leetcode-cn.com/problems/word-search-ii/)


### 14.2.4.课后作业
分析单词搜索 2 用 Tire 树方式实现的时间复杂度，请同学们提交在学习总结中。

### 14.2.5.leedcode题目：[547.朋友圈](https://leetcode-cn.com/problems/friend-circles/)
班上有 N 名学生。其中有些人是朋友，有些则不是。他们的友谊具有是传递性。如果已知 A 是 B 的朋友，B 是 C 的朋友，那么我们可以认为 A 也是 C 的朋友。所谓的朋友圈，是指所有朋友的集合。

给定一个 N * N 的矩阵 M，表示班级中学生之间的朋友关系。如果M[i][j] = 1，表示已知第 i 个和 j 个学生互为朋友关系，否则为不知道。你必须输出所有学生中的已知的朋友圈总数。
```java
示例 1：
输入：
[[1,1,0],
 [1,1,0],
 [0,0,1]]
输出：2 
解释：已知学生 0 和学生 1 互为朋友，他们在一个朋友圈。
第2个学生自己在一个朋友圈。所以返回 2 。

示例 2：
输入：
[[1,1,0],
 [1,1,1],
 [0,1,1]]
输出：1
解释：已知学生 0 和学生 1 互为朋友，学生 1 和学生 2 互为朋友，所以学生 0 和学生 2 也是朋友，所以他们三个在一个朋友圈，返回 1 。

提示：
1 <= N <= 200
M[i][i] == 1
M[i][j] == M[j][i]
```



### 14.2.6.leedcode题目：[200.岛屿数量](https://leetcode-cn.com/problems/number-of-islands/)
给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。
此外，你可以假设该网格的四条边均被水包围。
```java
示例 1:
输入:
[
['1','1','1','1','0'],
['1','1','0','1','0'],
['1','1','0','0','0'],
['0','0','0','0','0']
]
输出: 1

示例 2:
输入:
[
['1','1','0','0','0'],
['1','1','0','0','0'],
['0','0','1','0','0'],
['0','0','0','1','1']
]
输出: 3
解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。
```
**题解**
**并查集**
```java
package com.company;

/**
 * @author jipan
 * @version 1.0
 * @date 2020/9/11 21:22
 */

class UnionFind2 {

    private int[] id; // access to component id(site indexed)
    private int count; // number of components
    private int[] size; //每个组的大小

    public UnionFind2(int N) {
        // Initialize component id array
        count = N;   //初始组的数目为节点个数
        id = new int[N];
        size = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;  //初始情况每个节点的组号都是数组的索引
            size[i] = 1; // 初始情况每个组大小都是1
        }
    }

    public int count() {
        return count;
    }

    public int find(int p) {
        while (p != id[p]) {
            // 将p节点的父节点设置为它的爷爷节点(路径压缩)
            id[p] = id[id[p]];
            p = id[p];
        }
        return p;
    }

    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) {
            return;
        }
        // 将小树作为大树的子树(合成树更扁平，减少树的深度)
        if (size[pRoot] < size[qRoot]) {
            id[pRoot] = qRoot;
            size[qRoot] += size[pRoot];
        } else {
            id[qRoot] = pRoot;
            size[pRoot] += size[qRoot];
        }
        count--;

    }

}

public class Solution547_2 {
    public int findCircleNum(int[][] M) {
        UnionFind2 unionFind2 = new UnionFind2(M.length);
        for (int i = 0; i < M.length; i++){
            for (int j = 0; j < i ; j++){
                if (M[i][j] == 1){
                    unionFind2.union(i,j);
                }
            }
        }
        return unionFind2.count();
    }
}
```


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
