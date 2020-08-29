package Week_02;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


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