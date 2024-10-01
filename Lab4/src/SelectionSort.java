//javier wahn
//B00935618

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


    //function uses selection sort to return a sorted version of the array
    public static int[] sort(int[] arr){

        int min_index =0;
        for (int i = 0; i < arr.length - 1; i++) {
            // Assume the current element is the minimum
            min_index = i;
            // Inner loop to find the minimum element in the unsorted part of the array
            for (int j = i+1; j < arr.length; j++) {
                // If we find a smaller element
                if(arr[j]<arr[min_index]){
                    // Update min_index to the new minimum element's index
                    min_index = j;
                }
            }
            // Swap the found minimum element with the element at index i
            swap(arr,arr[min_index],arr[i],min_index,i);
        }
        return arr;
    }


    //method swaps the value in [arrayPos] with the value in [min_index] and vice versa
    public static int[] swap(int[] array, int smallerNum, int largerNum,int minArrayPos,int arrayPos){
        array[arrayPos] = smallerNum;
        array[minArrayPos] = largerNum;
        return array;
    }
}