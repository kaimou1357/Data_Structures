package Project4;

/**
 * Created by kaimou on 11/3/15.
 * @author Kai
 * @Date 11/10/2015
 *
 */
public class Node<E> {
    private Node<E> nextNode;
    private E data;


    public Node(E data){
        this.data = data;
    }

    /**
     * Get the next node
     * @return
     */
    public Node<E> getNextNode(){
        return nextNode;
    }

    /**
     * Set the next node.
     * @param nextNode
     */
    public void setNextNode(Node<E> nextNode){
        this.nextNode = nextNode;
    }

    /**
     * Get the data from the node.
     * @return
     */
    public E getData() {
        return data;
    }
}
