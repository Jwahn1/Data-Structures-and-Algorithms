public class Excercise4 {
    public static void main(String[] args) {
        multiples(2,5);
    }

    //method prints all the multiples of n from n x m to 0
    public static void multiples(int n,int m){
        if(m>0){
            System.out.print(n*m  + " ");
            multiples(n,m-1);
        }
    }
}
