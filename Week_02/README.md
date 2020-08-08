学习笔记
- [4.哈希表](#4哈希表)
  - [4.1.概念](#41概念)
  - [4.2.应用](#42应用)
  - [4.3.实战题目](#43实战题目)
- [5.树、二叉树、二叉搜索树](#5树二叉树二叉搜索树)
  - [5.1.树（Tree）](#51树tree)
    - [5.1.1.二叉树遍历Pre-order/In-order/Post-order](#511二叉树遍历pre-orderin-orderpost-order)
    - [5.1.2.二叉搜索树(Binary Search Tree)](#512二叉搜索树binary-search-tree)
  - [5.2.实战题目](#52实战题目)
    - [5.2.1.leedccde题目：94、二叉树的中序遍历](#521leedccde题目94二叉树的中序遍历)
    - [5.2.2.leedcode题目：144、二叉树的前序遍历](#522leedcode题目144二叉树的前序遍历)

# 4.哈希表
## 4.1.概念 
**<font color=#FF0000>哈希表</font>**(Hash table)，也叫散列表，是根据关键码值(key value)而直接进行访问的数据结构。
它通过吧关键码值映射到表中一个位置来访问记录，以加快查找的速度。
这个映射函数叫做散列函数(Hash Function),存放记录的数组叫做哈希表(或散列表)。

## 4.2.应用
+ 电话号薄
+ 用户信息表
+ 缓存（LRU Cache）
+ 键值对储存（Redis）---后端会用

Hash Function

Hash Collisions

Hash Table API（java code）
+ [Map: key-value对，key不重复](https://docs.oracle.com/en/java/javase/12/docs/api/java.base/java/util/Set.html)
   > + new HashMap() / new TreeMap()
   > + map.set(key, value)
   > + map.get(key)
   > + map.has(key)
   > + map.size()
   > + map.clear()
   > + **map.getOrDefault(key, defaultValue)**
+ [Set: 不重复元素的集合](https://docs.oracle.com/en/java/javase/12/docs/api/java.base/java/util/Map.html)
   > + new HashSet() / new TreeSet()
   > + set.add(value)
   > + set.delete(value)
   > + set.hash(value)

## 4.3.实战题目
解题四步法
  > + claification
  > + possible solution --> optimal(time & space)
  > + code
  > + test cases 
+ 第一题：[leedCode-242、有效的字母异位词](https://leetcode-cn.com/problems/valid-anagram/description/)
  + 1、暴力法：sort，sort_str 相等？  O(nlogn)
  ```java
   public boolean isAnagram(String s, String t) {
      if (s.length() != t.length()) return false;
      char[] s1 = s.toCharArray();
      char[] t1 = t.toCharArray();
      Arrays.sort(s1);
      Arrays.sort(t1);
      return Arrays.equals(s1,t1);
   }
  ```
  + 2、hash，map --> 统计每个字符的频次


# 5.树、二叉树、二叉搜索树

## 5.1.树（Tree）

树可以看做是链表衍生的，根节点，子节点（左结点，右节点），父节点

- Linked list是特殊化的Tree
- Tree是特殊化的Graph

很多工程需要解决二维的问题

### 5.1.1.二叉树遍历Pre-order/In-order/Post-order

示例代码
```java
public class TreeNode{
   public int val;
   public TreeNode left,right;
   public TreeNode(int val){
      this.val = val;
      this.left = null;
      this.right = null;
   }
}
```
+ 1.前序（Pre-order）：根-左-右
+ 2.中序（In-order）：左-根-右
+ 3.后序（Post-order）：左-右-根
```python
def preorder(self,root):
   if root:
      self.traverse_path.append(root.val)
      self.preorde(root.left)
      self.preorder(root.right)

def inorder(self,root):
   if root:
      self.inorder(root.left)
      self.traverse_path.append(root.val)
      self.inorder(root.right)

def postorder(self.root):
   if root:
      self.postorder(root.left)
      self.postorder(root.right)
      self.traverse_path.append(root.val)
```

### 5.1.2.二叉搜索树(Binary Search Tree)

二叉搜索树，也称二叉排序树、有序二叉树（Order Binary Tree）、排序二叉树（Sorted Binary Tree），是指一棵空树或者具有下列性质的二叉树：
+ 1.左子树上<font color=#FF8C00>所有节点</font>的值均小于它的根节点的值；
+ 2.右子树上<font color=#FF8C00>所有节点</font>的值均大于它的根节点的值
+ 3.以此类推：左、右子树也分别为二叉查找树。（这就是**重复性**）

中序遍历：升序排列

常见操作：
+ 1、查询
+ 2、插入新节点（创建）
+ 3、删除
  
  [二叉搜索树demo](https://visualgo.net/zh/bst?slide=1)  

## 5.2.实战题目

### 5.2.1.leedccde题目：[94、二叉树的中序遍历](https://leetcode-cn.com/problems/binary-tree-inorder-traversal/)
+ 第一种解法：递归
  + [递归的模板](https://shimo.im/docs/EICAr9lRPUIPHxsH/read)
```java
public void recur(int level, int param) {
   //termintor（终止条件）
   if (level > MAX_LEVEL) {
      //process result
      return;
   }
   //process current logic
   process(level, param);
   //drill down
   recur(level:level + 1, newParam);
   //restore current status
}
```
 
借助一个辅助函数实现递归
```java
public List<Integer> inorderTraversal(TreeNode root) {
   List<Integer> ans = new ArrayList<>();
   helper(root,ans);
   return ans;
}
private void helper(TreeNode root, List<Integer> ans) {
   if (root != null){
      if (root.left != null){
            helper(root.left,ans);
      }
      ans.add(root.val);
      if (root.right != null){
            helper(root.right,ans);
      }
   }
}
```
**复杂度**：时间复杂度：O(n)。递归函数 T(n) = 2 \cdot T(n/2)+1T(n)=2⋅T(n/2)+1。 空间复杂度：最坏情况下需要空间O(n)，平均情况为O(\log n)O(logn)。

+ 第二种解法：基于栈的遍历
在递归的基础上，使用栈的方式
```java
public List<Integer> inorderTraversal2(TreeNode root){
   List<Integer> ans = new ArrayList<>();
   Stack<TreeNode> stack = new Stack<>();
   TreeNode curr = root;
   while (curr != null || !stack.isEmpty()){
      while (curr != null){
            stack.push(curr);
            curr = curr.left;
      }
      curr = stack.pop();
      ans.add(curr.val);
      curr = curr.right;
   }
   return ans;
}
```
复杂度：时间复杂度O(n)，空间复杂度O(n)

+ 第三种解法：莫里斯遍历
  
  先了解下 [线索二叉树](https://baike.baidu.com/item/%E7%BA%BF%E7%B4%A2%E4%BA%8C%E5%8F%89%E6%A0%91/10810037?fr=aladdin) 和 [莫里斯解法](https://stackoverflow.com/questions/5502916/explain-morris-inorder-tree-traversal-without-using-stacks-or-recursion) 后再学习此解法

### 5.2.2.leedcode题目：[144、二叉树的前序遍历](https://leetcode-cn.com/problems/binary-tree-preorder-traversal/)

+ 第一种解法：递归
```java
public List<Integer> preorderTraversalRecur(TreeNode root) {
   List<Integer> ans = new ArrayList<>();
   helper(root, ans);
   return ans;
}
public void helper(TreeNode root, List<Integer> ans){
   if (root != null){
      ans.add(root.val);
      if (root.left != null) helper(root.left,ans);
      if (root.right != null) helper(root.right,ans);
   }
}
```
复杂度：时间复杂度O(n)，空间复杂度O(n)

+ 第二种解法：使用栈迭代
```java
public List<Integer> preorderTraversal_stack(TreeNode root){
   List<Integer> ans = new ArrayList<>();
   Stack<TreeNode> stack = new Stack<>();
   if (root == null){
      return ans;
   }
   stack.add(root);
   while (!stack.isEmpty()){
      TreeNode node = stack.pop();
      ans.add(node.val);
      if (node.right != null){
            stack.add(node.right);
      }
      if (node.left != null){
            stack.add(node.left);
      }
   }
   return ans;
}
```
复杂度：时间复杂度O(n)，空间复杂度O(n)

[调用栈的思路讲解](https://leetcode-cn.com/problems/binary-tree-preorder-traversal/solution/miao-sha-quan-chang-ba-hou-lang-by-sonp/)

  