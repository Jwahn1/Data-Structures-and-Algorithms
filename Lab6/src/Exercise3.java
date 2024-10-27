import java.util.*;
public class Exercise3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("countown from :");
        countDownEven(in.nextInt());
    }
    //methods prints all even integers from n to 0
    public static void countDownEven(int n){
        if((n>0)){
            System.out.print(n + " ");
            countDownEven(n-2);
        }
        if(n == 0 || n<0){
            System.out.println("BLAST OFF");
        }
    }

}
