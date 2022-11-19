package main.java.org.ds.implementations;

import java.util.Comparator;

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
        binarySearchTree.addNode(5);
        binarySearchTree.addNode(1);
        binarySearchTree.addNode(3);
        binarySearchTree.addNode(2);
        binarySearchTree.addNode(2);
        binarySearchTree.printTree();
        System.out.println(binarySearchTree.searchNode(2) != null);
    }
}
