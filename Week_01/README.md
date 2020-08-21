学习笔记
- [1.数据结构&算法](#1dot数据结构算法)
  - [1.2.数据结构](#1dot2数据结构)
  - [1.3.算法](#1dot3算法)
- [2.数组、链表、跳表](#2dot数组链表跳表)
  - [2.1数组](#2dot1数组)
    - [2.1.1.数组的操作函数的复杂度](#2dot11数组的操作函数的复杂度)
    - [2.1.2.数组的代码实现](#2dot12数组的代码实现)
    - [2.1.3.顺序表的优缺点](#2dot13顺序表的优缺点)
  - [2.2.链表](#2dot2链表)
    - [2.2.1.链表操作函数的复杂度](#2dot21链表操作函数的复杂度)
    - [2.2.2.链表的代码实现](#2dot22链表的代码实现)
  - [2.3.跳表](#2dot3跳表)
  - [2.4.参考链接](#2dot4参考链接)
  - [2.5.实战题目](#2dot5实战题目)
    - [2.5.1.leedcode题目：11.盛水最多的容器](#2dot51leedcode题目11盛水最多的容器httpsleetcode-cncomproblemscontainer-with-most-water)
    - [2.5.2.leedcode题目：283.移动零](#2dot52leedcode题目283移动零httpsleetcode-cncomproblemsmove-zeroes)
    - [2.5.3.leedcode题目：70.爬楼梯](#2dot53leedcode题目70爬楼梯httpsleetcode-cncomproblemsclimbing-stairsutm_sourcelcusutm_mediumip_redirect_q_unsutm_campaigntransfer2china)
    - [2.5.4.leedcode题目：15.三数之和](#2dot54leedcode题目15三数之和httpsleetcode-cncomproblems3sum)
    - [2.5.5.leedcode题目：26.删除数组中的重复项](#2dot55leedcode题目26删除数组中的重复项httpsleetcode-cncomproblemsremove-duplicates-from-sorted-array)
    - [2.5.6.leedcode题目：206. Reverse Linked List](#2dot56leedcode题目206-reverse-linked-listhttpsleetcodecomproblemsreverse-linked-list)
    - [2.5.7.leedcode题目：24. Swap Nodes in Pairs](#2dot57leedcode题目24-swap-nodes-in-pairshttpsleetcodecomproblemsswap-nodes-in-pairs)
    - [2.5.8.leedcode题目：141. Linked List Cycle](#2dot58leedcode题目141-linked-list-cyclehttpsleetcodecomproblemslinked-list-cycle)
    - [2.5.9.leedcode题目：142. Linked List Cycle II](#2dot59leedcode题目142-linked-list-cycle-iihttpsleetcodecomproblemslinked-list-cycle-ii)
    - [2.5.10.leedcode题目：25. Reverse Nodes in k-Group](#2dot510leedcode题目25-reverse-nodes-in-k-grouphttpsleetcodecomproblemsreverse-nodes-in-k-group)
- [3.栈、队列、优先队列、双端队列](#3dot栈队列优先队列双端队列)
  - [3.1.栈(Stack)、队列(queue)、双端队列(Deque)](#3dot1栈stack队列queue双端队列deque)
  - [3.2.优先队列(Priority Queue)](#3dot2优先队列priority-queue)
  - [3.3.实战题目](#3dot3实战题目)
    - [3.3.1.leedcode题目：20.有效的括号](#3dot31leedcode题目20有效的括号httpsleetcode-cncomproblemsvalid-parentheses)
    - [3.3.2.leedcode题目：155.最小栈](#3dot32leedcode题目155最小栈httpsleetcode-cncomproblemsmin-stack)
    - [3.3.3.leedcode题目：84.柱状图中最大的矩形](#3dot33leedcode题目84柱状图中最大的矩形httpsleetcode-cncomproblemslargest-rectangle-in-histogram)
    - [3.3.4.leedcode题目：239.滑动窗口最大值](#3dot34leedcode题目239滑动窗口最大值httpsleetcode-cncomproblemssliding-window-maximum)
    - [3.3.5.leedcode题目：641.设计循环双端队列](#3dot35leedcode题目641设计循环双端队列httpsleetcode-cncomproblemsdesign-circular-dequeutm_sourcelcusutm_mediumip_redirect_q_unsutm_campaigntransfer2china)
    - [3.3.6.leedcode题目：42.Trapping Rain Water](#3dot36leedcode题目42trapping-rain-waterhttpsleetcodecomproblemstrapping-rain-water)
    - [3.3.7.课后作业](#3dot37课后作业)
    - [3.3.8.课后作业](#3dot38课后作业)
  - [重点学习20个最常用的最基础的数据结构和算法](#重点学习20个最常用的最基础的数据结构和算法)
- [参考](#参考)
# 1.数据结构&算法
## 1.2.数据结构
+ 一维：
  + 基础：数组array(string),链表linked list
  + 高级：栈stack，队列queue，双端队列deque，集合set，映射map（hash or map），etc
+ 二维：
  + 基础：树tree，图graph
  + 高级：二叉搜索树binary search tree（red-black tree，AVL），堆heap，并查集disjoint set，字典树Trie，etc
+ 特殊：
  + 位运算 Bitwise，布隆过滤器 BloomFilter
  + LRU Cache
## 1.3.算法
+ if-else，switch --> branch
+ for,while loop --> Iteration
+ 递归 Recursion（Divide & Conquer,Backtrace)
+ 搜索 Search:深度优先搜索 Depth first search，广度优先搜索Br eadth first search，A*，etc
+ 动态规划 Dynamic Programming
+ 二分查找 Binary Search
+ 贪心 Greedy
+ 数学 Math，几何 Geometry

# 2.数组、链表、跳表

## 2.1数组

**<font color = #FF000>数组</font>**(Array)是一种**线性表**数据结构。使用一组**连续的内存空间**，来存储一组具有**相同类型**的数据。[<sup>1</sup>](#refer-1)

**<font color = #1E90FF>线性表</font>**(Linear List)就是数据排成像一条线一样的结构。每个线性表上的数据最多只有两个方向。除了数组，链表、队列、栈也是线性表结构。
![avatar](https://img2018.cnblogs.com/blog/1468033/201905/1468033-20190527230141394-707635789.png)
**<font color = #1E90FF>非线性表</font>**(Nonlinear List)中的数据之间不是简单的前后关系，比如二叉树、堆、图等。
![avatar](https://img2018.cnblogs.com/blog/1468033/201905/1468033-20190527230423327-1590652789.png)
**连续的内存空间和相同的数据类型：**
![avatar](https://img2018.cnblogs.com/blog/1468033/201905/1468033-20190527230650537-1957403462.png)

### 2.1.1.数组的操作函数的复杂度
| 函数 | 功能描述 | 时间复杂度 |
|---|---|---|
| prepend | 在数组前端插入元素 | O(1) |
| append | 在数组后端插入元素 |O(1) |
| <font color=#FFA500>lookup</font> | 查找 | O(1) |
| <font color=#FFA500>insert</font> | 插入 | O(n) |
| <font color=#FFA500>delete</font> | 删除 | O(n) |
| size | 求元素个数 | |
| isEmpty | 判空 | |

### 2.1.2.数组的代码实现
先定义一个线性表抽象数据类型的Java接口[<sup>2</sup>](#refer-2)，如下
```java
public interface List {
    public boolean prepend(Object obj) throws Exception;//在数组前端插入元素，成功后返回true
    public boolean append(Object obj) throws Exception;//在数组后端插入元素，成功后返回true
    public Object lookup(int index) throws Exception;//查找，找到后返回这个元素
    public void insert(int index, Object obj) throws Exception;//在下标为index的位置插入元素
    public boolean delete(int index) throws Exception;//删除下标为index的元素，成功后返回true
    public int size();//求元素个数
    public boolean isEmpty();//是否为空
}
```
数组类设计如下

**<font color=#FF0000>遗留：prepend函数没有写</font>**
```java
public class SeqList implements List {

    final  int defaultSize = 10;
    int maxSize;
    int size;
    Object[] listArray;

    //构造函数
    public SeqList(int len){
        maxSize = len;
        listArray = new Object[maxSize];
        size = 0;
    }
    public SeqList(){
        maxSize = defaultSize;
        listArray = new Object[defaultSize];
        size = 0;
    }
    //在数组前端插入元素,没有写
    @Override
    public boolean prepend(Object obj) throws Exception {

        return false;
    }
    //在数组后端添加元素，时间复杂度O(n)
    @Override
    public boolean append(Object obj) throws Exception {
        insert(size,obj);
        return true;
    }
    //查找元素，时间复杂度O(1)
    @Override
    public Object lookup(int index) throws Exception {
        if (index < 0 || index >= size) {
            throw new Exception("参数错误");
        }
        return listArray[index];
    }

    @Override
    //在index位置插入元素，时间复杂度为O(n)
    public void insert(int index, Object obj) throws Exception {
        if (size == maxSize){
            throw new Exception("数组已满，无法插入");
        }
        if (index < 0 || index > size) {
            throw new Exception("参数错误");
        }
        //此处采用倒序，listArray[size]位置为空的,将index位置后的元素向后移动一个位置，空出index的位置
        for (int i = size; i > index; i--) {
            listArray[i] = listArray[i-1];
        }
        //将obj元素赋值到index的位置
        listArray[index] = obj;
        //赋值后将数组总长加一
        size++;
    }
    //删除index位置的元素，时间复杂度O(n)
    @Override
    public boolean delete(int index) throws Exception {
        if (index < 0 || index >= size) {
            throw new Exception("参数错误");
        }
        for (int i = index; i < size-1; i++) {
            listArray[i] = listArray[i+1];
        }
        size--;
        return true;
    }
    //返回数组长度
    @Override
    public int size() {
        return size;
    }
    //是否为空
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
```
### 2.1.3.顺序表的优缺点
优点
+ 取数据元素操作的时间效率较高(即时间复杂度低)，内存空间利用效率高

缺点
+ 插入和删除操作时间复杂度高



## 2.2.链表

**<font color=#FF0000>链表</font>**(Linked List)整体看上去就像一条链子，每一个元素都有两个属性，即**该元素的值item**和**下一个元素next**。
### 2.2.1.链表操作函数的复杂度
| 函数 | 功能描述 | 时间复杂度 |
|---|---|---|
| prepend | 在链表前端插入元素 | O(1) |
| append | 在链表后端插入元素 | O(1) |
| <font color=#FFA500>lookup</font> |查找| O(n) |
| insert | 在链表的某个位置插入元素 | O(1) |
| getElement| 获取链表对应位置的元素||
| indexOf | 获取某元素在链表中的索引||
| update | 修改链表中某个位置上的元素的值||
| removeAt | 移除链表中某位置上的元素||
| remove | 移除链表中的某元素| O(1) |
| size |链表长度 | |
| isEmpty | 是否为空 | |
| toString | 以字符串的形式展示链表内的所有元素||

### 2.2.2.链表的代码实现
要设计单链表类，需要先设计结点类。一个结点类的成员变量有两个，一是结点的数据元素，另一个是表示下一个结点的next。

链表有：单链表、双向链表、循环链表

单链表结点类设计如下
```java
public class Node {
    Object data;//结点的数据元素
    Node next;//表示下一个结点的对象引用
    Node(Object obj, Node next){
        this.data = obj;
        this.next = next;
    }
    Node(Object obj){
        this(obj,null);
    }
}
```
链表有：单链表、双向链表、循环链表


## 2.3.跳表

**注意**：只能用于元素有序的情况

所以，跳表（skip list）对标的是平衡树（AVL Tree）和二分查找，是一种 插入/删除/搜索 都是O(logn)的数据结构，1989年出现。

最大的优势是原理简单，容易实现，方便扩展，效率更高，因此在一些热门的项目里用来替代平衡树，如Redis，levelDB等。

升维思想+空间换时间

## 2.4.参考链接
+ [Java 源码分析（ArrayList）](http://developer.classpath.org/doc/java/util/ArrayList-source.html)
+ [Linked List 的标准实现代码](https://www.geeksforgeeks.org/implementing-a-linked-list-in-java-using-class/)
+ [Linked List 示例代码](http://www.cs.cmu.edu/~adamchik/15-121/lectures/Linked%20Lists/code/LinkedList.java) 
+ [Java 源码分析（LinkedList）](http://developer.classpath.org/doc/java/util/LinkedList-source.html)
+ LRU Cache - Linked list： [LRU 缓存机制](https://leetcode-cn.com/problems/lru-cache/)
+ Redis - Skip List：[跳跃表、为啥 Redis 使用跳表（Skip List）而不是使用 Red-Black？](https://www.zhihu.com/question/20202931)


## 2.5.实战题目

**ARRAY 实战题目**

### 2.5.1.leedcode题目：[11.盛水最多的容器](https://leetcode-cn.com/problems/container-with-most-water/)

+ 第一种解法：双指针法
```java
//双指针法
public static int maxArea1(int[] height) {
    int left = 0, right = height.length - 1;
    int ans = 0;
    while (left < right){
        int area = Math.min(height[left],height[right]) * (right - left);
        ans = Math.max( ans , area);
        if (height[left] <= height[right]){
            left++;
        } else {
            right--;
        }
    }
    return ans;
}
```
**复杂度**：时间复杂度O(n)，空间复杂度O(1)


### 2.5.2.leedcode题目：[283.移动零](https://leetcode-cn.com/problems/move-zeroes/)

+ 第一种解法：暴力求解
```java
public void moveZeroes2(int[] nums){
    int[] ans = new int[nums.length];
    int j = 0;
    for (int i = 0; i < nums.length; i++){
        if (nums[i] != 0){
            ans[j] = nums[i];
            j++;
        }
    }
    for (int i = 0 ; i < nums.length ; i++){
        nums[i] = ans[i];
    }
}
```
**复杂度**：时间复杂度O(n)；空间复杂度O(n)。
+ 第一种解法：快慢指针法
```java
public void moveZeroes3(int[] nums){
    if (nums.length == 0) return;
    int j = 0;
    for (int i = 0; i < nums.length; i++){
        if (nums[i] != 0){
            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
            j++;
        }
    }
}
```
**复杂度**：时间复杂度O(n)；空间复杂度O(1)

### 2.5.3.leedcode题目：[70.爬楼梯](https://leetcode-cn.com/problems/climbing-stairs/?utm_source=LCUS&utm_medium=ip_redirect_q_uns&utm_campaign=transfer2china)

+ 第一种解法：递归
```java
//递归法
public int climbStairs(int n) {
    if (n <=2 ) return n;
    return climbStairs(n-1)+climbStairs(n-2);
}
```
+ 第二种解法：动态规划
```java
//动态规划
public int climbStairs2(int n){
    int a = 0, b = 0;
    int ans = 1;
    for (int i = 0; i < n; i++){
        a = b;
        b = ans;
        ans = a + b;
    }
    return ans;
}
```
+ 第三种解法：数学矩阵
```java

```
+ 第四种解法：通项公式
```java

```


### 2.5.4.leedcode题目：[15.三数之和](https://leetcode-cn.com/problems/3sum/)



### 2.5.5.leedcode题目：[26.删除数组中的重复项](https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/)


**Linked List 实战题目**

### 2.5.6.leedcode题目：[206. Reverse Linked List](https://leetcode.com/problems/reverse-linked-list/)


### 2.5.7.leedcode题目：[24. Swap Nodes in Pairs](https://leetcode.com/problems/swap-nodes-in-pairs/)


### 2.5.8.leedcode题目：[141. Linked List Cycle](https://leetcode.com/problems/linked-list-cycle/)


### 2.5.9.leedcode题目：[142. Linked List Cycle II](https://leetcode.com/problems/linked-list-cycle-ii/)


### 2.5.10.leedcode题目：[25. Reverse Nodes in k-Group](https://leetcode.com/problems/reverse-nodes-in-k-group/)




# 3.栈、队列、优先队列、双端队列


## 3.1.栈(Stack)、队列(queue)、双端队列(Deque)

+ *_Stack关键点：_* 先入后出；添加、删除皆为O（1）
+ *_Queue关键点：_* 先入先出；添加、删除皆为O（1）
+ *_双端队列：_* 两端可以进出的Queue--double ended queue；添加、删除皆为O（1）

[高性能的 container datatyps 库](https://docs.python.org/2/library/collections.html)

**栈（Stack）** [java实现](http://developer.classpath.org/doc/java/util/Stack-source.html)

代码示例：

Java
```java
Stack<Integer> stack = new Stack<>();
stack.push(1);
stack.push(2);
stack.push(3);
stack.push(4);
stack.push(5);
System.out.println(stack);
System.out.println(stack.search(4));

stack.pop();
stack.pop();
Integer topElement = stack.peek();
System.out.println(topElement);
System.out.println(" 3的位置 " + stack.search(3));
```

Python

```python
class Stack:
    def __int__(self):
        self.items=['x','y']

    def push(self,item):
        self.items.append(items)

    def pop(self):
        self.items.pop()

    def lengh(self);
        return len(self.items)
```
**队列（queue）**   [java实现](http://fuseyism.com/classpath/doc/java/util/Queue-source.html)，[python 的 heapq](https://docs.python.org/2/library/heapq.html)

代码示例：

Java

```java
Queue<String> queue = new LinkedList<>();
queue.offer("one");
queue.offer("two");
queue.offer("three");
queue.offer("four");

String polledElement = queue.poll();
System.out.println(polledElement);
System.out.println(queue);

String peekedElement = queue.peek();
System.out.println(peekedElement);
System.out.println(queue);

while (queue.size() > 0){
    System.out.println(queue.poll());
}
```

python

```python
class Queue:
    def __int__(self):
        self.queue=[]

    def enqueue(self,item):
        self.queue.append(item)

    def dequeue(self)；
        if len(self.queue) < 1:
            return None;
        return self.queue.pop(0)

    def size(self):
        return len(self.queue)
```

**双端队列(Deque)**

代码示例：
```java
Deque<String> deque = new LinkedList<>();

deque.push("a");
deque.push("b");
deque.push("c");
System.out.println(deque);

String str = deque.peek();
System.out.println(str);
System.out.println(deque);

while (deque.size()>0){
    System.out.println(deque.pop());
}

System.out.println(deque);
```

## 3.2.优先队列(Priority Queue)

+ 1.插入操作：O(1)
+ 2.取出操作：O(logN) - 按照元素的优先级取出
+ 3.底层具体实现的数据额结构较为多样和复杂：heap、bst，treap
  
[Java 的 PriorityQueue](https://docs.oracle.com/javase/10/docs/api/java/util/PriorityQueue.html)


## 3.3.实战题目

### 3.3.1.leedcode题目：[20.有效的括号](https://leetcode-cn.com/problems/valid-parentheses/)


### 3.3.2.leedcode题目：[155.最小栈](https://leetcode-cn.com/problems/min-stack/)


### 3.3.3.leedcode题目：[84.柱状图中最大的矩形](https://leetcode-cn.com/problems/largest-rectangle-in-histogram/)


### 3.3.4.leedcode题目：[239.滑动窗口最大值](https://leetcode-cn.com/problems/sliding-window-maximum/)


### 3.3.5.leedcode题目：[641.设计循环双端队列](https://leetcode-cn.com/problems/design-circular-deque/?utm_source=LCUS&utm_medium=ip_redirect_q_uns&utm_campaign=transfer2china)


### 3.3.6.leedcode题目：[42.Trapping Rain Water](https://leetcode.com/problems/trapping-rain-water/)


### 3.3.7.课后作业
用 add first 或 add last 这套新的 API 改写 Deque 的代码

### 3.3.8.课后作业
分析 Queue 和 Priority Queue 的源码







## 重点学习20个最常用的最基础的数据结构和算法
+ 10个数据结构: 数组，链表，栈，队列，散列表，二叉树，堆，跳表，图，Trie树
+ 10个算法： 递归，排序，二分查找，搜索，哈希算法，贪心算法，分治算法，回溯算法，动态规划，字符串匹配算法
# 参考

<div id = "refer-1"></div>

- [1][数据结构之数组](https://www.cnblogs.com/fengxiaoyuan/p/10934399.html)

<div id = "refer-2"></div>

- [2]数据结构--Java语音描述，朱战立，清华大学出版社，2015年12月第一版