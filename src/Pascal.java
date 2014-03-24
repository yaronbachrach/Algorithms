public class Pascal {
  public static void main(String[] args) {
   int m=6;
   //int n=3;
   
   //2 for loops for printing the triangle in the question
   for (int i=0; i<m; i++){
     for (int j=0; j<=i; j++)
       System.out.print(" "+pascalTriangle(i,j));
      System.out.println();
   }
  }
  
  
  //A method which takes an argument two integers m,n and return for returns the number appearing in the n position of the m row. 
    public static int pascalTriangle (int m, int n)
    {
      if ((n<0) || (m<0) ) { //The case where the user type negative values
        System.out.println("Please enter number that are biger or equal to zero");
            return -1;
      }
      if (n==0) return 1;//this is a condition for the first column
      if (n>m) return 0;// This is for the case where are no elements(the upper right triangle)
      
     return(pascalTriangle(m-1,n-1)+pascalTriangle(m-1,n));// The recursion: The element will be equal to the one abpve it and the one above and to the left 
              
    }
    
}