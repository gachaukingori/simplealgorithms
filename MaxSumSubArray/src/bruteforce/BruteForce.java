/*
author: 
date: 
n             time taken        
              ( BRUTE FORCE)        DIVIDE AND CONQUER
=======================================================
10      ||   3300                  ||       2200
100     ||   172400                ||       13410
1000    ||   1999800               ||       755700
10000   ||   44071600              ||       39457900
100000  ||   7369080700            ||       7362300100

The divide and conquer algorithm is faster compared to the brute force approach

When n  = 10  both algorithms share almost an equivalent execution time but as
the number of n increases the brute force time complexity  grows rapidly.
Given for instance an array of vector n = 10^3 = 1000
the time complexity of the brute force approach is n^2
1000 ^ 2  = 1,000,000
The execution time  = 1,999,800 

The divide and conquer algorithm complexity is (n log n) 
1000 (log 1000) = 3000
execution time = 755700
 


*/
package bruteforce;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
public class BruteForce {

    public static int bruteForce(Integer[] numArray) {
        int maxSum = Integer.MIN_VALUE; //Min value of an integer min infinity
      
      long startTime = System.nanoTime();
       long executionTime = 0; 
      long endTime = 0 ;
       for (int i = 0; i < numArray.length; i++) {
            int sum = 0;
            for (int j = i; j < numArray.length; j++) {
                sum += numArray[j];
                if (sum > maxSum) {
                    maxSum = sum;
                }
            }
           
        }
       endTime = System.nanoTime();
        executionTime =  endTime - startTime;
       
       System.out.println("The execution time of vector " + numArray.length+ " is " + executionTime+" nanoseconds");          
       
        return maxSum;

    } 
    
      public static int maxSubArray(Integer[] numArray, int low, int high) {
        long startTime = System.nanoTime();
        int maxSum ;
        long executionTime ;
        if (high == low) {
            return numArray[low];

        } else {
            int mid = (low + high) / 2;
            int leftSum = maxSubArray(numArray, low, mid);
            int rightSum = maxSubArray(numArray, mid + 1, high);
            int crossSum = maxCrossingSubArray(numArray, low, mid, high);
            maxSum = Math.max(Math.max(rightSum, leftSum), crossSum);
        }
        long endTime = System.nanoTime();
        executionTime= endTime - startTime;
          System.out.println("The execution time of vector: " + numArray.length + " is " + executionTime);
        return maxSum;
    }

    public static int maxCrossingSubArray(Integer[] numArray, int low, int mid, int high) {
        int leftSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = mid; i >= low; i--) {
            sum = sum + numArray[i];
            if (sum > leftSum) {
                leftSum = sum;
            }
        }
        int rightSum = Integer.MIN_VALUE;
        sum = 0;
        for (int j = mid + 1; j <= high; j++) {
            sum = sum + numArray[j];
            if (sum > rightSum) {
                rightSum = sum;
            }
        }
        
        return Math.max(leftSum + rightSum, Math.max(leftSum, rightSum));
    }
     public static Integer[] generateRandomList( int n){
         Random random = new Random();
            int[] numArray = new int[n];
             ArrayList list = new ArrayList();                        
             for(int i = 0; i<n; i++){                 
                 numArray[i] = random.nextInt();
                 list.add(numArray[i]); 
                 }
            System.out.println("the random array is: " +  Arrays.toString(list.stream().toArray( x -> new Integer[x])));
             
        return (Integer[]) list.toArray(new Integer[0]);
    }
  
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the size of vector n");
            int n = scanner.nextInt();
            long startTime = System.nanoTime();             
             Integer randomArray[] =generateRandomList(n);  
             System.out.println();
             System.out.println("*************** BRUTE FORCE ***************");
             int maxSum = bruteForce(randomArray);                          
          System.out.println("The maximum subarray of array  "+ maxSum); 
          System.out.println();
          
          System.out.println("*************** DIVIDE AND CONQUER ***************");
        int maxSumDivide = bruteForce(randomArray);                          
             System.out.println("The maximum subarray of array  "+ maxSumDivide); 
    }
     
   
}
