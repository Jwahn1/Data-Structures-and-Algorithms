public class Excercise2 {
    public static void main(String[] args) {
        countDown(10);
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
