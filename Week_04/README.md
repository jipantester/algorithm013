- [10.深度优先搜索和广度优先搜索](#10dot深度优先搜索和广度优先搜索)
  - [10.1.遍历](#10dot1遍历)
  - [10.2.深度优先搜索（Depth-First-Search)](#10dot2深度优先搜索depth-first-search)
  - [10.3.广度优先搜索（Breadth-First-Search）](#10dot3广度优先搜索breadth-first-search)
  - [10.4.实战题目](#10dot4实战题目)
    - [10.4.1.leedcode题目：102.二叉树的层序遍历](#10dot41leedcode题目102二叉树的层序遍历httpsleetcode-cncomproblemsbinary-tree-level-order-traversaldescription)
    - [10.4.2.leedcode题目：433.最小基因变化](#10dot42leedcode题目433最小基因变化httpsleetcode-cncomproblemsminimum-genetic-mutationdescription)
    - [10.4.3.leedcode题目：22.括号生成](#10dot43leedcode题目22括号生成httpsleetcode-cncomproblemsgenerate-parenthesesdescription)
    - [10.4.4.leedcode题目：515.在每个树行中找最大值](#10dot44leedcode题目515在每个树行中找最大值httpsleetcode-cncomproblemsfind-largest-value-in-each-tree-rowdescription)
    - [10.4.5.leedcode题目：127.单词接龙](#10dot45leedcode题目127单词接龙httpsleetcode-cncomproblemsword-ladderdescription)
    - [10.4.6.leedcode题目：126.单词接龙 II](#10dot46leedcode题目126单词接龙-iihttpsleetcode-cncomproblemsword-ladder-iidescription)
    - [10.4.7.leedcode题目：200.岛屿数量](#10dot47leedcode题目200岛屿数量httpsleetcode-cncomproblemsnumber-of-islands)
    - [10.4.8.leedcode题目：529.扫雷游戏](#10dot48leedcode题目529扫雷游戏httpsleetcode-cncomproblemsminesweeperdescription)
- [11.贪心算法](#11dot贪心算法)
  - [11.1.](#11dot1)
  - [11.2.实战题目](#11dot2实战题目)
    - [11.2.1.leedcode题目：322.零钱兑换](#11dot21leedcode题目322零钱兑换httpsleetcode-cncomproblemscoin-change)
    - [11.2.2.leedcode题目：860.柠檬水找零](#11dot22leedcode题目860柠檬水找零httpsleetcode-cncomproblemslemonade-changedescription)
    - [11.2.3.leedcode题目：122.买卖股票的最佳时机 II](#11dot23leedcode题目122买卖股票的最佳时机-iihttpsleetcode-cncomproblemsbest-time-to-buy-and-sell-stock-iidescription)
    - [11.2.4.leedcode题目：455.分发饼干](#11dot24leedcode题目455分发饼干httpsleetcode-cncomproblemsassign-cookiesdescription)
    - [11.2.5.leedcode题目：874.模拟行走机器人](#11dot25leedcode题目874模拟行走机器人httpsleetcode-cncomproblemswalking-robot-simulationdescription)
    - [11.2.6.leedcode题目：55.跳跃游戏](#11dot26leedcode题目55跳跃游戏httpsleetcode-cncomproblemsjump-game)
    - [11.2.7.leedcode题目：45.跳跃游戏 II](#11dot27leedcode题目45跳跃游戏-iihttpsleetcode-cncomproblemsjump-game-ii)
- [12.二分查找](#12dot二分查找)
  - [12.1.](#12dot1)
  - [12.2.实战题目](#12dot2实战题目)
    - [12.2.1.leedcode题目：69. x 的平方根](#12dot21leedcode题目69-x-的平方根httpsleetcode-cncomproblemssqrtx)
    - [12.2.2.leedcode题目：367. 有效的完全平方数](#12dot22leedcode题目367-有效的完全平方数httpsleetcode-cncomproblemsvalid-perfect-square)
    - [12.2.3.leedcode题目：33. 搜索旋转排序数组](#12dot23leedcode题目33-搜索旋转排序数组httpsleetcode-cncomproblemssearch-in-rotated-sorted-array)
    - [12.2.4.leedcode题目：74. 搜索二维矩阵](#12dot24leedcode题目74-搜索二维矩阵httpsleetcode-cncomproblemssearch-a-2d-matrix)
    - [12.2.5.leedcode题目：153. 寻找旋转排序数组中的最小值](#12dot25leedcode题目153-寻找旋转排序数组中的最小值httpsleetcode-cncomproblemsfind-minimum-in-rotated-sorted-array)
    - [12.2.6.课后作业](#12dot26课后作业)




# 10.深度优先搜索和广度优先搜索

## 10.1.遍历

+ 遍历搜索
  
![avatar](遍历搜索.jpg)

示例代码：

python

```python
class TreeNode:
    def __init__(self, val):
        self.val = val
        self.left, self.right = None, None
```

Java

```java
public class TreeNode{
    public int val;
    public TreeNode left, right;
    public TreeNode(int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }
}
```

C++

```C++
struct TreeNode{
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x): val(x), left(NULL), right(NULL) {}
}
```

+ 搜索 - 遍历
  + 每个节点都要访问一次
  + 每个节点仅仅要访问一次
  + 对于节点的访问顺序不限
    + 深度优先：depth first search
    + 广度优先：breadth first search

代码示例：

python 
```python
def dfs(node):
    if node in visited:
        # already visited
        return
    
    visited.add(node)

    # process current node
    #...# logic here

    dfs(node.left)
    dfs(node.right)
```

## 10.2.深度优先搜索（Depth-First-Search)

[DFS 代码模板](https://shimo.im/docs/UdY2UUKtliYXmk8t/read)

+ **DFS 代码 - 递归写法**

Python

```python
visited = set()

def dfs(node, visited):
    if node in visited:
    # already visited
        return
    
    visited.add(node)

    #process current node here
    for next_node in node.children():
        if not next_node in visited:
            dfs(next node, visited)
```

Java

```java
public List<List<Integer>> levelorder(TreeNode root) {
    List<List<Integer>> allResults = new ArrayList<>();
    if (root == null) {
        return allResults;
    }
    travel(root, 0, allResults);
    return allResults;
}

private void travel(TreeNode root, int level, List<List<Integer>> results){
    if(results.size() == level){
        resuls.add(new ArrayList<>());
    }
    results.get(level).add(root.val);
    if(root.left != null){
        travel(root.left, level+1, results);
    }
    if(root.right != null){
        travel(root.right, level+1, results);
    }
}
```

+ **DFS 代码 - 非递归写法**


Python

```python
def DFS(self,tree):
    if tree.root is None:
        return []
    
    visited, stack = [] , [tree.root]

    while stack:
        node = stack.pop()
        visited.add(node)

        process(node)
        node = generate_related_nodes(node)
        stack.push(nodes)
    
    # other processing work
```

Java

```java

```
## 10.3.广度优先搜索（Breadth-First-Search）

[BFS 代码模板](https://shimo.im/docs/ZBghMEZWix0Lc2jQ/read)

BFS 代码

python

```python
def BFS(graph, start, end):

    queue = []
    queue.append([start])
    visited.add(start)

    while queue:
        node = queue.pop()
        visited.add(node)

        process(node)
        nodes = generate_related_nodes(node)
        queue.push(nodes)

    # other processing work
```

java

```java
public class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x){
        val = x;
    }
}

public List<List<Integer>> levelorder(TreeNode root){
    List<List<Integer>> allResults = new ArrayList<()>;
    if(root == null){
        return allResults;
    }

    Queue<TreeNode> nodes = new LinkedList<();
    nodes.add(root);
    while(!nodes.isEmpty()){
        int size = nodes.size();
        List<Integer> results = new ArrayList<>();
        for(int i = 0; i < size; i++){
            TreeNOde node = nodes.poll();
            results.add(node.val);
            if(node.left != null){
                nodes.add(node.left);
            }
            if(node.right != null){
                nodes.add(node.right);
            }
        }
        allResults.add(results);
    }
    return allResults;
}
```

## 10.4.实战题目

### 10.4.1.leedcode题目：[102.二叉树的层序遍历](https://leetcode-cn.com/problems/binary-tree-level-order-traversal/#/description)


### 10.4.2.leedcode题目：[433.最小基因变化](https://leetcode-cn.com/problems/minimum-genetic-mutation/#/description)


### 10.4.3.leedcode题目：[22.括号生成](https://leetcode-cn.com/problems/generate-parentheses/#/description)


### 10.4.4.leedcode题目：[515.在每个树行中找最大值](https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row/#/description)


### 10.4.5.leedcode题目：[127.单词接龙](https://leetcode-cn.com/problems/word-ladder/description/)


### 10.4.6.leedcode题目：[126.单词接龙 II](https://leetcode-cn.com/problems/word-ladder-ii/description/)


### 10.4.7.leedcode题目：[200.岛屿数量](https://leetcode-cn.com/problems/number-of-islands/)


### 10.4.8.leedcode题目：[529.扫雷游戏](https://leetcode-cn.com/problems/minesweeper/description/)



# 11.贪心算法

## 11.1.

[动态规划定义](https://zh.wikipedia.org/wiki/%E5%8A%A8%E6%80%81%E8%A7%84%E5%88%92)

## 11.2.实战题目

### 11.2.1.leedcode题目：[322.零钱兑换](https://leetcode-cn.com/problems/coin-change/)

### 11.2.2.leedcode题目：[860.柠檬水找零](https://leetcode-cn.com/problems/lemonade-change/description/)


### 11.2.3.leedcode题目：[122.买卖股票的最佳时机 II](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/description/)


### 11.2.4.leedcode题目：[455.分发饼干](https://leetcode-cn.com/problems/assign-cookies/description/)


### 11.2.5.leedcode题目：[874.模拟行走机器人](https://leetcode-cn.com/problems/walking-robot-simulation/description/)


### 11.2.6.leedcode题目：[55.跳跃游戏](https://leetcode-cn.com/problems/jump-game/)

### 11.2.7.leedcode题目：[45.跳跃游戏 II](https://leetcode-cn.com/problems/jump-game-ii/)


# 12.二分查找

## 12.1.

[二分查找代码模板](https://shimo.im/docs/xvIIfeEzWYEUdBPD/read)

[Fast InvSqrt()扩展阅读](https://www.beyond3d.com/content/articles/8/)

## 12.2.实战题目

### 12.2.1.leedcode题目：[69. x 的平方根](https://leetcode-cn.com/problems/sqrtx/)


### 12.2.2.leedcode题目：[367. 有效的完全平方数](https://leetcode-cn.com/problems/valid-perfect-square/)


### 12.2.3.leedcode题目：[33. 搜索旋转排序数组](https://leetcode-cn.com/problems/search-in-rotated-sorted-array/)


### 12.2.4.leedcode题目：[74. 搜索二维矩阵](https://leetcode-cn.com/problems/search-a-2d-matrix/)


### 12.2.5.leedcode题目：[153. 寻找旋转排序数组中的最小值](https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/)


### 12.2.6.课后作业

使用二分查找，寻找一个半有序数组 [4, 5, 6, 7, 0, 1, 2] 中间无序的地方

