public class Driver {

  public static void main(String[] args) {
    // Create an instance of the stack with an integer type.
    Stack<Integer> s = new Stack<Integer>();
    // Push some values to the stack.
    s.push(new Integer(15));
    s.push(new Integer(27));
    // Print the value at the top of the stack.
    System.out.format("The value at the top of the stack is: %d\n", s.pop());
    System.out.format("The value at the top of the stack is: %d\n", s.peek());
    System.out.format("The size of the stack after popping an element is: %d\n", s.size());
  }

}

/**
* Node of a double linked list. Stores a value of type T and a 
* reference to the next value in the list and previous 
* value in the list.
**/
class Node<T> {
  
  /**
  * The value the node holds.
  **/
  private T t; 
  
  /**
  * References to the next node in the list and
  * the previous node in the list.
  **/
  private Node<T> next, prev;
  
  /**
  * Constructs a new linked list node.
  * @param value The value to store in the node.
  **/
  public Node(T value) {
    t = value;
    next = null;
    prev = null;
  }
  
  /**
  * Returns the value stored in this node.
  * @return the value stored in this node.
  **/
  public T getValue() {
    return t;
  }
  
  /**
  * Returns a reference to the next node in the list.
  * @return a reference to the next node in the list.
  **/
  public Node<T> getNext() {
    return next;
  }
  
  /**
  * Returns a reference to the previous node in the list.
  * @return a reference to the previous node in the list.
  **/
  public Node<T> getPrev() {
    return prev;
  }
  
  /**
  * Sets the next value of this node to refer to a given node.
  * @param n A node to link to this node.
  **/
  public void setNext(Node<T> n) {
    next = n;
  }
  
  /**
  * Sets the previous value of this node to refer to a given node.
  * @param n A node to link to this node.
  **/
  public void setPrev(Node<T> n) {
    prev = n;
  }
  
}

/**
* A simple stack structure implemented with generics.
**/
class Stack<T> {
  
  /**
  * The current node in the linked list.
  **/
  private Node<T> head;
  
  /**
  * The amount of elements on the stack.
  **/
  private int elements;
  
  /**
  * Creates a new stack data structure.
  **/
  public Stack() {
    head = null;
    elements = 0;
  }
  
  /**
  * Pushes a value onto the stack.
  * @param value The value to put on the stack.
  **/
  public void push(T value) {
    if(head == null) {
      head = new Node<T>(value);
    }
    else {
      head.setNext(new Node<T>(value));
      Node<T> temp = head;
      head = head.getNext();
      head.setPrev(temp);
    }
    elements++;
  }
  
  /**
  * Gets the value at the top of the stack without removing it from the structure.
  * @return The value at the top of the stack or null if the liswt is empty.
  **/
  public T peek() {
    return (head == null) ? null : head.getValue();
  }
  
  /**
  * Removes the value at the top of the stack.
  * @return The value at the top of the stack or null if the list is empty.
  **/
  public T pop() {
    if(head.getPrev() != null) { // marks empty list
      Node<T> temp = head;
      head = head.getPrev(); // Garbage collector should handle the rest.
      elements--;
      return temp.getValue();
    }
    return null;
  }
  
  /**
  * Returns the amount of values on the stack.
  * @return The size of the stack.
  **/
  public int size() {
    return elements;
  }
  
}