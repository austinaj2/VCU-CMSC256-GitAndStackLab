import java.util.*;

public class ArrayBasedImplementation<T> implements StackInterface<T> {
   
   private T[] data;
   private int topOfStack;
   public static final int INITIAL_CAPACITY = 5;
   private boolean initialized;
   
   @SuppressWarnings("unchecked")
   public ArrayBasedImplementation(int cap)   {
      data = (T[])new Object[cap];
      topOfStack = -1;
      if(cap <= 0)
         throw new IllegalArgumentException("Capacity must be > 0.");
   }
   
   public ArrayBasedImplementation()   {
      this(INITIAL_CAPACITY);
   }
   
   private void helper()   {
      Arrays.copyOf(data, data.length*2);
   }
   /** Adds a new entry to the top of this stack.
       @param newEntry  An object to be added to the stack. */
   public void push(T newEntry)  {
      if(topOfStack >= data.length-1)  {
         helper();
      }   
      data[++topOfStack] = newEntry;
   }
  
   /** Removes and returns this stack's top entry.
       @return  The object at the top of the stack. 
       @throws  EmptyStackException if the stack is empty before the operation. */
   public T pop() {
      if(isEmpty()==true)
         throw new EmptyStackException();
      T result = data[topOfStack];
      data[topOfStack--] = null;
      return result;
   }
  
   /** Retrieves this stack's top entry.
       @return  The object at the top of the stack.
       @throws  EmptyStackException if the stack is empty. */
   public T peek()   {
      if(topOfStack == -1)
         throw new EmptyStackException();
      return data[topOfStack];
   }
  
   /** Detects whether this stack is empty.
       @return  True if the stack is empty. */
   public boolean isEmpty()   {
      if(topOfStack < 0)
         return true;
      return false;
   }  
  
   /** Removes all entries from this stack. */
   public void clear()  {
      topOfStack = -1;
   }
   
   public static void main(String[] args) {
      StackInterface<String> stack = new ArrayBasedImplementation(3);
      System.out.println(stack.isEmpty());
      stack.push("b");
      stack.push("e");
      stack.peek();
      stack.pop();
      stack.peek();
      stack.pop();
      stack.push("o");
      stack.pop();
      System.out.println(stack.isEmpty());
      stack.pop();
   }
}