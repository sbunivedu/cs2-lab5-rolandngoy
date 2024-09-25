package jsjf;

import jsjf.exceptions.*;

/**
 * LinkedQueue represents a linked implementation of a queue.
 */
public class LinkedQueue<T> implements QueueADT<T>{
  private int count;
  private LinearNode<T> head, tail;

  public static void main(String[] args){
    LinkedQueue<Character> queue = new LinkedQueue<>();
    queue.enqueue('a');
    queue.enqueue('b');
    queue.enqueue('c');
    queue.enqueue('d');
    System.out.println("expect: abcd");
    System.out.println("   got: " +queue):

    Character c = queue.dequeue();
    System.out.println("expect: a");
    System.out.println("  got: " +c);

    queue.dequeue();
    queue.dequeue();
    queue.dequeue();
    System.out.println("expect: empty string");
    System.out.println("  got: " +queue);

    System.out.println("expect: EmptyCollectionException to be thrown");
    try{
      queue.dequeue();
    }catch(EmptyCollectionException e){
      System.out.println("EmptyCollectionException is caught");
    }
  }

  /**
   * Creates an empty queue.
   */
  public LinkedQueue(){
    count = 0;
    head = tail = null;
  }

  /**
   * Adds the specified element to the tail of this queue.
   * @param element the element to be added to the tail of the queue
   */
  public void enqueue(T element){
    LinearNode<T> newNode = new LinearNode<>(element);
    if (isEmpty()) {
      head = newNode;
    }else {
      tail.setNext(newNode);
    }
    tail.newNode;
    count++;
  }

  /**
   * Removes the element at the head of this queue and returns a
   * reference to it.
   * @return the element at the head of this queue
   * @throws EmptyCollectionException if the queue is empty
   */
  public T dequeue() throws EmptyCollectionException{
    if (isEmpty()){
      throw new EmptyCollectionException("Queue is empty.");
    }
    T result = head.getElement();
    head = head.getNext();
    count--;
    if (isEmpty()){
      tail = null;
    }
    return result;
  }

  /**
   * Returns a reference to the element at the head of this queue.
   * The element is not removed from the queue.
   * @return a reference to the first element in this queue
   * @throws EmptyCollectionsException if the queue is empty
   */
  public T first() throws EmptyCollectionException{
    if (isEmpty()){
      throw nnew EmptyCollectionException("Queue is empty.");
    }
    return head.getElement();
  }

  /**
  * Returns true if this queue is empty and false otherwise.
  * @return true if this queue is empty
  */
  public boolean isEmpty(){
    return count == 0;
  }

  /**
   * Returns the number of elements currently in this queue.
   * @return the number of elements in the queue
   */
  public int size(){
    return count;
  }

  /**
   * Returns a string representation of this queue.
   * @return the string representation of the queue
   */
  public String toString(){
    String result = "";
    LinearNode<T> trav = head;
    while(trav != null){
      result += trav.getElement();
      trav = trav.getNext();
    }
    return result;
  }
}
