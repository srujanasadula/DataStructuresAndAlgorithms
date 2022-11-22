package main.java.org.ds.implementations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class ComputeBinaryTreeFromOrderTraversals {

    public static BinaryTreeNodeEntry<Integer> findTreeFromPostAndIn(List<Integer> inOrderTraversal, List<Integer> postOrderTraversal) {
        if (inOrderTraversal.size() == 1) {
            BinaryTreeNodeEntry<Integer> rootNode = new BinaryTreeNodeEntry<>(postOrderTraversal.get(0));
            rootNode.left = null;
            rootNode.right = null;
            return rootNode;
        }
        if (inOrderTraversal.size() == 0) return null;
        Integer rootValue = postOrderTraversal.get((postOrderTraversal.size() - 1));
        List<Integer> leftSubTreeInOrder = new ArrayList<>();
        List<Integer> rightSubTreeInOrder = new ArrayList<>();
        List<Integer> leftSubTreePostOrder = new ArrayList<>();
        List<Integer> rightSubTreePostOrder = new ArrayList<>();
        AtomicBoolean startRight = new AtomicBoolean(false);
        inOrderTraversal.forEach(i -> {
            if (i == rootValue) {
                startRight.set(true);
            } else {
                if (startRight.get()) {
                    rightSubTreeInOrder.add(i);
                } else {
                    leftSubTreeInOrder.add(i);
                }
            }
        });
        postOrderTraversal.forEach(i -> {
            if (i != rootValue) {
                if (leftSubTreeInOrder.contains(i)) {
                    leftSubTreePostOrder.add(i);
                } else {
                    rightSubTreePostOrder.add(i);
                }
            }
        });
        BinaryTreeNodeEntry<Integer> rootNode = new BinaryTreeNodeEntry<>(rootValue);
        rootNode.left = findTreeFromPostAndIn(leftSubTreeInOrder, leftSubTreePostOrder);
        rootNode.right = findTreeFromPostAndIn(rightSubTreeInOrder, rightSubTreePostOrder);
        return rootNode;
    }

    public static void main(String args[]) {
        List<Integer> postOrderTraversal = Arrays.asList(2, 3, 1, 5, 7, 6, 4);
        List<Integer> inOrderTraversal = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        List<Integer> preOrderTraversal = Arrays.asList(4, 1, 3, 2, 6, 5, 7);
        BinaryTreeNodeEntry<Integer> root = findTreeFromPostAndIn(inOrderTraversal,
                postOrderTraversal);
        BinaryTreeNodeEntry<Integer> root1 = findTreeFromPreAndIn(inOrderTraversal,
                preOrderTraversal);
        printTree(root);
        System.out.println("==========");
        printPreTree(root);
        System.out.println("==========");
        printPostTree(root);
        System.out.println("==========");
        printTree(root1);
        System.out.println("==========");
        printPreTree(root1);
        System.out.println("==========");
        printPostTree(root1);
    }

    private static BinaryTreeNodeEntry<Integer> findTreeFromPreAndIn(List<Integer> inOrderTraversal, List<Integer> preOrderTraversal) {
        if (inOrderTraversal.size() == 1) {
            BinaryTreeNodeEntry<Integer> rootNode = new BinaryTreeNodeEntry<>(preOrderTraversal.get(0));
            return rootNode;
        }
        if (inOrderTraversal.size() == 0) return null;
        Integer rootValue = preOrderTraversal.get(0);
        List<Integer> leftSubTreeInOrder = new ArrayList<>();
        List<Integer> rightSubTreeInOrder = new ArrayList<>();
        List<Integer> leftSubTreePreOrder = new ArrayList<>();
        List<Integer> rightSubTreePreOrder = new ArrayList<>();
        AtomicBoolean startRight = new AtomicBoolean(false);
        inOrderTraversal.forEach(i -> {
            if (i == rootValue) {
                startRight.set(true);
            } else {
                if (startRight.get()) {
                    rightSubTreeInOrder.add(i);
                } else {
                    leftSubTreeInOrder.add(i);
                }
            }
        });
        preOrderTraversal.forEach(i -> {
            if (i != rootValue) {
                if (leftSubTreeInOrder.contains(i)) {
                    leftSubTreePreOrder.add(i);
                } else {
                    rightSubTreePreOrder.add(i);
                }
            }
        });
        BinaryTreeNodeEntry<Integer> rootNode = new BinaryTreeNodeEntry<>(rootValue);
        rootNode.left = findTreeFromPreAndIn(leftSubTreeInOrder, leftSubTreePreOrder);
        rootNode.right = findTreeFromPreAndIn(rightSubTreeInOrder, rightSubTreePreOrder);
        return rootNode;
    }

    private static void printPreTree(BinaryTreeNodeEntry<Integer> node) {
        if (node != null) {
            System.out.println(node.value + "->");
            printPreTree(node.left);
            printPreTree(node.right);
        }
    }

    private static void printTree(BinaryTreeNodeEntry<Integer> node) {
        if (node != null) {
            printTree(node.left);
            System.out.println(node.value + "->");
            printTree(node.right);
        }
    }

    private static void printPostTree(BinaryTreeNodeEntry<Integer> node) {
        if (node != null) {
            printPostTree(node.left);
            printPostTree(node.right);
            System.out.println(node.value + "->");
        }
    }

}
