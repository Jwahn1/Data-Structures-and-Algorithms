import java.util.*;
public class Excercise1 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("find the factorial of: " );
        System.out.println("! = "+ factorial(in.nextInt()) );

        for(int i = 0 ; i < 20; i++){
            System.out.println(" the fibonacci sequence of "+ i +" = " + fib(i) );
        }
        System.out.println("calculate n^x, enter n then x: ");
        System.out.println("n^x = "+ power(in.nextInt(),in.nextInt()) );

    }
    //method returns the factorial of the given N via recursion.
    public static int  factorial(int n){

       if(n>0) {
        return n * factorial(n - 1);
       }
       return 1;
    }

    //method returns the fibonacci sequence for the given n
    public static int fib(int n){
        if(n==1){
            return 1;
        }else if(n>1){
            return fib(n-1)+fib(n-2);
        }
        return 0;
    }

    //method returns the result of n^x
    public static int power(int n, int x){
        if(n>0){
            return power(n-1,x)*x;
        }
        return 1;
    }
}
