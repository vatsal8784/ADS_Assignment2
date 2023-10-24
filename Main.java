import Model.BinaryTreeNode;

public class Main {

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(10);

        BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<>(5);
        root.addLeftChild(leftChild);

        BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<>(15);
        root.addRightChild(rightChild);

        BinaryTreePrint printer = new BinaryTreePrint();
        printer.printTree(root);
    }
}