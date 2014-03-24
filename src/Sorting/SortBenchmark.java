package Sorting;

import java.lang.*;
import java.util.Random;
public class SortBenchmark{
public static void main(String[]args) {
  
     
     int size= Integer.parseInt(args[0]);// getting the size of array from the command line
     
      Integer[] a= new Integer[size];// Creating an array of integer with the given size
    
      Random r = new Random(100);//implement the seed. i.e.: The numbers will be constant and won't change
       for(int i=0; i<size; i++)
            a[i]=r.nextInt(Integer.MAX_VALUE);//plug in into a the next integer "random" number between 0 to the max value possible on the type integer
     
       
       long time1=System.currentTimeMillis();
       QuickSort.sort(a);
       long time2=System.currentTimeMillis();
       long diff=time2-time1;
       System.out.println("The running time of quickSort is:"+ diff+" miili Seconds");
       
            r = new Random(100);
       for(int i=0; i<size; i++)
            a[i]=r.nextInt(Integer.MAX_VALUE);
       
            time1=System.currentTimeMillis();
       MergeSort.sort(a);
            time2=System.currentTimeMillis();
            diff=time2-time1;
       System.out.println("The running time of MergeSort  is:"+ diff+" miili Seconds");
      
             r = new Random(100);
       for(int i=0; i<size; i++)
            a[i]=r.nextInt(Integer.MAX_VALUE);
       
           time1=System.currentTimeMillis();
        SelectionSort.sort(a);
        time2=System.currentTimeMillis();
            diff=time2-time1;
       System.out.println("The running time of SelectionSort is:"+ diff+" miili Seconds");
       
       
       
       
       
    // for (int i=0; i<size; i++)
   //     System.out.println(a[i]);
 //   System.out.println(a.length);
           
    }
    
}