package exercises.leetcode.validBinarySearchTree;

import java.util.Stack;

public class BinaryTreeValidatorInOrderTrasversal implements BinaryTreeValidator {
    @Override
    public boolean isValidBST(TreeNode root) {

        if (root==null) return false;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while(root != null || !stack.empty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();

            if(pre != null && root.val <= pre.val) return false;
            pre = root;
            root = root.right;


        }

        return true;
    }
}
