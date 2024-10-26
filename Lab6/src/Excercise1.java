public class Excercise1 {
    public static void main(String[] args) {

        System.out.println(" factorial of 5 = " + factorial(5) );
        System.out.println(" the fibonacci sequence of 7 = " + fib(7) );
        System.out.println(" 2^8 = " + power(2,8) );
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
