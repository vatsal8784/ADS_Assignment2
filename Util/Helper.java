package Util;

import Main.BinaryTreeADT;
import Main.BinaryTreeNode;
import com.sun.source.tree.BinaryTree;

import java.util.ArrayList;
import java.util.Objects;

public class Helper<E extends Comparable<E>> {

    public BinaryTreeADT<E> getTreeFromList(E[] list){
        return new BinaryTreeADT<>(getTreeNode(list, 0), list.length);
    }

    private BinaryTreeNode<E> getTreeNode(E[] list, int index){
        if(index >= list.length) return null;

        return new BinaryTreeNode<E>(list[index], getTreeNode(list, 2*index + 1), getTreeNode(list, 2*index + 2));
    }

    public ArrayList<E> removeNulls(ArrayList<E> list){
        list.removeIf(Objects::isNull);
        return list;
    }
}