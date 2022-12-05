package org.ds.implementations;

import java.util.*;

public class BinarySearchTree<V> {
    Comparator<? super V> comparator;
    BinaryTreeNodeEntry<V> root;

    public BinarySearchTree(Comparator<? super V> comparator) {
        this.comparator = comparator;
    }

    public BinaryTreeNodeEntry<V> getRoot() {
        return root;
    }

    public void addNode(V value) {
        BinaryTreeNodeEntry<V> node = new BinaryTreeNodeEntry<>(value);
        node.left = null;
        node.right = null;
        if (root == null) {
            root = node;
        } else {
            BinaryTreeNodeEntry<V> current = root;
            BinaryTreeNodeEntry<V> prev = null;
            String direction = "left";
            while (current != null) {
                prev = current;
                if (comparator.compare(node.value, current.value) <= 0) {
                    current = current.left;
                    direction = "left";
                } else {
                    current = current.right;
                    direction = "right";
                }
            }
            if (direction.equals("left"))
                prev.left = node;
            else
                prev.right = node;
        }
    }

    public BinaryTreeNodeEntry<V> searchNode(V value) {
        BinaryTreeNodeEntry<V> current = root;
        while (current != null) {
            if (comparator.compare(current.value, value) < 0) {
                current = current.left;
            } else if (comparator.compare(current.value, value) > 0) {
                current = current.right;
            } else {
                return current;
            }
        }
        return null;
    }

    /*
    Inorder traversal
     */
    public void printTree() {
        recursiveTraversalInOrder(root);
    }

    private void recursiveTraversalInOrder(BinaryTreeNodeEntry<V> node) {
        if (node != null) {
            recursiveTraversalInOrder(node.left);
            System.out.println(node.value + "->");
            recursiveTraversalInOrder(node.right);
        }
    }

    public static void main(String args[]) {
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 < o2 ? -1 : ((o1 == o2) ? 0 : 1);
            }
        });
        binarySearchTree.addNode(4);
        binarySearchTree.addNode(6);
        binarySearchTree.addNode(1);
        binarySearchTree.addNode(3);
        binarySearchTree.addNode(7);
        binarySearchTree.addNode(2);
        binarySearchTree.addNode(5);
        System.out.println("=====InOrder=======");
        binarySearchTree.printInOrderWithLooping(binarySearchTree.root);
        System.out.println("=====PostOrder=======");
        binarySearchTree.printPostOrder(binarySearchTree.root);
        System.out.println("=====PreOrder=======");
        binarySearchTree.printPreOrderWithLooping(binarySearchTree.root);
        System.out.println("====LevelOrder=======");
        binarySearchTree.printLevelOrderTraversal(binarySearchTree.root);
        System.out.println(binarySearchTree.searchNode(2) != null);
    }

    private void printPreOrder(BinaryTreeNodeEntry<V> node) {
        if (node != null) {
            System.out.println(node.value + "->");
            printPreOrder(node.left);
            printPreOrder(node.right);
        }
    }

    private void printPreOrderWithLooping(BinaryTreeNodeEntry<V> node) {
        Stack<BinaryTreeNodeEntry<V>> stack = new Stack<>();
        stack.push(node);
        while (!stack.empty()) {
            BinaryTreeNodeEntry<V> peeked = stack.pop();
            System.out.println(peeked.value + "->");
            if (peeked.right != null) stack.push(peeked.right);
            if (peeked.left != null) stack.push(peeked.left);
        }
    }

    private void printInOrderWithLooping(BinaryTreeNodeEntry<V> root) {
        Stack<BinaryTreeNodeEntry<V>> stack = new Stack<>();
        while (true) {
            BinaryTreeNodeEntry<V> peeked = stack.pop();
            if (peeked.right != null) stack.push(peeked.right);
            if (peeked.left != null) stack.push(peeked.left);
            BinaryTreeNodeEntry<V> popped = stack.pop();
            System.out.println(popped.value);
            root = popped.right;
        }
    }

    private void printPostOrderWithLooping(BinaryTreeNodeEntry<V> root) {
        Stack<BinaryTreeNodeEntry<V>> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (stack.isEmpty()) break;
            BinaryTreeNodeEntry<V> popped = stack.pop();
            System.out.println(popped.value);
            root = popped.right;
        }
    }

    private void printLevelOrderTraversal(BinaryTreeNodeEntry<V> node) {
        Queue<BinaryTreeNodeEntry<V>> queue = new ArrayDeque<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            BinaryTreeNodeEntry<V> polled = queue.poll();
            System.out.println(polled.value);
            if (polled.left != null) queue.add(polled.left);
            if (polled.right != null) queue.add(polled.right);
        }
    }

    private void printPostOrder(BinaryTreeNodeEntry<V> node) {
        if (node != null) {
            printPostOrder(node.left);
            printPostOrder(node.right);
            System.out.println(node.value + "->");
        }
    }
}
