import java.util.*;



public class Question2 {
  
  // A static method that gets a queue of generic type(T) and returns the queue in reversed order 
  public static <T> Queue<T> reverseQueue(Queue<T> qu){
    
    Stack<T> st = new Stack<T>();//creating object of type Stack that will use us to reverse the order
    int length=qu.size();
    System.out.println(length);
    
    for (int i=0; i<length; i++)
      st.push(qu.poll());//cutting and copying from the queue into the stack
    
    for (int i=0; i<length; i++)
      qu.add(st.pop());// cutting and pasting back into the queue to obtain reversed order
   
    return qu;
  }
  
  /* The O() of the reverse method is O(n). The reason is that there are 2 loops inside of the method, each gives o(n). 
   However, the loops are not nested so as we know O(n)+O(n)=O(n). The rest of the commands such as: add, push,poll,pop are O(1) since we just 
   need to "touch" one element (the last or the first) in order to do these commands*/
  
  
  
  
  
  
  
  
  
  
 /* A static method that gets a stack of generic type(T) and returns a duplicate of the same stack. In addition, The original stack will remain
  int the same order.*/
  public static <T> Stack<T> copyStack(Stack<T> st){
    Queue<T> qu= new LinkedList<T>();// creating an object of type queue that will help us for our method
    Stack<T> duplicate = new Stack<T>();// creating the duplicate stack which we will need to return in the end
   
    int length=st.size();
     
    for (int i=0; i<length; i++)
      duplicate.push(st.pop());//cutting the elements from out stack and plugin them into the duplicate in reverse order
   
    for (int i=0; i<length; i++)
      qu.add(duplicate.pop()); //cutting the elements from our duplicate and plugin them into our queue back to the original order
    
    for (int i=0; i<length; i++){
       duplicate.push(qu.peek());/*Finally, we can plug in the elemnts  back to our stack and in the original order. notice: There is no deleting
                                  of the last element because we will need it in the next line*/
       st.push(qu.poll());     // Now, we can reobtain our original stack back to its original form
    }
     return duplicate;
       
  }
  
  
  /*The O() of this method is again O(n) where n is the size of our stack. Notice that however we have this time 3 for loops the Big O()
  remain O(n) since all the loops are not nested and O(n)+O(n)+O(n). Again, the rest of the commands, including the library methods inside the loop 
  are O(1) since they are just being activated on the first or the last elemnt. Size() can be also O(n) but it won't chabge the final answer.*/
  
  
  
  
  
  
  
  
  
  public static void main(String[]args){
     Stack<String> q= new Stack<String>();
        
     q.add("1");
     q.add("2");
     q.add("3");
     q.add("4");
     System.out.println(q.peek());
     q=copyStack(q);
     System.out.println(q.peek());
      
  }
}