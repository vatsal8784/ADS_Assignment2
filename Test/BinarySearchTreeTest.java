package Test;

import Model.BinarySearchTree;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {

    private BinarySearchTree<Integer> binarySearchTree;

    @BeforeEach void setUp() {
        binarySearchTree = new BinarySearchTree<>();
    }

    @AfterEach void tearDown() {
        binarySearchTree = null;
    }

    // Zero

    @Test void canCreateTree() {
        assertNotNull(binarySearchTree);
        assertNull(binarySearchTree.getRoot());
    }

    @Test void removeNonExistingElement() {
        assertFalse(binarySearchTree.removeElement(1));
    }

    @Test void findMinNoElements() {
        assertNull(binarySearchTree.findMin());
    }

    @Test void findMaxNoElements() {
        assertNull(binarySearchTree.findMax());
    }

    @Test void containsNonExistingElement() {
        assertFalse(binarySearchTree.contains(1));
    }

    // One

    @Test void insertElement() {
        assertTrue(binarySearchTree.insert(1));
    }

    @Test void removeExistingElement() {
        binarySearchTree.insert(1);
        assertTrue(binarySearchTree.removeElement(1));
    }

    @Test void findMinOneElements() {
        binarySearchTree.insert(1);
        assertEquals(1, binarySearchTree.findMin());
    }

    @Test void findMaxOneElements() {
        binarySearchTree.insert(1);
        assertEquals(1, binarySearchTree.findMax());
    }

    @Test void containsExistingElements() {
        binarySearchTree.insert(1);
        assertTrue(binarySearchTree.contains(1));
    }

    // Many

    @Test void insertManyElements() {
        assertTrue(binarySearchTree.insert(2));
        assertTrue(binarySearchTree.insert(4));
        assertTrue(binarySearchTree.insert(1));
        assertTrue(binarySearchTree.insert(3));
        assertEquals(1, binarySearchTree.getRoot().getLeftChild().getElement());
        assertEquals(4, binarySearchTree.getRoot().getRightChild().getElement());
        assertEquals(3, binarySearchTree.getRoot().getRightChild().getLeftChild().getElement());
    }

    @Test void removeSituation1() {
        binarySearchTree.insert(2);
        binarySearchTree.insert(4);
        binarySearchTree.insert(1);
        binarySearchTree.insert(3);
        assertTrue(binarySearchTree.removeElement(3));
        assertNull(binarySearchTree.getRoot().getRightChild().getLeftChild());
    }

    @Test void removeSituation2() {
        binarySearchTree.insert(2);
        binarySearchTree.insert(4);
        binarySearchTree.insert(1);
        binarySearchTree.insert(3);
        assertTrue(binarySearchTree.removeElement(4));
        assertEquals(3, binarySearchTree.getRoot().getRightChild().getElement());
    }

    @Test void removeSituation3() {
        binarySearchTree.insert(2);
        binarySearchTree.insert(4);
        binarySearchTree.insert(1);
        binarySearchTree.insert(3);
        assertTrue(binarySearchTree.removeElement(2));
        assertEquals(3, binarySearchTree.getRoot().getElement());
    }

    @Test void findMinManyElements() {
        binarySearchTree.insert(2);
        binarySearchTree.insert(4);
        binarySearchTree.insert(1);
        binarySearchTree.insert(3);
        assertEquals(1, binarySearchTree.findMin());
    }

    @Test void findMaxManyElements() {
        binarySearchTree.insert(2);
        binarySearchTree.insert(4);
        binarySearchTree.insert(1);
        binarySearchTree.insert(3);
        assertEquals(4, binarySearchTree.findMax());
    }

    @Test void containsManyElements() {
        binarySearchTree.insert(2);
        binarySearchTree.insert(4);
        binarySearchTree.insert(1);
        binarySearchTree.insert(3);
        assertTrue(binarySearchTree.contains(3));
    }

    @Test void rebalanceLeftLeftTree() {
        binarySearchTree.insert(4);
        binarySearchTree.insert(5);
        binarySearchTree.insert(3);
        binarySearchTree.insert(2);
        binarySearchTree.insert(1);
        binarySearchTree.rebalance();
        assertEquals(3, binarySearchTree.getRoot().getElement());
        assertEquals(5, binarySearchTree.getRoot().getRightChild().getElement());
        assertEquals(2, binarySearchTree.getRoot().getLeftChild().getElement());
        assertEquals(4, binarySearchTree.getRoot().getRightChild().getLeftChild().getElement());
        assertEquals(1, binarySearchTree.getRoot().getLeftChild().getLeftChild().getElement());
    }

    @Test void rebalanceLeftRightTree() {
        binarySearchTree.insert(4);
        binarySearchTree.insert(5);
        binarySearchTree.insert(1);
        binarySearchTree.insert(3);
        binarySearchTree.insert(2);
        binarySearchTree.rebalance();
        assertEquals(3, binarySearchTree.getRoot().getElement());
        assertEquals(5, binarySearchTree.getRoot().getRightChild().getElement());
        assertEquals(2, binarySearchTree.getRoot().getLeftChild().getElement());
        assertEquals(4, binarySearchTree.getRoot().getRightChild().getLeftChild().getElement());
        assertEquals(1, binarySearchTree.getRoot().getLeftChild().getLeftChild().getElement());
    }

    @Test void rebalanceRightRightTree() {
        binarySearchTree.insert(2);
        binarySearchTree.insert(1);
        binarySearchTree.insert(3);
        binarySearchTree.insert(4);
        binarySearchTree.insert(5);
        binarySearchTree.rebalance();
        assertEquals(3, binarySearchTree.getRoot().getElement());
        assertEquals(5, binarySearchTree.getRoot().getRightChild().getElement());
        assertEquals(2, binarySearchTree.getRoot().getLeftChild().getElement());
        assertEquals(4, binarySearchTree.getRoot().getRightChild().getLeftChild().getElement());
        assertEquals(1, binarySearchTree.getRoot().getLeftChild().getLeftChild().getElement());
    }

    @Test void rebalanceRightLeftTree() {
        binarySearchTree.insert(2);
        binarySearchTree.insert(1);
        binarySearchTree.insert(5);
        binarySearchTree.insert(4);
        binarySearchTree.insert(3);
        binarySearchTree.rebalance();
        assertEquals(3, binarySearchTree.getRoot().getElement());
        assertEquals(5, binarySearchTree.getRoot().getRightChild().getElement());
        assertEquals(2, binarySearchTree.getRoot().getLeftChild().getElement());
        assertEquals(4, binarySearchTree.getRoot().getRightChild().getLeftChild().getElement());
        assertEquals(1, binarySearchTree.getRoot().getLeftChild().getLeftChild().getElement());
    }
}