public class Excercise6 {
    public static void main(String[] args) {
        System.out.print(squares(6));
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
