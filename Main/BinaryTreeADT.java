package Main;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeADT<E> {

    private BinaryTreeNode<E> root;
    private int size;

    public BinaryTreeADT() {
        root = null;
        size = 0;
    }

    public BinaryTreeADT(BinaryTreeNode<E> root, int size) {
        this.root = root;
        this.size = size;
    }

    public BinaryTreeNode<E> getRoot() {
        return root;
    }

    public void setRoot(BinaryTreeNode<E> root) {
        this.root = root;
    }

    public boolean isEmpty() {
        return root == null || root.getElement() == null;
    }

    public int size() {
        return size(root);
    }

    private int size(BinaryTreeNode<E> r) {
        if(r == null || r.getElement() == null) {
            return 0;
        }
        else {
            return size(r.getLeftChild()) + size(r.getRightChild()) +1;
        }
    }

    public boolean contains(E element) {
        return contains(root, element);
    }

    private boolean contains(BinaryTreeNode<E> root, E element) {
        if(root == null || root.getElement() == null)
            return false;
        return root.getElement().equals(element) || contains(root.getLeftChild(), element) ||
                contains(root.getRightChild(), element);
    }

    public ArrayList<E> inOrder() {
        ArrayList<E> elements = new ArrayList<>();
        return inOrder(elements, root);
    }

    private ArrayList<E> inOrder(ArrayList<E> list, BinaryTreeNode<E> root) {
        if(root == null) {
            return list;
        }
        inOrder(list,root.getLeftChild());
        list.add(root.getElement());
        inOrder(list,root.getRightChild());
        return list;
    }

    public ArrayList<E> preOrder() {
        ArrayList<E> elements = new ArrayList<>();
        return preOrder(elements, root);
    }

    private ArrayList<E> preOrder(ArrayList<E> list, BinaryTreeNode<E> root) {
        if(root == null) {
            return list;
        }
        list.add(root.getElement());
        preOrder(list,root.getLeftChild());
        preOrder(list,root.getRightChild());
        return list;
    }

    public ArrayList<E> postOrder() {
        ArrayList<E> elements = new ArrayList<>();
        return postOrder(elements, root);
    }

    private ArrayList<E> postOrder(ArrayList<E> list, BinaryTreeNode<E> root) {
        if(root == null) {
            return list;
        }
        postOrder(list,root.getLeftChild());
        postOrder(list,root.getRightChild());
        list.add(root.getElement());
        return list;
    }

    public ArrayList<E> levelOrder() {
        ArrayList<E> elements = new ArrayList<>();
        return levelOrder(elements, root);
    }

    private ArrayList<E> levelOrder(ArrayList<E> list, BinaryTreeNode<E> root) {
        Queue<BinaryTreeNode<E>> queue=new LinkedList<BinaryTreeNode<E>>();
        queue.add(root);
        while(!queue.isEmpty())
        {
            BinaryTreeNode<E> tempNode=queue.poll();
            list.add(tempNode.getElement());
            if(tempNode.getLeftChild()!=null)
                queue.add(tempNode.getLeftChild());
            if(tempNode.getRightChild()!=null)
                queue.add(tempNode.getRightChild());
        }
        return list;
    }

    private void atCurrentLevel(ArrayList<E> list, BinaryTreeNode<E> root, int level) {
        if(root == null)
            return;
        else if(level > 1) {
            list.add(root.getElement());
            atCurrentLevel(list, root.getLeftChild(), level - 1);
            atCurrentLevel(list, root.getRightChild(), level - 1);
        }
    }

    public int height() {

        return height(root,0);
    }

    private int height(BinaryTreeNode<E> root, int count) {
        if(root == null)
            return count - 1;
        int leftHeight = height(root.getLeftChild(), count+1);
        int rightHeight = height(root.getRightChild(), count+1) ;

        if(leftHeight > rightHeight)
            return leftHeight;
        else
            return rightHeight;
    }
}