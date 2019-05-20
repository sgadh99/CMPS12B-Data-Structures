public class Queue implements QueueInterface{
  
  
  private class Node{
    Object item;
    Node next;
    
    Node(Object item){
      this.item = item;
      next = null;
    }
  }
 
  private Node front;
  private Node back;
  private int numItems;
 
  Queue(){
    front = null;
    back  = null;
    numItems = 0;
  } 
 
  public boolean isEmpty(){
    return (numItems==0);
  }

  public int length(){
    return numItems;
  }
 
  public void enqueue(Object newItem){
    if(front == null){
      front = new Node(newItem);
      numItems++;
    }
    else{
      Node N = front;
      while( N.next != null){
        N = N.next;
      }
      N.next = new Node(newItem);
      back = N.next;
      numItems++;
    } 
  }
  
  public Object dequeue() throws QueueEmptyException{
    if(front == null){
      throw new QueueEmptyException("Usage: using dequeue() on empty queue stack");
    }
    else{
      Node N = front;
      front = N.next;
      numItems--;
      return N.item;
    }
  }
  
  public Object peek() throws QueueEmptyException{
    if(front == null){
      throw new QueueEmptyException("Usage: using peek() on empty queue stack");
    }
    else{
      return front.item;
    }
  }

  public void dequeueAll() throws QueueEmptyException{
    if(front == null){
      throw new QueueEmptyException("Usage: using dequeueAll() on empty queue stack");
    }
    else{
      front = null;
      back = null;
      numItems = 0;
    }
  }
 
  public String toString(){
    String s=""; 
    Node N = front;
    while(N != null){
      s += N.item + " " ;
      N = N.next;
    }
    return s;
  }
  
  
}
