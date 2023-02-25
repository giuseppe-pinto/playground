package exercises.leetcode.validBinarySearchTree;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class BinaryTreeValidatorTest {

    private final BinaryTreeValidator binaryTreeValidator = new BinaryTreeValidatorInOrderTrasversal();

    @Test
    void aValidSimpleThreeNode() {

        TreeNode treeNode = new TreeNode(
                2,
                new TreeNode(1, null, null),
                new TreeNode(3, null, null)
        );

        boolean actual = binaryTreeValidator.isValidBST(treeNode);

        assertThat(actual).isTrue();
    }

    @Test
    void aNotValidSimpleThreeNode() {


        TreeNode treeNode = new TreeNode(
                2,
                new TreeNode(5, null, null),
                new TreeNode(3, null, null)
        );

        boolean actual = binaryTreeValidator.isValidBST(treeNode);

        assertThat(actual).isFalse();

    }

    @Test
    void aValidMultiThreeNode() {

        TreeNode treeNode = new TreeNode(
                10,
                new TreeNode(8, new TreeNode(6), new TreeNode(9)),
                new TreeNode(11, new TreeNode(5), new TreeNode(20))
        );

        boolean actual = binaryTreeValidator.isValidBST(treeNode);

        assertThat(actual).isFalse();

    }

    @Test
    void aNotValidMultiTreeNode() {

        TreeNode treeNode = new TreeNode(
                5,
                new TreeNode(1),
                new TreeNode(4, new TreeNode(3), new TreeNode(6))
        );


        boolean actual = binaryTreeValidator.isValidBST(treeNode);

        assertThat(actual).isFalse();

    }

    @Test
    void oneElementInTheTreeShouldBeAValidBinaryTree() {

        TreeNode treeNode = new TreeNode(5);

        boolean actual = binaryTreeValidator.isValidBST(treeNode);

        assertThat(actual).isTrue();

    }

    @Test
    void onlyOneLeftChild() {

        TreeNode treeNode = new TreeNode(
                1,
                new TreeNode(1),
                null);

        boolean actual = binaryTreeValidator.isValidBST(treeNode);

        assertThat(actual).isFalse();

    }

    @Test
    void aValidOnlyOneLeftChild() {

        TreeNode treeNode = new TreeNode(
                2,
                new TreeNode(1),
                null);

        boolean actual = binaryTreeValidator.isValidBST(treeNode);

        assertThat(actual).isTrue();

    }

    @Test
    void notAValidBinaryTreeDueToANodeLessThanTheRootInTheRightSide() {

        //[5,4,6,null,null,3,7]

        TreeNode treeNode = new TreeNode(5,
                new TreeNode(4),
                new TreeNode(6, new TreeNode(3), new TreeNode(7) )
        );


        boolean actual = binaryTreeValidator.isValidBST(treeNode);

        assertThat(actual).isFalse();

    }


    @Test
    void anotherTestCase() {

        //[32,26,47,19,null,null,56,null,27]

        TreeNode treeNode = new TreeNode(32,
                new TreeNode(26, new TreeNode(19, null, new TreeNode(27)), null),
                new TreeNode(47, null, new TreeNode(56) )
        );


        boolean actual = binaryTreeValidator.isValidBST(treeNode);

        assertThat(actual).isFalse();

    }


    @Test
    void anotherTestCase2() {

        //[98,-57,null,null,58,31]

        TreeNode treeNode = new TreeNode(98,
                new TreeNode(-57, null, new TreeNode(58, new TreeNode(31), null)),
                 null);


        boolean actual = binaryTreeValidator.isValidBST(treeNode);

        assertThat(actual).isTrue();

    }


    @Test
    void anotherTestCase3() {

        //[3,null,30,10,null,null,15,null,45]

        TreeNode treeNode = new TreeNode(3, null, new TreeNode(30, new TreeNode(10, null, new TreeNode(15, null, new TreeNode(45))), null));


        boolean actual = binaryTreeValidator.isValidBST(treeNode);

        assertThat(actual).isFalse();

    }




}