import java.util.*;
public class Exercise2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("countown from :");
        countDown(in.nextInt());
    }

    //methods prints all integers from n to 0
    public static void countDown(int n) {
        if (n > 0) {
            System.out.print(n + " ");
            countDown(n - 1);
        } else {
            System.out.println("BLAST OFF");
        }
    }

}
