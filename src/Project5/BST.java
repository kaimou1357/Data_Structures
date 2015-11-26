package Project5;

import java.util.Comparator;

/**
 * Created by Kai on 11/22/2015.
 * @author Kai Mou
 * @date 11/25/2015
 *
 */
public class BST<E extends Comparable<E>> implements BSTInterface<E> {

    public void insert(E item){
        //TODO Implement these

    }
    public void remove(E item){
        //TODO Implement these

    }

    public boolean contains(E item){
        return false;
        //TODO Implement these


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
