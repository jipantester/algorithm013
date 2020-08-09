package Week_02;


import java.util.ArrayList;
import java.util.List;

/**
 * @author jipan
 * @version 1.0
 * @date 2020/8/9 20:15
 */

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}

public class PreOrderOfN {
    public List<Integer> preOrder(Node root){
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        helper(root,ans);
        return ans;
    }

    private void helper(Node root, List<Integer> ans) {
        if (root.children == null){
            ans.add(root.val);
            return;
        }
        ans.add(root.val);
        for (Node n : root.children){
            helper(n,ans);
        }
    }
}
