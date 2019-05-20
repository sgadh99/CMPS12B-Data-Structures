

public interface ListInterface<T>{

 
   public boolean isEmpty();


   public int size();

   
   public T get(int index) throws ListIndexOutOfBoundsException;


   public void add(int index, T newItem) throws ListIndexOutOfBoundsException;

   public void remove(int index) throws ListIndexOutOfBoundsException;

  
   public void removeAll();

}

