

# 1.二叉树的遍历

## 1.1.[前序遍历](PreOrder.java)

### 1.1.1.递归法
```java
class PreOrder {
    //递归
    public List<Integer> PreOrderRecur(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        helper(root, ans);
        return ans;        
    }
    private void helper(TreeNode root, List<Integer> ans) {
        if ( root != null) {
            ans.add(root.val);
            if ( root.left != null) helper(root.left, ans);
            if ( root.right != null) helper(root.right, ans);
        }
    }
}
```

### 1.1.2.栈
```java
class PreOrder {
    //栈
    public List<Integer> PreOrderStack(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if( root == null) return ans;
        stack.add(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            ans.add(node.val);
            if (root.right != null) stack.add(root.right);
            if (root.left != null) stack.add(root.left);
        }
        return ans;
    }
}
```

## 1.2.[中序遍历](InOrder.java)

### 1.2.1.递归法
```java
class InOrder {
    //递归
    public List<Integer> InOrderRecur(TreeNode root) {
        final List<Integer> ans = new ArrayList<>();
        helper(root, ans);
        return ans;
    }
    private void helper(TreeNode root, List<Integer> ans) {
        if (root != null){
            if (root.left != null) helper(root.left, ans);
            ans.add(root.val);
            if (root.right != null) helper(root.right, ans);
        }
    }
}
```

### 1.2.2.栈
```java
class InOrder{
    //栈
    public List<Integer> InOrderStack(TreeNode root){
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while(curr != null && !stack.isEmpty()){
            while(curr != null){
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            ans.add(curr.val);
            curr = curr.right;
        }
        return ans;
    }
}
```

## 1.3.[后序遍历](PostOrder.java)

### 1.3.1.递归法
```java
class PostOrder {
    //递归
    public List<Integer> PostOrderRecur(final TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        helper(root, ans);
        return ans;
    }
    private void helper(final TreeNode root, final List<Integer> ans) {
        if (root != null) {
            if (root.left != null) helper(root.left, ans);
            if (root.right != null) helper(root.right, ans);
            ans.add(root.val);
        }
    }
}
```

### 1.3.2.栈
```java
class PostOrder{
    // 栈
    public List<Integer> PostOrderStack(final TreeNode root){
        LinkedList<Integer> ans = new LinkedList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        if (root == null) return ans;
        stack.add(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pollLast();
            ans.addFirst(node.val);
            if(node.left != null) stack.add(node.left);
            if(node.right != null) stack.add(node.right);
        }
        return ans;
    }
}
```
