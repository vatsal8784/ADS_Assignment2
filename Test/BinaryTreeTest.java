package Test;

import Main.BinaryTreeADT;
import Util.Helper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {
    private Helper<Integer> helper;
    private BinaryTreeADT<Integer> binaryTree;
    @BeforeEach
    void setUp() {
        helper = new Helper<>();
        Integer[] list = {10, 7, 25, 1, 9, 15, 27,null, 2, 8, null, 13, 21, null, null, null, null, null, 3};
        binaryTree = helper.getTreeFromList(list);
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    public void preOrderTest(){
        ArrayList<Integer> inOrder = new ArrayList<>(Arrays.asList(10, 7, 1, 2, 3, 9, 8, 25, 15, 13, 21, 27));
        ArrayList<Integer> tree = binaryTree.preOrder();
        Assertions.assertEquals(inOrder, helper.removeNulls(tree));
    }

    @Test
    public void inOrderTest(){
        ArrayList<Integer> inOrder = new ArrayList<>(Arrays.asList(1, 2, 3, 7, 8, 9, 10, 13, 15, 21, 25, 27));
        ArrayList<Integer> tree = binaryTree.inOrder();
        Assertions.assertEquals(inOrder, helper.removeNulls(tree));
    }

    @Test
    public void postOrderTest(){
        ArrayList<Integer> inOrder = new ArrayList<>(Arrays.asList(3, 2, 1, 8, 9, 7, 13, 21, 15, 27, 25, 10));
        ArrayList<Integer> tree = binaryTree.postOrder();
        Assertions.assertEquals(inOrder, helper.removeNulls(tree));
    }

    @Test
    public void levelOrderTest(){
        ArrayList<Integer> inOrder = new ArrayList<>(Arrays.asList(10, 7, 25, 1, 9, 15, 27, 2, 8, 13, 21, 3));
        ArrayList<Integer> tree = binaryTree.levelOrder();
        Assertions.assertEquals(inOrder, helper.removeNulls(tree));
    }

    @Test
    public void heightTest(){
        assertEquals(4, binaryTree.height());
    }

    @Test
    public void containsTest(){
        assertTrue(binaryTree.contains(15));
    }
}