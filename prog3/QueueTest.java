public class QueueTest{
  public static void main (String[] args){
    Queue A = new Queue();
    
    System.out.println(A.isEmpty());
 
    A.enqueue((int)4);
    A.enqueue((int)2);
    A.enqueue((int)3);
    A.enqueue((int)7);
    A.enqueue((int)6);
    A.enqueue((int)8);
    A.enqueue((int)9);
    A.enqueue((int)13);
    A.enqueue((int)17);
    A.enqueue((int)14);

   System.out.println(A.isEmpty());
   System.out.println(A.length());
    
    System.out.println(A);
    
    A.dequeue();
    A.dequeue();
    
    System.out.println(A.length());
    System.out.println(A);
    
    
  }
}
