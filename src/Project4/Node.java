package Project4;

/**
 * Created by kaimou on 11/3/15.
 */
public class Node<E> {
    private Node<E> nextNode;
    private E data;


    public Node(E data){
        this.data = data;
    }
    public Node<E> getNextNode(){
        return nextNode;
    }
    public void setNextNode(Node<E> nextNode){
        this.nextNode = nextNode;
    }

    public E getData() {
        return data;
    }
}
