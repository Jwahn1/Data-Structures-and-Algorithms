import java.util.*;
public class Exercise6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("find the sum of all squares from 0 to :");
        System.out.println(squares(in.nextInt()));
    }
    //takes a single positive integer n as a parameter and calculates the sum of the squares of all digits 1 through n.
    public static int squares(int n){
        if(n>0){
            return n*n + squares(n-1);
        }else{
            return 0;
        }

    }
}
