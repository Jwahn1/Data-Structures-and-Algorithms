/*
Selection Sort
This class tests the code for Lab4: Exercise2. It calls the sort method to
sort an array of size n and prints information about running time.
*/
import java.util.*;
public class SelectionSort{
    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        Random rand = new Random();

        System.out.println("Please enter the size of the array");
        int arraySize = in.nextInt();

        int[] unsortedArray = new int[arraySize];
        int[] sortedArray;

        //create array here and fill it with random numbers
        //the range of random integers is from 1 to n
        for (int i = 0; i < arraySize  ; i++) {
            unsortedArray[i] = rand.nextInt(100);
            System.out.print(unsortedArray[i]+" ");
        }
        System.out.println("");


        long startTime, endTime, executionTime;
        startTime = System.currentTimeMillis();

        //call to the sort method
        sortedArray = sort(unsortedArray);

        for (int i = 0; i < arraySize  ; i++) {
            System.out.print(sortedArray[i]+" ");
        }

        endTime = System.currentTimeMillis();
        executionTime = endTime - startTime;

        System.out.println("\ntime to run " + executionTime + "ms");

        //display the executionTIme
    }
    public static int[] sort(int[] arr){
        //TODO
        //sort and return the integer arr of size n

        return arr;
    }
    //method swaps the value in [arrayPos] with the value in [ArrayPos+1] and places the value in [arrayPos] in [arrayPos+1]
    public static int[] swap(int[] array, int smallerNum, int largerNum, int arrayPos){
        array[arrayPos] = largerNum;
        array[arrayPos+1] = smallerNum;
        return array;
    }
}