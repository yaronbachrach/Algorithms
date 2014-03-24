//Class implementing the MergeSort algorithm with generic types
// Revised by Doina January 2014


package Sorting;
import java.lang.*;

public class QuickSort {
    
    // Wrapper method for the real algorithm
    // T is the generic type which will be instantiated at runtime
    //  elementas are required to be comparable
    public static <T extends Comparable<T>> void sort(T[] a) {
         quicksort(a, 0, a.length-1);
    }
    
    // Recursive quicksort method, following the pseudocode
    private static <T extends Comparable<T>> void quicksort (T[] a, int i, int j) {
      if (j-i < 1) return;
      
      int R= partition(a,i,j);//Calling the method partition plugin its return to R
      quicksort(a,i,R);   //Calling quickSort from i to R
      quicksort(a,R+1,j); //Calling quicksort from R+1 to j
      
    }

    // Partition method
    //Input: array a, indecies p,q
    //output: index R between p and q s.t for all i=<R, a[i]=<x and for all j>R a[j]>x for any x
    @SuppressWarnings("rawtypes")
    private static <T extends Comparable<T>> int partition(T[] a, int p, int q) {
      
      T first=(a[p]);
      T middle=a[(p+q)/2];
      T last=a[q];
      T median=last;
    
      // 3 nested if to find the median from the first, middle and last elements of our given array
      
      if ((last.compareTo(middle)>0) && (last.compareTo(first)>0)) //Last is the biggest
       if (middle.compareTo(first)>0) // So, we just left to compare between middle and first and to take the median as the bigger one
        median=middle;
       else
        median=first;
      
      if ((first.compareTo(middle)>0) && (first.compareTo(last)>0))//First is the biggest element
       if (middle.compareTo(last)>0)//// So, we just left to compare between middle and last and to take the median as the bigger one
        median=middle;
       else
        median=last;
      
      if ((middle.compareTo(first)>0) && (middle.compareTo(last)>0))//Middle is the biggest element
       if (first.compareTo(last)>0)//// So, we just left to compare between first and last and to take the median as the bigger one
        median=first;
       else
        median=last;
      
      
      
      
     //plugin in x our median
      T x=median;
     // System.out.println("tHE MEDIAM IS "+median);
      
      int i=p-1;
      int j=q+1;
      while (true)//this while will continue until i<j, i.e.: we found the index R
      {
        do{
             i++;
             if ((i>q) || (a[i].compareTo(x) >=0)) //we found an element on the wrong side and we need to replace it or we went over all the elements(worst case)
               break;
         }
        while(true);{}
        do{
            j--;
            if ((j<p) || (a[j].compareTo(x)<=0)) //we found an element on the wrong side and we need need to replace it or we went over all the elements(worst case) 
              break;
         }
        while(true);{}
        if (i<j)  
          SelectionSort.swap(a,i,j);//swaping the elemnts in the wrong side of the value x 
        else
          return j;// index j between p and q s.t for all k=<j, a[k]=<x and for all m>j a[j]>x for any x
      }  
  
        
      
}
    
    // Main methos to test the code, using Integer Objects
    public static void main(String[] args) {
        Integer[] a = new Integer[5];
        a[0] = new Integer(2);
        a[1] = new Integer(1);
        a[2] = new Integer(4);
        a[3] = new Integer(8);
        a[4] = new Integer(9);
        String[] B= {"abc","dwsw","gdgdf","aaa","zfsdf","fsfs","hiz","zzzz","zzz"};//testing to sort Strings as well
 
           
        //T will be instantiated to Integer as a result of this call
         sort(B);
        
        
     // Print the result after the sorting
      for (int i = 0; i < B.length; i++)
           System.out.println(B[i].toString());
    }
}