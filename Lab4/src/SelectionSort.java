/*
Selection Sort
This class tests the code for Lab4: Exercise2. It calls the sort method to
sort an array of size n and prints information about running time.
*/
import java.util.*;
public class SelectionSort{
    public static void main(String[] args){
        //TODO
        //prompt the user to enter the value of n
        //create an integer array of size n with random integers
        //the range of random integers is from 1 to n
        long startTime, endTime, executionTime;
        startTime = System.currentTimeMillis();
        //call to the sort method
        endTime = System.currentTimeMillis();
        executionTime = endTime - startTime;
        //display the executionTIme
    }
    public static int[] sort(int[] arr){
        //TODO
        //sort and return the integer arr of size n
    }
    //method swaps the value in [arrayPos] with the value in [ArrayPos+1] and places the value in [arrayPos] in [arrayPos+1]
    public static int[] swap(int[] array, int smallerNum, int largerNum, int arrayPos){
        array[arrayPos] = largerNum;
        array[arrayPos+1] = smallerNum;
        return array;
    }
}