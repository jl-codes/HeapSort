import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class HeapSort
{
   public static void sort( int[] a )
   {
      int i, j, next, help;

      next = 1;
      for (i = 2; i < a.length; i++)
      {
         next++;               // include next node
         HeapFilterUp(a, next);
         printHeap(a, next);  // comment this line out to skip printing the heap
      }

      System.out.println("Heap Constructed");

      for ( i = 1; i < a.length; i++ )
      {
         help = a[1];       // Delete root node

         a[1] = a[next];  // Replace root node with the last node

         a[next] = help;  // Put the deleted node in the empty slot

         next--;          // One less node in Heap 

         HeapFilterDown(a, 1, next);   // Fix the Heap

         printHeap(a, next);  // comment this line out to skip printing the heap
      }


      for ( i = 1, j = a.length-1; i < j; i++, j-- )
      {
         help = a[i];
	 a[i] = a[j];
	 a[j] = help;
      }

   }

 
   public static void HeapFilterUp( int[] a,  int k )
   {
      int parent;                 /* parent = parent */
      int help;

      while ( k != 0 )    /* k has a parent node */
      { /* Parent is not the root */

         parent = k/2;

         if ( a[k] < a[parent] )
         { 
            help = a[parent];
            a[parent] = a[k];
            a[k] = help;
            
            k = parent;          // k moved up one level
         }
         else
         {
            break;
         }

      }
   }
   
   public static void HeapFilterDown( int[] a, int k, int next )
   {
      int child1, child2, help;


      while ( 2*k <= next )
      {
         child1 = 2*k;                 // Child1 = left  child of k
         child2 = 2*k+1;               // Child2 = right child of k

         if ( child2 <= next )
         {
            /* 
	       Node k has 2 children nodes, find the min of 3 nodes
	        */
            if ( a[k] < a[child1] && a[k] < a[child2] )
            {               
               break;
            }
	    else 
            {	       
               if ( a[child1] < a[child2] )
               {                  
                  help = a[k];
                  a[k] = a[child1];
                  a[child1] = help;

                  k = child1;         // Replacement node is now a[child1]
               }
               else
               {                  
                  help = a[k];
                  a[k] = a[child2];
                  a[child2] = help;

                  k = child2;        // Replacement node is now a[child2]
               }
            }
         }
         else
         {            
            if ( a[k] < a[child1] )
            {               
               break;
            }
	    else 
            {               
               help = a[k];
               a[k] = a[child1];
               a[child1] = help;

               k = child1;         // Replacement node is now a[child1]
            }
         }
      }
   }


   /* ======================================================= */

   public static void printnode(int[] a, int n, int h)
   {
      for (int i = 0; i < h; i++)
         System.out.print("        ");

      System.out.println("[" + a[n] + "]");
   }

   public static void printHeap(int[] a, int next)
   {
      if ( next == 0 )
      {
         System.out.println("*** heap is empty");
         System.out.println("================================");
         return;
      }

      showR(a, 1, 0, next );
      System.out.println("================================");
   }

   public static void showR(int[] a, int n, int h, int next)
   {
      if (n > next)
         return;

      showR(a, 2*n+1, h+1, next);
      printnode(a, n, h);
      showR(a, 2*n, h+1, next);
   }

	static void shuffleArray(int[] scram)
  {
    // If running on Java 6 or older, use `new Random()` on RHS here
    Random rnd = ThreadLocalRandom.current();
    for (int i = scram.length - 1; i > 0; i--)
    {
      int index = rnd.nextInt(i + 1);
      // Simple swap
      int a = scram[index];
      scram[index] = scram[i];
      scram[i] = a;
    }
  }

   public static void main( String[] args )
   {
	  System.out.println("Example (a)");
      int[] x = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40} ;
      System.out.println("Before sort:  " + Arrays.toString(x) + "\n" );
      HeapSort.sort( x );  // Heap sort
      System.out.println("\nAfter sort:   " + Arrays.toString(x) );

	  System.out.println("\n" + "////////////////////////////////////////////////////" + "\n");
	  System.out.println("Example (b)");
	  int[] y = {40, 38, 36, 34, 32, 30, 28, 26, 24, 22, 20, 18, 16, 14, 12, 10, 8, 6, 4, 2, 1} ;
      System.out.println("Before sort:  " + Arrays.toString(y) + "\n" );
      HeapSort.sort( y );  // Heap sort
      System.out.println("\nAfter sort:   " + Arrays.toString(y) );

	  System.out.println("\n" + "////////////////////////////////////////////////////" + "\n");
	  System.out.println("Example (c)");
	  int[] z = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40} ;
      shuffleArray(z);
	  System.out.println("Before sort:  " + Arrays.toString(z) + "\n" );
      HeapSort.sort( z );  // Heap sort
      System.out.println("\nAfter sort:   " + Arrays.toString(z) );
   }


}
