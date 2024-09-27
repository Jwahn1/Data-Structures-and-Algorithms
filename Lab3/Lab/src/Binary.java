/*
Binary Number Generation
*/
/**
 This class tests the code for Exercise3. It calls a method that accepts a positive integer n
 and generates binary numbers between 0 and 2^n -1. The main method prints information about
 running time.
 */
import java.util.*;
public class Binary{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        long startTime, endTime, executionTime;
        int userInput = in.nextInt();

        startTime = System.currentTimeMillis();

        generateBinary(userInput);

        endTime = System.currentTimeMillis();

        executionTime = endTime - startTime;
        System.out.println(" binary numbers between 0 and " + (Math.pow(2,userInput)-1) + " time to run " + executionTime);
    }
    public static void generateBinary(int n){
        for (int i = 0; i < Math.pow(2,n)-1; i++) {
            //just do the binary conversion, dont print it
            Integer.toBinaryString(i);
        }
    }
}