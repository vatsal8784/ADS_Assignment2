package Main;

import java.util.Objects;

public class BinaryTreeNode<E> {
    private E element;
    private BinaryTreeNode<E> leftChild;
    private BinaryTreeNode<E> rightChild;

    public BinaryTreeNode(E element) {
        this.element = element;
        leftChild = null;
        rightChild = null;
    }

    public BinaryTreeNode(E element, BinaryTreeNode<E> leftChild, BinaryTreeNode<E> rightChild) {
        this.element = element;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public void setElement(E element) {
        this.element = element;
    }

    public E getElement() {
        return element;
    }

    public void addLeftChild(BinaryTreeNode<E> left) {
        this.leftChild = left;
    }

    public void addRightChild(BinaryTreeNode<E> right) {
        this.rightChild = right;
    }

    public BinaryTreeNode<E> getLeftChild(){
        return leftChild;
    }

    public BinaryTreeNode<E> getRightChild() {
        return rightChild;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BinaryTreeNode<?> that = (BinaryTreeNode<?>) o;
        return Objects.equals(getElement(), that.getElement()) && Objects.equals(getLeftChild(), that.getLeftChild()) && Objects.equals(getRightChild(), that.getRightChild());
    }

}