public class Excercise8 {
    public static void main(String[] args) {
        System.out.print(countWays(5));
    }

    public static int countWays(int n){
        if(n>0){
            return countWays(n-1) + n-1;
        }
        return 1;
    }
}
