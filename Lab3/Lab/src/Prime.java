import java.lang.Math;
import java.util.Scanner;
public class Prime {

    //maybe write a for loop that goes through every number once, checks through modular calculation if
    //its divisible with anything but itself
    //if yes its not prime
    //otherwise add 1 to prime counter, if counter is equal to 11,101,1001,10001,100001 and 1000001 then we found what
    //was requested

    public static void main(String[] args) {


        //code snippet (or call to the method) here
        Scanner in = new Scanner(System.in);
        long primeCounter = 0;
        long iterator = 0;
        long userInput = in.nextInt();
        long startTime, endTime, executionTime;


        while(userInput != 0){

            startTime = System.currentTimeMillis();
            //we should have all user inputs ready here, now we just need to check
            while(primeCounter < userInput){

                if(isPrime(iterator)){
                    primeCounter++;
                }
                iterator++;


            }
            iterator--;


            endTime = System.currentTimeMillis();
            executionTime = endTime - startTime;

            //then printout the execution time here
            System.out.println(primeCounter + " " + iterator + " " + executionTime);




            primeCounter = 0;
            iterator = 0;
            userInput = in.nextInt();
        }



    }


    // Function to check whether a number is prime or not
    public static boolean isPrime(long n) {

        // Numbers less than or equal to 1 are not prime
        if (n <= 1)
            return false;

        // Check divisibility from 2 to the square root of n
        for (int i = 2; i <= Math.sqrt(n); i++)
            if (n % i == 0)
                return false;

        // If no divisors were found, n is prime
        return true;
    }
}
