学习笔记
- [1.数据结构&算法](#1数据结构算法)
  - [1.2.数据结构](#12数据结构)
  - [1.3.算法](#13算法)
- [2.数组、链表、跳表](#2数组链表跳表)
  - [2.1数组](#21数组)
    - [2.1.1.数组的操作函数的复杂度](#211数组的操作函数的复杂度)
    - [2.1.2.数组的代码实现](#212数组的代码实现)
    - [2.1.3.顺序表的优缺点](#213顺序表的优缺点)
  - [2.2.链表](#22链表)
    - [2.2.1.链表操作函数的复杂度](#221链表操作函数的复杂度)
    - [2.2.2.链表的代码实现](#222链表的代码实现)
  - [leedCode题目](#leedcode题目)
  - [参考链接](#参考链接)
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

结点类设计如下
```java
public class Node {
    Object data;//结点的数据元素
    Node next;//表示下一个结点的对象引用
    //用于头结点的构造函数
    Node(Node nextval){
        next = nextval;
    }
    //用于其他结点的构造函数
    Node(Object obj, Node nextval){
        data = obj;
        next = nextval;
    }

    public Object getData() {
        return data;
    }

    public Node getNext() {
        return next;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void setNext(Node next) {
        this.next = next;
    }
    //转换data为String类型
    public String toString() {
        return data.toString();
    }
}
```
单链表的成员变量需要三个：一是头指针，二是单链表中数据元素个数，三是表示单链表当前结点位置的成员变量。

单链表类设计如下
```java

```

## leedCode题目
+ [26.删除数组中的重复项](https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/)
+ 



## 参考链接
+ [Java 源码分析（ArrayList）](http://developer.classpath.org/doc/java/util/ArrayList-source.html)
+ [Linked List 的标准实现代码](https://www.geeksforgeeks.org/implementing-a-linked-list-in-java-using-class/)
+ [Linked List 示例代码](http://www.cs.cmu.edu/~adamchik/15-121/lectures/Linked%20Lists/code/LinkedList.java) 
+ [Java 源码分析（LinkedList）](http://developer.classpath.org/doc/java/util/LinkedList-source.html)
+ LRU Cache - Linked list： [LRU 缓存机制](https://leetcode-cn.com/problems/lru-cache/)
+ Redis - Skip List：[跳跃表、为啥 Redis 使用跳表（Skip List）而不是使用 Red-Black？](https://www.zhihu.com/question/20202931)

 




## 重点学习20个最常用的最基础的数据结构和算法
+ 10个数据结构: 数组，链表，栈，队列，散列表，二叉树，堆，跳表，图，Trie树
+ 10个算法： 递归，排序，二分查找，搜索，哈希算法，贪心算法，分治算法，回溯算法，动态规划，字符串匹配算法
# 参考

<div id = "refer-1"></div>

- [1][数据结构之数组](https://www.cnblogs.com/fengxiaoyuan/p/10934399.html)

<div id = "refer-2"></div>

- [2]数据结构--Java语音描述，朱战立，清华大学出版社，2015年12月第一版