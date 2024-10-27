import java.util.*;
public class Excercise4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Show the first m multiples of n (input n, m)");
        multiples(in.nextInt(),in.nextInt());
    }

    //method prints all the multiples of n from n x m to 0
    public static void multiples(int n,int m){
        if(m>0){
            System.out.print(n*m  + " ");
            multiples(n,m-1);
        }
    }
}
