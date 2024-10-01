import java.util.*;
public class Exercise1 {
    public static void main(String[] args) {
        //variable init
        Scanner in  = new Scanner(System.in);
        System.out.println("Enter a positive integer:");
        long userInput = in.nextInt();
        long cLength = 1;
        long largestSequence= 0;
        long largestStart = 0;

        while(userInput!=0) {
            long startTime, endTime, executionTime;
            startTime = System.currentTimeMillis();

            //calculate the Collatz sequence for userInput and all integers below that value
            //also finds which starting value equal or less than userInput gives the longest Collatz sequence
            for (int i = 0; i < userInput; i++) {
                long startNum = userInput - i;
                while (startNum != 1) {
                    if (startNum % 2 == 0) {
                        startNum = startNum / 2;
                    } else {
                        startNum = (startNum * 3) + 1;
                    }
                    cLength++;
                }
                if (cLength > largestSequence) {
                    largestSequence = cLength;
                    largestStart = (userInput - i);

                }
                cLength = 1;
            }

            endTime = System.currentTimeMillis();
            executionTime = endTime - startTime;

            System.out.println(userInput +" " +  largestStart + " " + largestSequence+ " " + executionTime + "ms");
            userInput = in.nextInt();
        }

    }
}
