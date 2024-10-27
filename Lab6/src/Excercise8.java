import java.util.*;
public class Excercise8 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Count how many ways you can climb a stair with x steps:" );
        System.out.print(countWays(in.nextInt()));
    }

    //methods returns the amount of ways you can climb a stair with N steps
    public static int countWays(int n) {
       if(n == 1){
           return 1;
       }
       if(n == 2){
           return 2;
       }
       if(n == 3){
           return 4;
       }
       if(n>3){
           return countWays(n-1) + countWays(n-2) + countWays(n-3) ;
       }

       return 1;

    }
}
