public class Excercise3 {
    public static void main(String[] args) {

    }
    //methods prints all even integers from n to 0
    public static void countDownEven(int n){
        if((n>0) && (n%2==0)){
            System.out.print(n + " ");
            countDownEven(n-1);
        }
        else if((n>0)){
            System.out.print( "  ");
            countDownEven(n-1);
        }
        if(n == 0){
            System.out.println("BLAST OFF");
        }
    }

}
