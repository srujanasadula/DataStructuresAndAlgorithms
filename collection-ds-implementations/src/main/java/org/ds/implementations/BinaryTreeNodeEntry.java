package org.ds.implementations;

public final class BinaryTreeNodeEntry<V> {
    public BinaryTreeNodeEntry<V> left;
    public BinaryTreeNodeEntry<V> right;
    V value;

    public BinaryTreeNodeEntry(V value) {
        this.value = value;
    }

}
