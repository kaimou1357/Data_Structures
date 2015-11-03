package Project4;

/**
 * Created by Kai on 11/1/2015.
 * Linked List based implementation of a Stack.
 * @author Kai
 * @Date 11/2/2015
 */
public class MyStack<E> {
    private Node<E> head;

    public MyStack(){
        //creates an empty head.
        //Head is already equal to null.
    }

    /**
     * Checks whether the linked list is empty or not.
     * @return
     */
    public boolean isEmpty(){
        return head == null;
    }
    /**}
     * Peeks the next data item on top of the stack (In the front of the linked list).
     */

    public E peek(){
        return head.getData();
    }
    public E pop(){
        E item = head.getData();
        head = head.getnextNode();
        return item;

    }

    /**
     * Checks whether the object is in the LinkedList or not.
     * @param o Object o.
     * @return
     */
    public int search(Object o){
        //TODO To be implemented later. 
        if(head == null){
            return -1;
        }

        Node<E> current = head;
        while(current.getnextNode()!=null){

        }
        return 0;
    }

    /**
     * Pushes an item on the stakc
     * @param item item
     */
    public void push(E item){
        Node<E> n = new Node(item);
        if(head == null){
            head = n;
        }
        else{
            n.setnextNode(head);
            head = n;
        }
    }



}
