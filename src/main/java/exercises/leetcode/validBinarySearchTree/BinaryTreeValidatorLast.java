package exercises.leetcode.validBinarySearchTree;

import java.util.TreeSet;

public class BinaryTreeValidatorLast implements BinaryTreeValidator {
    @Override
    public boolean isValidBST(TreeNode root) {
        if(root == null ) return false;
        return isValid(root, root.val);
    }


    private boolean isValid(TreeNode root, int val){

        if (root.left == null && root.right == null) {
            return true;
        } else if (root.left == null) {
            return checkAllRightChild(root.right, val);
        } else if (root.right == null) {
            return checkAllLeftChild(root.left, val);
        } else {
            return checkAllLeftChild(root.left, val) && checkAllRightChild(root.right,val);
        }

    }

    private boolean checkAllLeftChild(TreeNode root, int val) {
        boolean valid = false;
        TreeSet<Integer> allChildren = extractAllChildValues(root, new TreeSet<>());
        Integer maxChild = allChildren.last();

        if(maxChild< val){
            valid = isValid(root, root.val);
        }
        return valid;
    }

    private boolean checkAllRightChild(TreeNode root, int val) {
        boolean valid = false;
        TreeSet<Integer> allChildren = extractAllChildValues(root, new TreeSet<>());
        Integer maxChild = allChildren.first();

        if(maxChild > val){
            valid = isValid(root, root.val);
        }

        return valid;
    }


    private TreeSet<Integer> extractAllChildValues(TreeNode root, TreeSet<Integer> resultSet) {

        if (root.left == null && root.right == null) {
            resultSet.add(root.val);
            return resultSet;
        } else if (root.left == null) {
            resultSet.add(root.val);
            return extractAllChildValues(root.right, resultSet);
        } else if (root.right == null) {
            resultSet.add(root.val);
            return extractAllChildValues(root.left, resultSet);
        } else {
            resultSet.add(root.val);
            TreeSet<Integer> rightSet = extractAllChildValues(root.right, resultSet);
            TreeSet<Integer> leftSet = extractAllChildValues(root.left, resultSet);
            rightSet.addAll(leftSet);
            return rightSet;
        }

    }

}
