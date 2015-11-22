package Project5;

import java.util.Comparator;

/**
 * Created by Kai on 11/22/2015.
 */
public class BST<E> implements BSTInterface<String>{

    public void insert(E item){

    }
    public void remove(E item){

    }

    public boolean contains(E item){
        return false;

    }

}

interface BSTInterface<E extends Comparable<E>> {
    /**
     * Add item to binary tree
     * @param item
     */
     void insert(E item);

    /**
     * Remove item from binary search tree.
     * @param item
     */
    void remove(E item);

    /**
     * Check if binary tree contains an element.
     * @param item
     * @return true or false
     */
    boolean contains(E item);
}
