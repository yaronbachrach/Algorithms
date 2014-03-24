//Class implementing the MergeSort algorithm with generic types
// Revised by Doina January 2014


package Sorting;
import java.lang.*;

public class MergeSort {
    
    // Wrapper method for the real algorithm
    // T is the generic type which will be instantiated at runtime
    //  elementas are required to be comparable
    public static <T extends Comparable<T>> void sort(T[] a) {
        mergesort(a, 0, a.length-1);
    }
    
    
    // Recursive mergesort method, following the pseudocode
    private static <T extends Comparable<T>> void mergesort (T[] a, int i, int j) {
 if (j-i < 1) return;
 int mid = (i+j)/2;
 mergesort(a, i, mid);
 mergesort(a, mid+1, j);
 merge(a, i, mid, j);
    }

    // Merge method
    // Here we need to allocate a new array, but Java does not allow allocating arrays of a generic type
    // As a work-around we allocate an array of type Object[] the use type casting
    // This would usually generate a warning, which is suppressed
    @SuppressWarnings("unchecked") private static <T extends Comparable<T>> void  merge(T[] a, int p, int mid, int q) {

 Object[] tmp = new Object[q-p+1]; 
 int i = p;
 int j = mid+1;
 int k = 0;
 while (i <= mid && j <= q) {
     if (a[i].compareTo(a[j])<=0)
  tmp[k] = a[i++];
     else
  tmp[k] = a[j++];
     k++;
 }
 if (i <= mid && j > q) {
     while (i <= mid) 
  tmp[k++] = a[i++];
 } else {
     while (j <= q)
  tmp[k++] = a[j++];
 }
 for (k = 0; k < tmp.length; k++) {
     a[k+p] = (T)(tmp[k]); // this is the line that woudl generate the warning 
 }
    }
    
    // Main methos to test the code, using Integer Objects
    public static void main(String[] args) {
        Integer[] a = new Integer[5];
        a[0] = new Integer(2);
        a[1] = new Integer(1);
        a[2] = new Integer(4);
        a[3] = new Integer(3);
 a[4] = new Integer(-1);
 String[] B={"gfdgfd","fdasdfd","fdsfds","ztty","adsfdsv"};
           
 // T will be instantiated to Integer as a resutl of this call
        MergeSort.sort(a);
        
 // Print the result after the sorting
       // for (int i = 0; i < a.length; i++)
     //       System.out.println(a[i].toString());
    }
}
   