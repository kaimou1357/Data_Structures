package Project4;

import java.util.EmptyStackException;

/**
 * Created by Kai on 11/1/2015.
 * Linked List based implementation of a Stack.
 * @author Kai Mou
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
        if(head == null){
            throw new EmptyStackException();
        }
        return head.getData();
    }

    /**
     * Returns the first item in LinkedList and removes the item.
     * @return
     */
    public E pop(){
        if(head == null){
            throw new EmptyStackException();
        }
        E item = head.getData();
        head = head.getNextNode();
        return item;

    }

    /**
     * Checks whether the object is in the LinkedList or not. Return -1 if error or not found.
     * @param o Object o.
     * @return
     */
    public int search(Object o){
        if(head == null){
            return -1;
        }
        int counter = 1;
        //base 1 search function.
        Node<E> current = head;
        while(current.getNextNode()!=null){
            if(current.equals(o)){
                return counter;
            }
            counter++;

        }
        return -1;
    }

    /**
     * Pushes an item on the stakc
     * @param item item
     */
    public E push(E item){
        Node<E> n = new Node(item);
        if(head == null){
            head = n;
        }
        else{
            n.setNextNode(head);
            head = n;
        }
        return item;
    }



}
