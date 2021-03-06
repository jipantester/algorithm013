学习笔记
- [8.递归的实现、特性以及思维要点](#8递归的实现特性以及思维要点)
  - [8.1.递归知识点](#81递归知识点)
  - [8.2.实战题目](#82实战题目)
    - [8.2.1.leedcode题目：70.爬楼梯](#821leedcode题目70爬楼梯)
    - [8.2.2.leedcode题目：22.括号生成](#822leedcode题目22括号生成)
    - [8.2.3.leedcode题目：226.翻转二叉树](#823leedcode题目226翻转二叉树)
    - [8.2.4.leedcode题目：98.验证二叉搜索树](#824leedcode题目98验证二叉搜索树)
    - [8.2.5.leedcode题目：104.二叉树的最大深度](#825leedcode题目104二叉树的最大深度)
    - [8.2.6.leedcode题目：111.二叉树的最小深度](#826leedcode题目111二叉树的最小深度)
    - [8.2.7.leedcode题目：297.二叉树的序列化和反序列化](#827leedcode题目297二叉树的序列化和反序列化)
    - [8.2.8.leedcode题目：236.二叉树的最近公共祖先](#828leedcode题目236二叉树的最近公共祖先)
    - [8.2.9.leedcode题目：105.从前序与中序遍历序列构造二叉树](#829leedcode题目105从前序与中序遍历序列构造二叉树)
    - [8.2.10.leedcode题目：77.组合](#8210leedcode题目77组合)
    - [8.2.11.leedcode题目：46.全排列](#8211leedcode题目46全排列)
    - [8.2.12.leedcode题目：47.全排列II](#8212leedcode题目47全排列ii)
- [9.分治、回溯的实现和特性](#9分治回溯的实现和特性)
  - [9.1.知识点](#91知识点)
  - [9.2.实战题目](#92实战题目)
    - [9.2.1.leedcode题目：22.括号生成问题](#921leedcode题目22括号生成问题)
    - [9.2.2.leedcode题目：50.Pow(x,n)](#922leedcode题目50powxn)
    - [9.2.3.leedcode题目：78.子集](#923leedcode题目78子集)
    - [9.2.4.leedcode题目：169.多数元素](#924leedcode题目169多数元素)
    - [9.2.5.leedcode题目：17.电话号码的字母组合](#925leedcode题目17电话号码的字母组合)
    - [9.2.6.leedcode题目：51.N皇后](#926leedcode题目51n皇后)

# 8.递归的实现、特性以及思维要点

## 8.1.递归知识点

**java代码模板**
```java
public void recur(int level , int param){
  //终结条件
  if (level > MAX_LEVEL)  {
    //程序结果
    return;
  }
  //处理当前逻辑
  process(level, param);
  //下探到下一层
  recur(level: level + 1, newParam);
  //清理当前层
} 
```

**递归的思维要点**
+ 不要人肉递归（最大误区）
+ 找到最近最简单的方法， 将其拆解成可重复解决的问题（重复子问题）找最近重复性
+ 数学归纳法思维

[递归代码模板](https://shimo.im/docs/EICAr9lRPUIPHxsH/read)

## 8.2.实战题目

### 8.2.1.leedcode题目：[70.爬楼梯](https://leetcode-cn.com/problems/climbing-stairs/)

+ 第一个解法：递归
+ 第二个解法：动态规划
+ 第三个解法：数学矩阵解法
+ 第四个解法：通项公式 

### 8.2.2.leedcode题目：[22.括号生成](https://leetcode-cn.com/problems/generate-parentheses/)
数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
```java
示例：
输入：n = 3
输出：[
       "((()))",
       "(()())",
       "(())()",
       "()(())",
       "()()()"
     ]
```
**题解**

**第一种解法：暴力递归法**
建立一个2 * n的char数组，生成$2^{2n}$的包含 '(' ，')' 的序列，然后检查每一个是否有效，

考虑到递归的模板：
+ 1、递归终止的条件
+ 2、处理当前层
+ 3、深入到下一层
+ 4、恢复原来状态

暴力递归，生成2*n的char数组，可以设置一个数组长度指针pos，当指针到到达数组长度就终止递归
```java
public class Solution22_2 {
    //暴力递归法
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateParenthesishelpr(new char[2*n],0,result);
        return result;
    }

    private void generateParenthesishelpr(char[] current, int pos, List<String> result) {
        if (pos == current.length){
            if (valid(current)) {
                result.add(new String(current));
                return;
            }
        } else {
            current[pos] = '(';
            generateParenthesishelpr(current, pos + 1, result);
            current[pos] = ')';
            generateParenthesishelpr(current, pos + 1, result);
        }
    }

    private boolean valid(char[] current) {
        int balance = 0;
        for (char c : current){
            if (c == '(') balance++;
            if (c == ')') balance--;
            if (balance < 0) return false;
        }
        return balance == 0;
    }
}

```
**第二种解法：分治**

```java
class Solution {
    public List<String> generateParenthesis(int n) {

    }
}
```


### 8.2.3.leedcode题目：[226.翻转二叉树](https://leetcode-cn.com/problems/generate-parentheses/)

### 8.2.4.leedcode题目：[98.验证二叉搜索树](https://leetcode-cn.com/problems/validate-binary-search-tree/)

### 8.2.5.leedcode题目：[104.二叉树的最大深度](https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/)

+ 第一种解法：递归
```java
public class Solution104 {
    //递归，时间复杂度O(n)，空间复杂度O(height)
    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        } else {
            int leftHeight = maxDepth(root.left);
            int rightHeight = maxDepth(root.right);
            return Math.max(leftHeight,rightHeight) + 1;
        }
    }
}
```
```java
public class Solution104 {
    //递归
    public int maxDepth(TreeNode root) {

        if (root == null) return 0;

        int left_num = maxDepth(root.left);
        int right_num = maxDepth(root.right);

        return left_num>right_num ?left_num+1 : right_num+1;
    }
}
```
+ 第二种解法：广度优先遍历
```java

```


### 8.2.6.leedcode题目：[111.二叉树的最小深度](https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/)

+ 第一种解法：
```java
public class Solution111 {
    //递归
    public int minDepth(TreeNode root) {
        if (root == null) return 0;

        if (root.left == null && root.right == null) return 1;

        int minHeight = Integer.MAX_VALUE;
        if (root.right != null){
            minHeight = Math.min(minDepth(root.right),minHeight);
        }
        if (root.left != null){
            minHeight = Math.min(minDepth(root.left),minHeight);
        }
        return minHeight+1;
    }
}
```

### 8.2.7.leedcode题目：[297.二叉树的序列化和反序列化](https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/)

### 8.2.8.leedcode题目：[236.二叉树的最近公共祖先](https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/)

### 8.2.9.leedcode题目：[105.从前序与中序遍历序列构造二叉树](https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/)

### 8.2.10.leedcode题目：[77.组合](https://leetcode-cn.com/problems/combinations/)

### 8.2.11.leedcode题目：[46.全排列](https://leetcode-cn.com/problems/permutations/)

### 8.2.12.leedcode题目：[47.全排列II](https://leetcode-cn.com/problems/permutations-ii/)


# 9.分治、回溯的实现和特性

## 9.1.知识点

分治、回溯是特殊的递归，本质上是找重复性和拆解问题

**[分治代码模板](https://shimo.im/docs/zvlDqLLMFvcAF79A/read)**
```java
public int divide_conquer(Problem problem, ){
    // 递归终止条件
    if (problem == NULL) {
    int res = process_last_result();
    return res;
    }
    //准备数据
    subProblems = split_problem(problem);
    //处理子问题
    res0 = divide_conquer(subProblems[0]);
    res1 = divide_conquer(subProblems[1]);
    //处理并生成最终结果
    result = process_result(res0, res1);
    return result;
    //恢复当前级别状态
}
```

**回溯**

回溯法采用试错的思想，尝试分步解决一个问题，在分步解决问题的过程中，当尝试发现现有的分步答案不能得到有效的正确的解答的时候，就会取消上一步甚至上几步的计算，再通过其他可能的分步解答再次尝试寻找问题的答案。

回溯法通常用最简单的递归的方法来实现，再反复重复上述步骤后可能出现两种情况：
+ 找到一个可能存在的正确答案；
+ 在尝试了所有可能的分步方法后宣告该问题没有答案

在最坏的情况下，回溯法会导致一次复杂度为指数时间的计算。

**应用**：八皇后、数独

[牛顿迭代法原理](http://www.matrix67.com/blog/archives/361)

[牛顿迭代法代码](http://www.voidcn.com/article/p-eudisdmk-zm.html)

## 9.2.实战题目

### 9.2.1.leedcode题目：[22.括号生成问题](https://leetcode-cn.com/problems/generate-parentheses/)

+ 第一种解法：暴力求解
```java
class Solution22 {
    //暴力法
    public List<String> generateParenthesis1(int n){
        List<String> combinations = new ArrayList<>();
        generateAll(new char[2 * n], 0, combinations);
        return combinations;
    }
    private void generateAll(char[] current, int pos, List<String> result) {
        if (pos == current.length){
            if (valid(current)) result.add(new String(current));
        } else {
            current[pos] = '(';
            generateAll(current,pos + 1,result);
            current[pos] = ')';
            generateAll(current,pos+1,result);
        }
    }

    private boolean valid(char[] current) {
        int balance = 0;
        for (char c:current){
            if (c == '(') balance++;
            else  balance--;
            if (balance < 0) return false;
        }
        return (balance == 0);
    }
}
```
+ 第二种解法：回溯法
```java
class Solution22{
    //回溯法
    public List<String> generateParenthesis3(int n){
        List<String> ans = new ArrayList<>();
        backtrack(ans , new StringBuilder(), 0 ,0 ,n);
        return ans;
    }

    private void backtrack(List<String> ans, StringBuilder curr, int open, int close, int max) {
        if (curr.length() == max * 2){
            ans.add(curr.toString());
            return;
        }
        if (open < max){
            curr.append('(');
            backtrack(ans,curr,open+1,close,max);
            curr.deleteCharAt(curr.length() - 1);
        }
        if (close < open){
            curr.append(')');
            backtrack(ans, curr, open, close+1, max);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
    //回溯法
    public List<String> generateParenthesis2(int n) {
        List<String>  res = new ArrayList<>();
        StringBuilder s = new StringBuilder("");
        generate(res, s, 0, 0, n);
        return res;
    }

    private void generate(List<String> res, StringBuilder s, int left, int right, int n) {
        if (s.length() == n*2) {
            res.add(s.toString());
            return;
        }

        if (left < n){
            s.append("(");
            generate(res,s,left+1,right,n);
            s.deleteCharAt(s.length()-1);
        }
        if (right < left){
            s.append(")");
            generate(res,s,left,right+1,n);
            s.deleteCharAt(s.length()-1);
        }
    }

    //回溯法
    private List<String> res;
    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        _generate(0, 0, n, "");
        return res;
    }
    private void  _generate(int left, int right, int n, String s) {
        if (left == n && right == n) {
            res.add(s);
            return;
        }
        if (left < n)  _generate(left + 1, right, n, s + "(");
        if (left > right && right < n) _generate(left , right + 1, n, s + ")");
    }
}
```
+ 

### 9.2.2.leedcode题目：[50.Pow(x,n)](https://leetcode-cn.com/problems/powx-n/)

+ 第一种解法：快速幂+递归
```java
public class Solution50 {
    //快速幂+递归
    public double quickMul(double x, long N){
        if (N == 0) return 1.0;
        double y = quickMul(x , N / 2);
        return N % 2 == 0 ? y * y : y * y * x;
    }

    public double myPow(double x, int n){
        long N = n;
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }
}
```

+ 第二种解法：快速幂+迭代
```java
class Solution50{
   //快速幂+迭代
    public double quickMul2(double x, long N){
        double ans = 1.0;
        //贡献的初始值为x
        double x_contribute = x;
        //在对N进行二进制拆分的同时计算答案
        while (N > 0){
            if (N % 2 == 1){
                //如果N二进制表示的最低位为1，那么需要计入贡献
                ans *= x_contribute;
            }
            //将贡献不断平方
            x_contribute *= x_contribute;
            //舍弃N二进制表示的最低位，这样我们每次只要判断最低位即可
            N /= 2;
        }
        return ans;
    }
    public double myPow2(double x, int n){
        long N = n;
        return N >= 0 ? quickMul2(x, N) : 1.0 / quickMul2(x , -N);
    }
}
```

### 9.2.3.leedcode题目：[78.子集](https://leetcode-cn.com/problems/subsets/)

### 9.2.4.leedcode题目：[169.多数元素](https://leetcode-cn.com/problems/majority-element/description/)

### 9.2.5.leedcode题目：[17.电话号码的字母组合](https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/)

### 9.2.6.leedcode题目：[51.N皇后](https://leetcode-cn.com/problems/n-queens/)