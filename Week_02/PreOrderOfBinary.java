package Week_02;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jipan
 * @version 1.0
 * @date 2020/8/9 20:39
 */
public class PreOrderOfBinary {
    public List<Integer> preOrder(TreeNode root){
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        helper(root, ans);
        return ans;
    }

    private void helper(TreeNode root, List<Integer> ans) {
        ans.add(root.val);
        if (root.left != null){
            helper(root.left,ans);
        }
        if (root.right != null){
            helper(root.right,ans);
        }
    }
}

