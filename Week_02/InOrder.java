package Week_02;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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