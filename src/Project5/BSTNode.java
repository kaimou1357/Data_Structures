package Project5;

/**
 * Created by Kai on 11/25/2015.
 * @author Kai Mou
 * @Date 11/25/2015
 *
 */
public class BSTNode<E> {
    E data;
    BSTNode<E> left;
    BSTNode<E> right;

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public BSTNode<E> getLeft() {
        return left;
    }

    public void setLeft(BSTNode<E> left) {
        this.left = left;
    }

    public BSTNode<E> getRight() {
        return right;
    }

    public void setRight(BSTNode<E> right) {
        this.right = right;
    }
}
