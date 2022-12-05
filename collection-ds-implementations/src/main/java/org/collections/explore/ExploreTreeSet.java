package org.collections.explore;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class ExploreTreeSet {
    public static void main (String args[]) {
        //We need not give this comparator, because this comparator is doing natural ordering
        //TreeSet by default follows natural ordering
        SortedSet<String> sortedSet = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        SortedSet<String> sortedSetReverse = new TreeSet<>(Comparator.reverseOrder());
        sortedSetReverse.add("Joe");
        sortedSetReverse.add("Alice");
        sortedSetReverse.add("Wonder");
        sortedSet.add("Joe");
        sortedSet.add("Alice");
        sortedSet.add("Wonder");
        System.out.println(sortedSet);
        System.out.println(sortedSetReverse);
    }
}
