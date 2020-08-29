package Week_02;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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