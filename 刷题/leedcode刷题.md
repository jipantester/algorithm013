- [Day1 70、爬楼梯](#day1-70爬楼梯)
- [Day11 412、Fizz Buzz](#day11-412fizz-buzz)
- [Day12 258、各位相加](#day12-258各位相加)
- [Day13 94、二叉树的中序遍历](#day13-94二叉树的中序遍历)



## Day1 [70、爬楼梯](https://leetcode-cn.com/problems/climbing-stairs/)

+ 第一种解法：递归
```java
 public static int climbStairs(int n) {
    if (n == 1) return 1;
    if (n == 2) return 2;
    return climbStairs(n - 1) + climbStairs(n - 2);
}
```
**复杂度**：复杂度太高，提交不能通过
+ 第二种解法：动态规划，在递归的基础上改为迭代
```java
public int climbStairs1(int n) {
    int a = 0, b = 0;
    int res = 1;
    for (int i = 0; i < n; i++) {
        a = b;
        b = res;
        res = a + b;
    }
    return res;
}
```
**复杂度**：时间复杂度O(n) 空间复杂度O(1)

+ 第三种解法：数学上矩阵幂法
下面是该方法的数学推导过程
![avatar](70爬楼梯矩阵幂法.jpg)
此程序需要创建矩阵的乘法和矩阵幂的函数
```java
public int climbStairs2(int n) {
    int[][] M = new int[][]{{1, 1}, {1, 0}};
    int[][] res = power(M, n);
    return res[0][0];
}

public int[][] power(int[][] m, int n) {
    int[][] e = new int[][]{{1, 0}, {0, 1}};
    int[][] res = multiply(e, m);
    for (int i = 1; i < n; i++) {
        res = multiply(res, m);
    }
    return res;
}

public int[][] multiply(int[][] a, int[][] b) {
    int[][] c = new int[2][2];
    for (int i = 0; i < 2; i++) {
        for (int j = 0; j < 2; j++) {
            c[i][j] = a[i][0] * b[0][j] + a[i][1] * b[1][j];
        }
    }
    return c;
}
```
**复杂度**：时间复杂度O(logn)，空间复杂度O(1)

+ 第四种解法：通项公式法

下面是通项公式法的推导过程
![avatar](70爬楼梯通项公式法.jpg)
```java
public int climbStairs3(int n){
    double sqar5 = Math.sqrt(5);
    double res = Math.pow((1+sqar5)/2,n+1) - Math.pow((1-sqar5)/2,n+1);
    return (int)(res / sqar5);
}
```
**复杂度**：时间复杂度：O(logn)，pow方法将会用去O(logn) 的时间。
空间复杂度：O(1)。

## Day11 [412、Fizz Buzz](https://leetcode-cn.com/problems/fizz-buzz/)
+ 第一种解法：遍历
  + 思路：
  + 1、初始化一个答案列表ans
  + 2、让i从1到n循环
  + 3、if i既是3的倍数又是5的倍数，把FizzBuzz加入答案列表
  + 4、if i是3的倍数，把Fizz加入答案列表
  + 5、if i是5的倍数，把Buzz加入答案列表
  + 6、都不是，就把数字本身加入答案列表
```java
public List<String> fizzBuzz(int n) {
    List<String> ans = new ArrayList<String>();
    for(int i = 1; i <= n ; i++) {
        if ( i % 3 == 0 && i % 5 == 0) {
            ans.add("FizzBuzz");
        } else if(i % 3 == 0) {
            ans.add("Fizz");
        } else if(i % 5 == 0) {
            ans.add(Integer.toString(i));
        }
    }
    return ans;
}
```
**复杂度**：时间复杂度O(n) 空间复杂度O(1)
+ 第二种解法：目的是减少循环次数，并没有降低复杂度
  
  先判断这个数是否是3的倍数，在判断是否是5的倍数，若是3的倍数，就把“Fizz”添加到答案字符里，若是5的倍数，再将“Buzz”添加到答案字符里，最后将答案字符添加到答案列表里
```java
public List<String> fizzBuzz2(int n){
    List<String> ans = new ArrayList<>();
    for (int i = 1; i <= n; i++) {
        String str = "";
        if (i % 3 == 0) {
            str += "Fizz";
        }
        if (i % 5 == 0) {
            str += "Buzz";
        }
        if (str.equals("")){
            str += Integer.toString(i);
        }
        ans.add(str);
    }
    return ans;
}
```
**复杂度**：时间复杂度O(n),空间复杂度O(1)
+ 第三种解法：哈希表
    + 初始化一个答案列表
    + 把映射关系写到一个哈希表fizzbuzzmap里{3：“Fizz”；5：“Buzz”}
    + 遍历1...N
    + 对于每一个数字，遍历fizzbuzzmap中的键值，检查是否可以被键值整除
    + 如果可以被这个键值整除，就将这个键值对应的字符，添加到答案字符串中，
    + 最后将答案字符串加到答案列表中
```java
public List<String> fizzBuzz3(int n){
    List<String> ans = new ArrayList<>();
    Map<Integer, String> fizzbuzzmap = new HashMap<>(){
        {
            put(3,"Fizz");
            put(5,"Buzz");
        }
    };
    for (int i = 1; i <= n; i++){
        String str = "";
        for (Integer k : fizzbuzzmap.keySet()){
            if (i % k == 0){
                str += fizzbuzzmap.get(k);
            }
        }
        if (str.equals("")){
            str += Integer.toString(i);
        }
        ans.add(str);
    }
    return ans;
}
```
**复杂度**：时间复杂度O(n) 空间复杂度O(1)

## Day12 [258、各位相加](https://leetcode-cn.com/problems/add-digits/)
+ 第一种解法：递归
  + 若num小于10，可直接返回
  + 创建一个辅助空间next，通过将num mod 10 得到个位上的数，num除10得到十位上的数，加和后赋值给next，
  + 递归调用这个函数
```java
public int addDigits(int num) {
    if (num < 10) {
        return num;
    }
    int next = 0;
    while (num != 0) {
        next = next + num % 10;
        num /= 10;
    }
    return addDigits(next);
}
```
+ 第二种解法：在递归的基础上做修改，使用迭代法
```java
public int addDigit2(int num){
    while (num >= 10){
        int next = 0;
        while (num != 0){
            next = next + num % 10;
            num /= 10;
        }
        num = next;
    }
    return num;
}
```
+ 第三种解法：[数学解法](https://leetcode-cn.com/problems/add-digits/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-5-7/)
  
要求的这个数，叫做[数根](https://baike.baidu.com/item/数根/4838735?fr=aladdin)，[数学解法](https://leetcode-cn.com/problems/add-digits/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-5-7/)中有详细的讲解
```java
public int addDigit3(int num){
    return 1 + (num-1) % 9 ;
}
```

## Day13 [94、二叉树的中序遍历](https://leetcode-cn.com/problems/binary-tree-inorder-traversal/)

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